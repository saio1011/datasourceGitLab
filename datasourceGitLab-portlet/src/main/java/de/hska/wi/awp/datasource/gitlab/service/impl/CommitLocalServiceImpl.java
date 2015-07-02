package de.hska.wi.awp.datasource.gitlab.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;

import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DonutChartModel;
import org.primefaces.model.chart.LineChartModel;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import de.hska.wi.awp.datasource.gitlab.model.Commit;
import de.hska.wi.awp.datasource.gitlab.model.Contributor;
import de.hska.wi.awp.datasource.gitlab.service.CommitLocalServiceUtil;
import de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil;
import de.hska.wi.awp.datasource.gitlab.service.base.CommitLocalServiceBaseImpl;
import de.hska.wi.awp.datasource.gitlab.service.persistence.CommitUtil;
import de.hska.wi.awp.datasource.gitlab.utils.Constants;
import de.hska.wi.awp.datasource.gitlab.utils.Helper;


/**
 * The implementation of the commit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link de.hska.wi.awp.datasource.gitlab.service.CommitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.gitlab.service.base.CommitLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.gitlab.service.CommitLocalServiceUtil
 */
public class CommitLocalServiceImpl extends CommitLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link de.hska.wi.awp.datasource.gitlab.service.CommitLocalServiceUtil} to access the commit local service.
     */
	
private static Log log = LogFactoryUtil.getLog(CommitLocalServiceImpl.class);
	
	/**
	 * rest call to get all commits from gitlab for all projects
	 * gitlab api has pagination and max entries pro page 
	 * !!!therefore pagination does not works properly, I implemented the pagination manually
	 * 
	 * parameters in getRequest: privateTocken, per_page=100, page=pageNumber
	 * 
	 * @param -
	 * @return Map<String,String> - json responses with all commits for project name
	 * @throws - IOException
	 * @author Mihai Sava
	 */
	public Map<String,String> getAllCommitsAsJsonString() throws IOException{
		log.debug("BEGIN: getAllCommitsAsJsonString");
		
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
			} catch (org.primefaces.json.JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//get Reguests for each repo
		Map<String,String> responsesWithProjectName = new HashMap<String, String>();
		for(Map.Entry<String, String> entry : reposIdsWithProjectName.entrySet()){
			String repoId = entry.getKey();
			String projectName = entry.getValue();
			String url = Constants.GITLAB_PATH_PROJECTS + repoId + Constants.GITLAB_PATH_COMMITS + "?" + private_token;
			
			Client client = Client.create();
			
			int pageNuber = 0;
			while(true){
				String newUrl = url+"&per_page=100&page="+pageNuber;
				
				WebResource webResource = client.resource(newUrl);

				ClientResponse response = webResource
						.type("application/json").accept("application/json")
						.get(ClientResponse.class);
				

				String responseBody = response.getEntity(String.class);
				
				pageNuber +=1;
				//check if are commits on the following page 
				if(responseBody.length()<3){
					String testUrl = url+"&per_page=100&page="+pageNuber;
					
					WebResource wResource = client.resource(testUrl);

					ClientResponse resp = wResource
							.type("application/json").accept("application/json")
							.get(ClientResponse.class);
					
					String respBody = resp.getEntity(String.class);
					
					if(respBody.length()<3){
						break;
					}
				}else{
					responsesWithProjectName.put(responseBody, projectName);
				}
			}
		}
		log.debug("END: getAllCommitsAsJsonString");
		return responsesWithProjectName;
	}
	
	/**
	 * parse commits form json objects and save the parsed object into database
	 * 
	 * @param Map<String,String> jsonCommits - all commits as string responses and projects names
	 * 
	 * @author Mihai Sava 
	 */
	public void ParseCommitsFromJson(Map<String,String> jsonCommitsResponsesWithProjectName){
		log.debug("BEGIN: ParseCommitsFromJson");
		
		try {
			CommitLocalServiceUtil.deleteAllCommits();
		} catch (SystemException e) {
			log.error("CommitLocalServiceUtil.deleteAllCommits() war nicht erfolgreich");
			e.printStackTrace();
		}
		
		for(Map.Entry<String, String> entry : jsonCommitsResponsesWithProjectName.entrySet()){
			String response = entry.getKey();
			String projectName = entry.getValue();
			JSONArray jsonArrayCommits = null;
			try {
				jsonArrayCommits = new JSONArray(response);
			} catch (JSONException e) {
				log.error("JSON -Parser Exception ");
				e.printStackTrace();
			}
			
			for (int zl = 0; zl<jsonArrayCommits.length(); zl++){
				Commit newCommit = null;
				try {
					newCommit = CommitLocalServiceUtil.createCommit(jsonArrayCommits.getJSONObject(zl).getString("id"));
					newCommit.setAuthorEmail(jsonArrayCommits.getJSONObject(zl).getString("author_email"));
					newCommit.setAuthorName(jsonArrayCommits.getJSONObject(zl).getString("author_name"));
					newCommit.setTitleCommit(jsonArrayCommits.getJSONObject(zl).getString("title"));
					newCommit.setCreatedAt(jsonArrayCommits.getJSONObject(zl).getString("created_at"));
					newCommit.setProjectName(projectName);
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					CommitLocalServiceUtil.addCommit(newCommit);
				} catch (SystemException e) {
					log.error("CommitLocalServiceUtil.addCommit(newCommit) war nicht erfolgreich");
					e.printStackTrace();
				}
			}
		}
		log.debug("END: ParseCommitsFromJson");
	}
	
    
	/**
	 * get number of commits for this project
	 * @param project id as string (example "AWP")
	 * @return number of commits as int
	 * 
	 * @author Mihai Sava
	 */
    public Integer getAllCommitsForProjectId(String projectName){
    	log.debug("BEGIN: getAllCommitsForProjectId");
    	
    	//get all Commits from this project
    	List<Commit> allCommitsForThisProject = null;
    	try {
    		allCommitsForThisProject = CommitUtil.findByProjectName(projectName);
		} catch (SystemException e) {
			log.error("CommitUtil.findByProjectName ist fehlgeschlagen");
			e.printStackTrace();
		}
    	
    	log.debug("END: getAllCommitsForProjectId");
    	
    	Integer anzahlCommits = allCommitsForThisProject.size();
    	return anzahlCommits;
    }
    
	/**
	 * delete all commits from the database
	 * 		this method is called before new commits are parsed and saved into database 
	 * 
	 * @param  -
	 * @return void
	 * @throws SystemException
	 * @author Mihai Sava
	 */
	public void deleteAllCommits() throws SystemException{
		log.debug("BEGIN: deleteAllCommits");
		List<Commit> allCommits = CommitLocalServiceUtil.getCommits(0, CommitLocalServiceUtil.getCommitsCount());
		for(Commit commit : allCommits){
			CommitLocalServiceUtil.deleteCommit(commit);
		}
		log.debug("END: deleteAllCommits");
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
	
	/**
	 * @author Mihai Sava
	 * 
	 * @param studentName
	 * @param projectName
	 * @return List<Commit> with all commits from this student
	 */
	public List<Commit> getAllCommitsForStudentNameAndProjectName(String studentName, String projectName){
		log.debug("BEGIN: getAllCommitsForStudentNameAndProjectName");
		
		List<Commit> allCommitsFromThisStudent = null;
		try {
			allCommitsFromThisStudent = CommitUtil.findByAuthorNameAndProjectName(studentName, projectName);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.debug("END: getAllCommitsForStudentNameAndProjectName");
		return allCommitsFromThisStudent;
	}
	
	/**
	 * @author Mihai Sava
	 * 
	 * @param projectName
	 * @return List<Commit> with all commits for this project
	 */
	public List<Commit> getAllCommitsForThisProject(String projectName){
		log.debug("BEGIN: getAllCommitsForThisProject");
		
    	List<Commit> allCommitsForThisProject = null;
    	try {
    		allCommitsForThisProject = CommitUtil.findByProjectName(projectName);
		} catch (SystemException e) {
			log.error("CommitUtil.findByProjectName ist fehlgeschlagen");
			e.printStackTrace();
		}
    	
    	log.debug("BEGIN: getAllCommitsForThisProject");
    	return allCommitsForThisProject;
	}	
}
