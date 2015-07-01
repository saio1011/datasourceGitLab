package de.hska.wi.awp.datasource.gitlab.bean.loadData;

import java.io.IOException;
import java.util.Map;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import de.hska.wi.awp.datasource.gitlab.service.CommitLocalServiceUtil;
import de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil;


/**
 * 
 * @author Mihai Sava
 *
 */
public class GitLabScheduler implements MessageListener {
	
	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(GitLabScheduler.class);
	
	/**
	 * receives an Message every time the scheduler is called
	 *
	 * @param Message
	 */
	public void receive(Message arg0)
		throws MessageListenerException {

		// Here is the buisness logic to be written as per your requirement

		this.fillDatabase();

	}
	
	/**
	 * updates the database with new gitlab datas
	 * @author Mihai Sava
	 */
	public void fillDatabase(){
		
		log.info("Database will be reloaded from scheduler");
        //Load Contributors and Commits from GitLab
    	Map<String, String> contributorsAsJsonStringsWithProjectName = null;
    	Map<String, String> commitsAsJsonStringsWithProjectName = null;
		try {
			contributorsAsJsonStringsWithProjectName = ContributorLocalServiceUtil.getContributors();
			ContributorLocalServiceUtil.ParseContributorsFromJson(contributorsAsJsonStringsWithProjectName);
			
			commitsAsJsonStringsWithProjectName = CommitLocalServiceUtil.getAllCommitsAsJsonString();
			CommitLocalServiceUtil.ParseCommitsFromJson(commitsAsJsonStringsWithProjectName);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		log.info("Database is up do date");
		System.out.println("Database GitLab is now up to date from scheduler");
	}

}