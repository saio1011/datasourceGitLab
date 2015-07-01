package de.hska.wi.awp.datasource.gitlab.event;

import java.io.Serializable;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import com.liferay.faces.bridge.event.EventPayloadWrapper;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import de.hska.wi.awp.datasource.gitlab.NoSuchContributorException;
import de.hska.wi.awp.datasource.gitlab.bean.commitHistory.ProjectCommitHistoryModelBean;
import de.hska.wi.awp.datasource.gitlab.bean.commitHistory.StudentCommitHistoryModelBean;
import de.hska.wi.awp.datasource.gitlab.model.Contributor;
import de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil;


/**
 * EventHandler of the commitHistory - Portlet
 * @author Mihai Sava
 */
public class CommitHistoryEventHandler implements BridgeEventHandler{
	
	/**
	 * Logger Util
	 */
	private static Log log = LogFactoryUtil.getLog(CommitHistoryEventHandler.class);
	
	/**
	 * Handles the retrieved Event
	 * Either student event ipc.studentSelected or project event ipc.projectSelected
	 */
	@Override
	public EventNavigationResult handleEvent(FacesContext facesContext, Event event) {
		 EventNavigationResult eventNavigationResult = null;
         String eventQName = event.getQName().toString();

         if (eventQName.equals("{http://liferay.com/events}ipc.studentSelected")) {
             System.out.print("EVENT RECIVED STUDENT");
             log.info("Event Student recived");
             
             Serializable value = event.getValue();
             
            if (value instanceof EventPayloadWrapper) {
 				value = ((EventPayloadWrapper) value).getWrapped();
 			}

            //Finds the Student id and sets it in the StudentHistoryViewModelBean
            //Finds the Project id and sets it in the StudentHistoryViewModelBean
            //Sets the Porject id null in the ProjectHistoryModelBean
            //This way we can choose between the views in one portlet
 			String hskaId = (String) value;
 			StudentCommitHistoryModelBean studentHistoryModelBean = getStudentHistoryModelBean(facesContext);
 			studentHistoryModelBean.setStudenthskaId(hskaId);
// 			Student student = StudentLocalServiceUtil.findByStudenthskaId(hskaId);
// 			System.out.println("Print Student from handler ->" + student.getProject_id());
 	
// 			Project project = null;
//			try {
//				project = ProjectLocalServiceUtil.getProject(student.getProject_id());
//				System.out.println("Print Project from handler ->"+ project.getProjecthskaId());
//			} catch (SystemException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (PortalException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			studentHistoryModelBean.setProjecthskaId(project.getProjecthskaId());
 			
 			//workaround for the above implementation
 			//import of infosys service not found on the server
 			Contributor contributor = getCurrentUser(hskaId);
 			if(contributor == null){
 				studentHistoryModelBean.setProjecthskaId(null);
 			}else{
 				studentHistoryModelBean.setProjecthskaId(contributor.getProjectName());
 			}
 			
 			
 			ProjectCommitHistoryModelBean rojectCommitHistoryModelBean = getProjectHistoryModelBean(facesContext);
 			rojectCommitHistoryModelBean.setProjectId(null);

 			String fromAction = null;
 			String outcome = "ipc.studentSelected";
 			eventNavigationResult = new EventNavigationResult(fromAction, outcome);
 			
 			log.info("Event Student passed to the class");
             
         }

         if(eventQName.equals("{http://liferay.com/events}ipc.projectSelected")) {
        	 System.out.print("EVENT RECIVED PROJECT");
        	 log.info("Event Project recived");
        	 
        	 Serializable value = event.getValue();
             
             if (value instanceof EventPayloadWrapper) {
  				value = ((EventPayloadWrapper) value).getWrapped();
  			}

             //Finds the Project id and sets it in the ProjectHistoryModelBean
             //Sets the Student null in the StudentHistoryViewModelBean
             //This way we can choose between the views in one portlet
  			String hskaId = (String) value;
  			ProjectCommitHistoryModelBean projectHistoryModelBean = getProjectHistoryModelBean(facesContext);
  			projectHistoryModelBean.setProjectId(hskaId);
  			StudentCommitHistoryModelBean studentHistoryBean = getStudentHistoryModelBean(facesContext);
  			studentHistoryBean.setStudenthskaId(null);

  			String fromAction = null;
  			String outcome = "ipc.projectSelected";
  			eventNavigationResult = new EventNavigationResult(fromAction, outcome);
  			
  			log.info("Event Project passed to the class");
         }
         
         return eventNavigationResult;
	}
	
	/**
	 * get StudentHistoryModelBean
	 */
	protected StudentCommitHistoryModelBean getStudentHistoryModelBean(FacesContext facesContext) {
		String elExpression = "#{studentCommitHistoryModelBean}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, StudentCommitHistoryModelBean.class);

		return (StudentCommitHistoryModelBean) valueExpression.getValue(elContext);
	}
	
	/**
	 * get ProjectHistoryModelBean
	 */
	protected ProjectCommitHistoryModelBean getProjectHistoryModelBean(FacesContext facesContext) {
		String elExpression = "#{projectCommitHistoryModelBean}";
		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory().createValueExpression(
				elContext, elExpression, ProjectCommitHistoryModelBean.class);

		return (ProjectCommitHistoryModelBean) valueExpression.getValue(elContext);
	}
	
	protected Contributor getCurrentUser(String userId){
		Contributor contributor = null;
		try {
			contributor = ContributorLocalServiceUtil.getCurrentUser(userId);
		} catch (NoSuchContributorException e) {
			return null;
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return contributor;
	}
}
