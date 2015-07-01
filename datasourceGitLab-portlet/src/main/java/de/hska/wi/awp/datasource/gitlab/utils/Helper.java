package de.hska.wi.awp.datasource.gitlab.utils;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * 
 * @author Mihai Sava
 *
 */
public class Helper {
	
	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(Helper.class);
	
	/**
	 * get ProjectId for one repository name
	 * @author Mihai Sava
	 */
	public static String getProjectId(String projectName, String privateTocken) throws JSONException{
		log.debug("BEGIN: getProjectId");
		String url =Constants.GITLAB_FIND_POJECT_BY_NAME + projectName + "?" + privateTocken;
		
		Client client = Client.create();
		WebResource webResource = client.resource(url);

		ClientResponse response = webResource
				.type("application/json").accept("application/json")
				.get(ClientResponse.class);

		String responseBody = response.getEntity(String.class);
		
		JSONArray jsonArrayCommits = new JSONArray(responseBody);
		String projectId = "";
		for (int zl = 0; zl<jsonArrayCommits.length(); zl++){
			if(projectName.equals(jsonArrayCommits.getJSONObject(zl).getString("name")) && projectName.equals(jsonArrayCommits.getJSONObject(zl).getString("path"))){
				projectId = jsonArrayCommits.getJSONObject(zl).getString("id");
			}
		}
		
		log.debug("END: getProjectId");
		return projectId;
	}
}