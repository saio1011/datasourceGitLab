package de.hska.wi.awp.datasource.gitlab.bean.loadData;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.hska.wi.awp.datasource.gitlab.service.CommitLocalServiceUtil;
import de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil;


@ManagedBean
@RequestScoped
public class GitLabLoadDataModelBean {
	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(GitLabLoadDataModelBean.class);
	
	/**
	 * @author Mihai Sava
	 */
	public void addGitLabMockData() {
		fillDatabase();
    }
     
	
	/**
	 * displays a Message to show the user the current status
	 * 
	 * @param String
	 *            , MessageText to display
	 */
    public void addMessage(String summary) {
    	System.out.println(summary);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * updates the database with new gitlab datas
     * 
     * @author Mihai Sava
     */
	public void fillDatabase(){
        addMessage("Datenbank GitLab wird neu geladen");
        log.info("Database will be reloaded manually");
		
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
		
		System.out.println("Database GitLab is now up to date");
        addMessage("Datenbank GitLab erfolgreich geladen");
        log.info("Database GitLab is now up to date");
	}

}
