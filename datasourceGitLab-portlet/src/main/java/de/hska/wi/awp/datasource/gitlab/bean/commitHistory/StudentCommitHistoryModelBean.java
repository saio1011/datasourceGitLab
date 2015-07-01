package de.hska.wi.awp.datasource.gitlab.bean.commitHistory;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.json.JSONException;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

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
 */

@ManagedBean(name = "studentCommitHistoryModelBean")
@SessionScoped
public class StudentCommitHistoryModelBean implements Serializable{
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -1342820644463262367L;
	
	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(StudentCommitHistoryModelBean.class);
	
	private LineChartModel lineCommitsHistory;
	private String nameStudent;
	private int numberOfCommits;
	private int locAdditions;
	private int locDeletions;
	private int numberOfContributors;
	private int numberOfTotalCommits;
	private int numberOfTotalAdditions;
	private int numberOfTotalDeletions;
	private String studenthskaId;
	private String projecthskaId;
	private String noContributor;

	 
	public int getNumberOfContributors() throws Exception {
		this.createHeaderModel(this.getStudenthskaId(), this.getProjecthskaId());
		return numberOfContributors;
	}

	public int getNumberOfCommits() {
		return numberOfCommits;
	}

	public int getLocAdditions() {
		return locAdditions;
	}

	public int getLocDeletions() {
		return locDeletions;
	}
	public String getNameStudent() {
		return nameStudent;
	}

	public int getNumberOfTotalCommits() {
		return numberOfTotalCommits;
	}

	public int getNumberOfTotalAdditions() {
		return numberOfTotalAdditions;
	}

	public int getNumberOfTotalDeletions() {
		return numberOfTotalDeletions;
	}
	public String getStudenthskaId() {
		return studenthskaId;
	}

	public void setStudenthskaId(String studenthskaId) {
		this.studenthskaId = studenthskaId;
	}

	public String getProjecthskaId() {
		return projecthskaId;
	}

	public void setProjecthskaId(String projecthskaId) {
		this.projecthskaId = projecthskaId;
	} 
	
	
	public String getNoContributor() {
		return noContributor;
	}

	public LineChartModel getLineCommitsHistory() throws SystemException, IOException, JSONException {
		this.createLineCommitsHistoryModel(this.getStudenthskaId(), this.getProjecthskaId());
		return lineCommitsHistory;
	}

	
	
	/**
	 * create Commit History Model
	 * 
	 * @param String studenName - this is the hs name
	 * @return void
	 * @throws SystemException, IOException, JSONException
	 * @author Mihai Sava
	 */
	private void createLineCommitsHistoryModel(String studentName, String projectId) throws SystemException, IOException, JSONException{
		log.info("LineCommitsHistoryModel will be created");
		
		lineCommitsHistory = initCommitHistoryModel(studentName, projectId);
		lineCommitsHistory.setTitle("Commit History");
		lineCommitsHistory.setLegendPosition("e");
		lineCommitsHistory.setShowPointLabels(true);
		lineCommitsHistory.getAxes().put(AxisType.X, new CategoryAxis("Zeitraum"));
        Axis yAxis = lineCommitsHistory.getAxis(AxisType.Y);
        yAxis.setLabel("Anzahl Commits");
        yAxis.setMin(0);
        
        log.info("LineCommitsHistoryModel was created");
	}
	
	/**
	 * init LineChartModel model for Commit History
	 * 	
	 * @param String studentName - this is the student hska name
	 * @param String projectName - this is the hska project id (for example "AWP")
	 * @return LineChartModel model - sorted by date
	 * @throws SystemException
	 * @author Mihai Sava 
	 */
   public LineChartModel initCommitHistoryModel(String studentName, String projectName) throws SystemException{
   	log.debug("BEGIN: initCommitHistoryModel");
   	LineChartModel model = new LineChartModel();
   	
   	List<Commit> allCommitsFromThisStudent = CommitLocalServiceUtil.getAllCommitsForStudentNameAndProjectName(studentName, projectName);
   	if(allCommitsFromThisStudent == null){
   		this.numberOfCommits = 0;
   		this.studenthskaId = null;
   	}
   	//set number of individual commits
   	this.numberOfCommits = allCommitsFromThisStudent.size();
   	
   	// get dates from commits 
   		//we take the first 8 characters from the date field as string
   	ArrayList<String> dates = new ArrayList<String>();
   	for (int zl = 0; zl< allCommitsFromThisStudent.size(); zl++){
   		if (zl == 0){
   			dates.add(allCommitsFromThisStudent.get(zl).getCreatedAt().toString().substring(0, 7));
   		}else{
   			if(!allCommitsFromThisStudent.get(zl).getCreatedAt().toString().substring(0, 7).equals(dates.get(dates.size()-1))){
   				dates.add(allCommitsFromThisStudent.get(zl).getCreatedAt().toString().substring(0, 7));
	    		}
   		}
   	}
   	
   	// sort the arraylist 
   	ArrayList<Date> datesSorted = new ArrayList<Date>();
   	ArrayList<String> datesAsStringSorted = new ArrayList<String>();
   	for(String date : dates){	
   		int month = Integer.parseInt(date.substring(5, 7));
   		int year = Integer.parseInt(date.substring(0, 4));
   		
   		Calendar calendar = Calendar.getInstance();
       	calendar.clear();
       	calendar.set(Calendar.MONTH, month-1);
       	calendar.set(Calendar.YEAR, year);
       	Date dateDate = calendar.getTime();
       	
       	datesSorted.add(dateDate);
   	}
   	
   	Collections.sort(datesSorted);
   	for(Date date : datesSorted){
   		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   		String dateString = dateFormat.format(date.getTime());
   		datesAsStringSorted.add(dateString.substring(0, 7));
   	}
   		
   	// create a hash-map with the aggregated number of commits pro month
   		// !!! the entries in the hash-map are not any more sorted 
   	Map<String, Integer> commitsMap = new HashMap<String, Integer>();
   	for(String date : datesAsStringSorted){
   		int zahl = 0;
   		for (int zl = 0; zl< allCommitsFromThisStudent.size(); zl++){
   			if(allCommitsFromThisStudent.get(zl).getCreatedAt().toString().startsWith(date.substring(0, 7))){
   				zahl += 1;
   			}
   		}
   		commitsMap.put(date, zahl);
   	}
   	
   	//set model with the sorted values 
   	ChartSeries student = new ChartSeries();
   	student.setLabel(studentName);
   	for(int zl = 0; zl < datesAsStringSorted.size(); zl++){
   		student.set(datesAsStringSorted.get(zl), commitsMap.get(datesAsStringSorted.get(zl)));
   	}
       model.addSeries(student);
       
       log.debug("END: initCommitHistoryModel");
   	
   	return model;
   }

	/**
     * create model for header values
     * 
     * @param String studentName - this is the hs name
     * @param String projectId - this is the project id (for example "AWP")
     * @return void
	 * @author Mihai Sava
	 * @throws Exception 
     */
    private void createHeaderModel(String studentName, String projectId) throws Exception{
    	log.info("HeaderModel will be created");
    	
    	//get all Contributors for all projects
		List<Contributor> allContributors = ContributorLocalServiceUtil.getContributors(0, ContributorLocalServiceUtil.getContributorsCount());
		
		//get only the contributors for this project
		List<Contributor> allContributorsForActualProject = new ArrayList<Contributor>();
		for(Contributor contributor : allContributors){
			if(contributor.getProjectName().equals(projectId)){
				allContributorsForActualProject.add(contributor);
			}
		}
		
		numberOfContributors = allContributorsForActualProject.size();
		
    	int totalLocAdditions = 0;
    	int tatalLocDeletions = 0;;
    	int totalCommits = 0;
    	boolean isCurrentUser = false;
    	//One Student can push into many repositories
    	//therfore I can have here a List of many "current user"
    	List<Contributor> currentUser = new ArrayList<Contributor>();
    	for (Contributor contributor : allContributorsForActualProject){
    		totalLocAdditions += contributor.getLocAdditions();
    		tatalLocDeletions += contributor.getLocDeletions();
    		totalCommits += contributor.getCommits();
    		
    		if(contributor.getName().equals(studentName)){ 
    			currentUser.add(contributor);
    			isCurrentUser = true;
    		}
    	}
    	
    	if(isCurrentUser){
//    		int nrOfCommits = 0;
    		int nrlocAdditions = 0;
    		int nrlocDeletions = 0;
    		for(Contributor currentUsr : currentUser){
//    			nrOfCommits += currentUsr.getCommits();
    			nrlocDeletions += currentUsr.getLocDeletions();
    			nrlocAdditions += currentUsr.getLocAdditions();
    		}

//    		numberOfCommits = nrOfCommits;
    		locAdditions = nrlocAdditions;
    		locDeletions = nrlocDeletions;
    		
    		noContributor = "";
    	}else{
    		noContributor = studentName + " ist kein Contributor";
    		numberOfCommits = 0;
    		locAdditions = 0;
    		locDeletions = 0;
    	}
    	
    	numberOfTotalAdditions = totalLocAdditions;
    	numberOfTotalDeletions = tatalLocDeletions;
    	numberOfTotalCommits = totalCommits;
    	
    	log.info("HeaderModel was created");
    }

}
