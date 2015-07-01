package de.hska.wi.awp.datasource.gitlab.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Contributor. This utility wraps
 * {@link de.hska.wi.awp.datasource.gitlab.service.impl.ContributorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ContributorLocalService
 * @see de.hska.wi.awp.datasource.gitlab.service.base.ContributorLocalServiceBaseImpl
 * @see de.hska.wi.awp.datasource.gitlab.service.impl.ContributorLocalServiceImpl
 * @generated
 */
public class ContributorLocalServiceUtil {
    private static ContributorLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link de.hska.wi.awp.datasource.gitlab.service.impl.ContributorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the contributor to the database. Also notifies the appropriate model listeners.
    *
    * @param contributor the contributor
    * @return the contributor that was added
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Contributor addContributor(
        de.hska.wi.awp.datasource.gitlab.model.Contributor contributor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addContributor(contributor);
    }

    /**
    * Creates a new contributor with the primary key. Does not add the contributor to the database.
    *
    * @param contributorId the primary key for the new contributor
    * @return the new contributor
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Contributor createContributor(
        long contributorId) {
        return getService().createContributor(contributorId);
    }

    /**
    * Deletes the contributor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contributorId the primary key of the contributor
    * @return the contributor that was removed
    * @throws PortalException if a contributor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Contributor deleteContributor(
        long contributorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContributor(contributorId);
    }

    /**
    * Deletes the contributor from the database. Also notifies the appropriate model listeners.
    *
    * @param contributor the contributor
    * @return the contributor that was removed
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Contributor deleteContributor(
        de.hska.wi.awp.datasource.gitlab.model.Contributor contributor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteContributor(contributor);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.ContributorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.ContributorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static de.hska.wi.awp.datasource.gitlab.model.Contributor fetchContributor(
        long contributorId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchContributor(contributorId);
    }

    /**
    * Returns the contributor with the primary key.
    *
    * @param contributorId the primary key of the contributor
    * @return the contributor
    * @throws PortalException if a contributor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Contributor getContributor(
        long contributorId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getContributor(contributorId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the contributors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.ContributorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contributors
    * @param end the upper bound of the range of contributors (not inclusive)
    * @return the range of contributors
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Contributor> getContributors(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContributors(start, end);
    }

    /**
    * Returns the number of contributors.
    *
    * @return the number of contributors
    * @throws SystemException if a system exception occurred
    */
    public static int getContributorsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getContributorsCount();
    }

    /**
    * Updates the contributor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param contributor the contributor
    * @return the contributor that was updated
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Contributor updateContributor(
        de.hska.wi.awp.datasource.gitlab.model.Contributor contributor)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateContributor(contributor);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    /**
    * rest call to get all contributors (from gitlab) - from all projects
    * gitlab api has pagination and max entries pro page
    *
    * @param -
    * @return Map<String,String> - json responses with all contributors and project names
    * @throws IOException
    * @author Mihai Sava
    */
    public static java.util.Map<java.lang.String, java.lang.String> getContributors()
        throws java.io.IOException {
        return getService().getContributors();
    }

    /**
    * parse contributors to java objects and save the parsed objects into database
    *
    * @param Map<String,String> jsonContributorsResponsesWithProjectName - all contributors as json responses for each project name
    * @return void
    * @throws JSONException, SystemException
    * @author Mihai Sava
    */
    public static void ParseContributorsFromJson(
        java.util.Map<java.lang.String, java.lang.String> jsonContributorsResponsesWithProjectName) {
        getService()
            .ParseContributorsFromJson(jsonContributorsResponsesWithProjectName);
    }

    /**
    * get current user
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Contributor getCurrentUser(
        java.lang.String studentName)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchContributorException {
        return getService().getCurrentUser(studentName);
    }

    /**
    * delete all contributors from the database
    *                 this method is called before new contributors are parsed and saved into database
    *
    * @param -
    * @return void
    * @throws SystemException
    * @author Mihai Sava
    */
    public static void deleleAllContributors()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleleAllContributors();
    }

    /**
    * load Property File
    *
    * @author Mihai Sava
    */
    public static java.util.Properties loadConfigFile() {
        return getService().loadConfigFile();
    }

    public static void clearService() {
        _service = null;
    }

    public static ContributorLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    ContributorLocalService.class.getName());

            if (invokableLocalService instanceof ContributorLocalService) {
                _service = (ContributorLocalService) invokableLocalService;
            } else {
                _service = new ContributorLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(ContributorLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(ContributorLocalService service) {
    }
}
