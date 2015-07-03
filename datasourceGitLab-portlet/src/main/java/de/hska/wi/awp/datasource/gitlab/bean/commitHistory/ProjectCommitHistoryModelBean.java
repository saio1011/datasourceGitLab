package de.hska.wi.awp.datasource.gitlab.bean.commitHistory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.DonutChartModel;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.hska.wi.awp.datasource.gitlab.model.Commit;
import de.hska.wi.awp.datasource.gitlab.model.Contributor;
import de.hska.wi.awp.datasource.gitlab.service.CommitLocalServiceUtil;
import de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil;
import de.hska.wi.awp.datasource.gitlab.service.persistence.CommitUtil;
/**
 * 
 * @author Mihai Sava
 *
 */

@ManagedBean(name = "projectCommitHistoryModelBean")
@SessionScoped
public class ProjectCommitHistoryModelBean implements Serializable{
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 3308514386036298980L;
	
	private String projectId;
	private Integer totalCommits;
	private DonutChartModel commitDistributionModel;
	
	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(ProjectCommitHistoryModelBean.class);


	public Integer getTotalCommits() {
		this.getNumberOfCommitsForThisProject(this.projectId);
		return totalCommits;
	}
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	public DonutChartModel getCommitDistributionModel() { 
		this.createCommitHistoryDistributionModel(this.projectId);
		return commitDistributionModel;
	}

	/**
	 * create Model for commit distribution 
	 * @param projectName
	 * 
	 * @author Mihai Sava
	 */
	private void createCommitHistoryDistributionModel(String projectName){
		log.info("CommitHistoryDistributionModel will be created");
		
		commitDistributionModel = initCommitDistributionModel(projectName);
		commitDistributionModel.setTitle("Verteilung - Commits pro Student");
		commitDistributionModel.setLegendPosition("w");
		commitDistributionModel.setSliceMargin(5);
		commitDistributionModel.setShowDataLabels(true);
		commitDistributionModel.setDataFormat("value");
		commitDistributionModel.setShadow(false);
		
		log.info("CommitHistoryDistributionModel is was created");
	}
	
	/**
	 * get number of commits for this project
	 * @param project id as string (example "AWP")
	 * @return number of commits as int
	 * 
	 * @author Mihai Sava
	 */
	public void getNumberOfCommitsForThisProject(String projectName){
		log.info("getNumberOfCommitsForThisProject will be set");
		
		Integer nrOfCommits = CommitLocalServiceUtil.getAllCommitsForProjectId(projectName);
		totalCommits = nrOfCommits;
		
		log.info("getNumberOfCommitsForThisProject it was set");
	}
	
	/**
     * init Model for commitHistory - Project site
     * @param String - project name (for example "AWP")
     * @return DonutChartModel - model
     * @author Mihai Sava
     */
    public DonutChartModel initCommitDistributionModel(String projectName){
    	log.debug("BEGIN: initCommitDistributionModel");
    	
    	DonutChartModel commitDistributionModel = new DonutChartModel();
    	Map<String, Number> circle1 = new LinkedHashMap<String, Number>();
    	
    	//get all Commits from this project
    	List<Commit> allCommitsForThisProject = CommitLocalServiceUtil.getAllCommitsForThisProject(projectName);
    	
    	//get all Contributors for all projects
    	List<Contributor> allContributors = null;
    	try {
			allContributors = ContributorLocalServiceUtil.getContributors(0, ContributorLocalServiceUtil.getContributorsCount());
		} catch (SystemException e) {
			log.error("ContributorLocalServiceUtil.getContributors ist fehlgeschlagen");
			e.printStackTrace();
		}
    	
    	//get only the contributors for this project
    	List<Contributor> allContributorsForActualProject = new ArrayList<Contributor>();
    	for(Contributor contributor : allContributors){
			if(contributor.getProjectName().equals(projectName)){
				allContributorsForActualProject.add(contributor);
			}
		}
    	
    	//set values in the model
    	for (Contributor contributor : allContributorsForActualProject){
    		int numberOfCommits = 0;
    		for (Commit commit : allCommitsForThisProject){
    			if(commit.getAuthorName().equals(contributor.getName())){
    				numberOfCommits += 1;
    			}
    		}
    		circle1.put(contributor.getName(), numberOfCommits);
    	}
    	
    	log.debug("END: initCommitDistributionModel");
    	
    	commitDistributionModel.addCircle(circle1);
    	return commitDistributionModel;
    }

}
