package de.hska.wi.awp.datasource.gitlab.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommitLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CommitLocalService
 * @generated
 */
public class CommitLocalServiceWrapper implements CommitLocalService,
    ServiceWrapper<CommitLocalService> {
    private CommitLocalService _commitLocalService;

    public CommitLocalServiceWrapper(CommitLocalService commitLocalService) {
        _commitLocalService = commitLocalService;
    }

    /**
    * Adds the commit to the database. Also notifies the appropriate model listeners.
    *
    * @param commit the commit
    * @return the commit that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Commit addCommit(
        de.hska.wi.awp.datasource.gitlab.model.Commit commit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.addCommit(commit);
    }

    /**
    * Creates a new commit with the primary key. Does not add the commit to the database.
    *
    * @param commitId the primary key for the new commit
    * @return the new commit
    */
    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Commit createCommit(
        java.lang.String commitId) {
        return _commitLocalService.createCommit(commitId);
    }

    /**
    * Deletes the commit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param commitId the primary key of the commit
    * @return the commit that was removed
    * @throws PortalException if a commit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Commit deleteCommit(
        java.lang.String commitId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.deleteCommit(commitId);
    }

    /**
    * Deletes the commit from the database. Also notifies the appropriate model listeners.
    *
    * @param commit the commit
    * @return the commit that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Commit deleteCommit(
        de.hska.wi.awp.datasource.gitlab.model.Commit commit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.deleteCommit(commit);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _commitLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.CommitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.CommitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Commit fetchCommit(
        java.lang.String commitId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.fetchCommit(commitId);
    }

    /**
    * Returns the commit with the primary key.
    *
    * @param commitId the primary key of the commit
    * @return the commit
    * @throws PortalException if a commit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Commit getCommit(
        java.lang.String commitId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.getCommit(commitId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the commits.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.CommitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of commits
    * @param end the upper bound of the range of commits (not inclusive)
    * @return the range of commits
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> getCommits(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.getCommits(start, end);
    }

    /**
    * Returns the number of commits.
    *
    * @return the number of commits
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getCommitsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.getCommitsCount();
    }

    /**
    * Updates the commit in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param commit the commit
    * @return the commit that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Commit updateCommit(
        de.hska.wi.awp.datasource.gitlab.model.Commit commit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _commitLocalService.updateCommit(commit);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _commitLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _commitLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _commitLocalService.invokeMethod(name, parameterTypes, arguments);
    }

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
    @Override
    public java.util.Map<java.lang.String, java.lang.String> getAllCommitsAsJsonString()
        throws java.io.IOException {
        return _commitLocalService.getAllCommitsAsJsonString();
    }

    /**
    * parse commits form json objects and save the parsed object into database
    *
    * @param Map<String,String> jsonCommits - all commits as string responses and projects names
    * @author Mihai Sava
    */
    @Override
    public void ParseCommitsFromJson(
        java.util.Map<java.lang.String, java.lang.String> jsonCommitsResponsesWithProjectName) {
        _commitLocalService.ParseCommitsFromJson(jsonCommitsResponsesWithProjectName);
    }

    /**
    * get number of commits for this project
    *
    * @param project id as string (example "AWP")
    * @return number of commits as int
    * @author Mihai Sava
    */
    @Override
    public java.lang.Integer getAllCommitsForProjectId(
        java.lang.String projectName) {
        return _commitLocalService.getAllCommitsForProjectId(projectName);
    }

    /**
    * delete all commits from the database
    *                 this method is called before new commits are parsed and saved into database
    *
    * @param -
    * @return void
    * @throws SystemException
    * @author Mihai Sava
    */
    @Override
    public void deleteAllCommits()
        throws com.liferay.portal.kernel.exception.SystemException {
        _commitLocalService.deleteAllCommits();
    }

    /**
    * load Property File
    *
    * @author Mihai Sava
    */
    @Override
    public java.util.Properties loadConfigFile() {
        return _commitLocalService.loadConfigFile();
    }

    /**
    * @author Mihai Sava
    * @param studentName
    * @param projectName
    * @return List<Commit> with all commits from this student
    */
    @Override
    public java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> getAllCommitsForStudentNameAndProjectName(
        java.lang.String studentName, java.lang.String projectName) {
        return _commitLocalService.getAllCommitsForStudentNameAndProjectName(studentName,
            projectName);
    }

    /**
    * @author Mihai Sava
    * @param projectName
    * @return List<Commit> with all commits for this project
    */
    @Override
    public java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> getAllCommitsForThisProject(
        java.lang.String projectName) {
        return _commitLocalService.getAllCommitsForThisProject(projectName);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CommitLocalService getWrappedCommitLocalService() {
        return _commitLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCommitLocalService(
        CommitLocalService commitLocalService) {
        _commitLocalService = commitLocalService;
    }

    @Override
    public CommitLocalService getWrappedService() {
        return _commitLocalService;
    }

    @Override
    public void setWrappedService(CommitLocalService commitLocalService) {
        _commitLocalService = commitLocalService;
    }
}
