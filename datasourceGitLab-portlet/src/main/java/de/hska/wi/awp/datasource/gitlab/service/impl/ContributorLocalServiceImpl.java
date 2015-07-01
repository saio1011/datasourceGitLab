package de.hska.wi.awp.datasource.gitlab.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import de.hska.wi.awp.datasource.gitlab.NoSuchContributorException;
import de.hska.wi.awp.datasource.gitlab.model.Contributor;
import de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil;
import de.hska.wi.awp.datasource.gitlab.service.base.ContributorLocalServiceBaseImpl;
import de.hska.wi.awp.datasource.gitlab.service.persistence.ContributorUtil;
import de.hska.wi.awp.datasource.gitlab.utils.Constants;
import de.hska.wi.awp.datasource.gitlab.utils.Helper;


/**
 * The implementation of the contributor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.hska.wi.awp.datasource.gitlab.service.ContributorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.gitlab.service.base.ContributorLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil
 */
public class ContributorLocalServiceImpl extends ContributorLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil} to access the contributor local service.
     */
	
	
	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(ContributorLocalServiceImpl.class);

	
	/**
	 * rest call to get all contributors (from gitlab) - from all projects
	 * gitlab api has pagination and max entries pro page
	 * 
	 * @param -
	 * @return Map<String,String> - json responses with all contributors and project names
	 * @throws IOException
	 * @author Mihai Sava
	 */
	public Map<String,String> getContributors() throws IOException{
		log.debug("BEGIN: getContributors");
		
		Properties configFile = this.loadConfigFile();
		String private_token = "private_token="+configFile.getProperty("private_token");
		
		int anzahlProjekte = Integer.parseInt(configFile.getProperty("AnzahlProjekte"));
		List<String> projektNamen = new ArrayList<String>();
		for(int zl=1; zl<=anzahlProjekte; zl++){
			projektNamen.add(configFile.getProperty("ProjektName"+zl));
		}
		
		//get number of repositories for each project
		Map<String,Integer> anzahlReposProjekt = new HashMap<String, Integer>();
		for(String projektName : projektNamen){
			anzahlReposProjekt.put(projektName, Integer.parseInt(configFile.getProperty(projektName+"_AnzahlRepos")));
		}
		
		//get names of repositories		
		Map<String,String> reposNamesWithProjectName = new HashMap<String, String>();
		for (Map.Entry<String, Integer> entry : anzahlReposProjekt.entrySet()) {
			String key = entry.getKey();
		    int value = entry.getValue();
		    for(int zl = 1; zl <= value; zl++){
		    	reposNamesWithProjectName.put(configFile.getProperty(key+"_Repo"+zl), key);
		    }
		}
		
		//get repos Ids
		Map<String,String> reposIdsWithProjectName = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : reposNamesWithProjectName.entrySet()) {
			String repoName = entry.getKey();
			String projectName = entry.getValue();
			try {
				String repoId = Helper.getProjectId(repoName, private_token);
				reposIdsWithProjectName.put(repoId, projectName);
			} catch (JSONException e) {
				log.error("Helper.getProjectId fehlgeschlagen");
				e.printStackTrace();
			}
		}
		
		//get Reguest for each repo
		Map<String,String> responsesWithProjectName = new HashMap<String, String>();
		for(Map.Entry<String, String> entry : reposIdsWithProjectName.entrySet()){
			String repoId = entry.getKey();
			String projectName = entry.getValue();
			String url = Constants.GITLAB_PATH_PROJECTS + repoId + Constants.GITLAB_PATH_CONTRIBUTORS + "?" + private_token + "&per_page=100";
			
			Client client = Client.create();
			WebResource webResource = client.resource(url);
			
			ClientResponse response = webResource
					.type("application/json").accept("application/json")
					.get(ClientResponse.class);
	
			String responseBody = response.getEntity(String.class);
			responsesWithProjectName.put(responseBody, projectName);
		}
		log.debug("END: getContributors");
		return responsesWithProjectName;
	}
	
	/**
	 * parse contributors to java objects and save the parsed objects into database
	 * 
	 * @param Map<String,String> jsonContributorsResponsesWithProjectName - all contributors as json responses for each project name
	 * @return void
	 * @throws JSONException, SystemException
	 * @author Mihai Sava
	 */
	public void ParseContributorsFromJson(Map<String,String> jsonContributorsResponsesWithProjectName){
		log.debug("BEGIN: ParseContributorsFromJson");
		
		try {
			ContributorLocalServiceUtil.deleleAllContributors();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int kreisNr = 100;
		for(Map.Entry<String, String> entry : jsonContributorsResponsesWithProjectName.entrySet()){
			String response = entry.getKey();
			String projectName = entry.getValue();
			
			JSONArray jsonArrayContributors = null;
			try {
				jsonArrayContributors = new JSONArray(response);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			for (int zl = 0; zl<jsonArrayContributors.length(); zl++){
				Contributor newContributor = ContributorLocalServiceUtil.createContributor(kreisNr+zl+1);
				try {
					newContributor.setCommits(jsonArrayContributors.getJSONObject(zl).getInt("commits"));
					newContributor.setEmail(jsonArrayContributors.getJSONObject(zl).getString("email"));
					newContributor.setName(jsonArrayContributors.getJSONObject(zl).getString("name"));
					newContributor.setLocAdditions(jsonArrayContributors.getJSONObject(zl).getInt("additions"));
					newContributor.setLocDeletions(jsonArrayContributors.getJSONObject(zl).getInt("deletions"));
					newContributor.setProjectName(projectName);
					ContributorLocalServiceUtil.addContributor(newContributor);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SystemException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			kreisNr += 100;
		}
		log.debug("END: ParseContributorsFromJson");
	}
	
	/**
	 * get current user
	 */
	public Contributor getCurrentUser(String studentName) throws NoSuchContributorException, SystemException{
		log.debug("BEGIN: getCurrentUser");
		
		Contributor currentStudent = ContributorUtil.findByName(studentName);
		
		log.debug("END: getCurrentUser");
		return currentStudent;
	}
	
	/**
	 * delete all contributors from the database
	 * 		this method is called before new contributors are parsed and saved into database 
	 * 
	 * @param  -
	 * @return void
	 * @throws SystemException
	 * @author Mihai Sava
	 */
	public void deleleAllContributors() throws SystemException{
		log.debug("BEGIN: deleleAllContributors");
		
		List<Contributor> allContributors = ContributorLocalServiceUtil.getContributors(0, ContributorLocalServiceUtil.getContributorsCount());
		
		for(int zl = 0; zl < allContributors.size(); zl++){
			ContributorLocalServiceUtil.deleteContributor(allContributors.get(zl));
		}
		
		log.debug("END: deleleAllContributors");
	}
	
	
	/**
	 * load Property File
	 * @author Mihai Sava
	 */
	public Properties loadConfigFile(){
		log.debug("BEGIN: loadConfigFile");
		
    	Properties prop = new Properties();
    	InputStream input = null;
    	
    	try {
    		 
    		String filename = "gitLab.properties";
    		input = getClass().getClassLoader().getResourceAsStream(filename);
    		if (input == null) {
    			System.out.println("Sorry, unable to find " + filename);
    			return null;
    		}
     
    		prop.load(input);
    		
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
        			input.close();
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        }
    	log.debug("END: loadConfigFile");
    	return prop;
    }
}
