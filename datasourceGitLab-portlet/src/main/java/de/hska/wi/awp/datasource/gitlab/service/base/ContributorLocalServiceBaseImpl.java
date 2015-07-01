package de.hska.wi.awp.datasource.gitlab.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import de.hska.wi.awp.datasource.gitlab.model.Contributor;
import de.hska.wi.awp.datasource.gitlab.service.ContributorLocalService;
import de.hska.wi.awp.datasource.gitlab.service.persistence.CommitPersistence;
import de.hska.wi.awp.datasource.gitlab.service.persistence.ContributorPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the contributor local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.hska.wi.awp.datasource.gitlab.service.impl.ContributorLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.gitlab.service.impl.ContributorLocalServiceImpl
 * @see de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil
 * @generated
 */
public abstract class ContributorLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements ContributorLocalService,
        IdentifiableBean {
    @BeanReference(type = de.hska.wi.awp.datasource.gitlab.service.CommitLocalService.class)
    protected de.hska.wi.awp.datasource.gitlab.service.CommitLocalService commitLocalService;
    @BeanReference(type = de.hska.wi.awp.datasource.gitlab.service.CommitService.class)
    protected de.hska.wi.awp.datasource.gitlab.service.CommitService commitService;
    @BeanReference(type = CommitPersistence.class)
    protected CommitPersistence commitPersistence;
    @BeanReference(type = de.hska.wi.awp.datasource.gitlab.service.ContributorLocalService.class)
    protected de.hska.wi.awp.datasource.gitlab.service.ContributorLocalService contributorLocalService;
    @BeanReference(type = de.hska.wi.awp.datasource.gitlab.service.ContributorService.class)
    protected de.hska.wi.awp.datasource.gitlab.service.ContributorService contributorService;
    @BeanReference(type = ContributorPersistence.class)
    protected ContributorPersistence contributorPersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private ContributorLocalServiceClpInvoker _clpInvoker = new ContributorLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil} to access the contributor local service.
     */

    /**
     * Adds the contributor to the database. Also notifies the appropriate model listeners.
     *
     * @param contributor the contributor
     * @return the contributor that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Contributor addContributor(Contributor contributor)
        throws SystemException {
        contributor.setNew(true);

        return contributorPersistence.update(contributor);
    }

    /**
     * Creates a new contributor with the primary key. Does not add the contributor to the database.
     *
     * @param contributorId the primary key for the new contributor
     * @return the new contributor
     */
    @Override
    public Contributor createContributor(long contributorId) {
        return contributorPersistence.create(contributorId);
    }

    /**
     * Deletes the contributor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param contributorId the primary key of the contributor
     * @return the contributor that was removed
     * @throws PortalException if a contributor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Contributor deleteContributor(long contributorId)
        throws PortalException, SystemException {
        return contributorPersistence.remove(contributorId);
    }

    /**
     * Deletes the contributor from the database. Also notifies the appropriate model listeners.
     *
     * @param contributor the contributor
     * @return the contributor that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Contributor deleteContributor(Contributor contributor)
        throws SystemException {
        return contributorPersistence.remove(contributor);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Contributor.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return contributorPersistence.findWithDynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return contributorPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return contributorPersistence.findWithDynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return contributorPersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return contributorPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public Contributor fetchContributor(long contributorId)
        throws SystemException {
        return contributorPersistence.fetchByPrimaryKey(contributorId);
    }

    /**
     * Returns the contributor with the primary key.
     *
     * @param contributorId the primary key of the contributor
     * @return the contributor
     * @throws PortalException if a contributor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor getContributor(long contributorId)
        throws PortalException, SystemException {
        return contributorPersistence.findByPrimaryKey(contributorId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return contributorPersistence.findByPrimaryKey(primaryKeyObj);
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
    @Override
    public List<Contributor> getContributors(int start, int end)
        throws SystemException {
        return contributorPersistence.findAll(start, end);
    }

    /**
     * Returns the number of contributors.
     *
     * @return the number of contributors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getContributorsCount() throws SystemException {
        return contributorPersistence.countAll();
    }

    /**
     * Updates the contributor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param contributor the contributor
     * @return the contributor that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Contributor updateContributor(Contributor contributor)
        throws SystemException {
        return contributorPersistence.update(contributor);
    }

    /**
     * Returns the commit local service.
     *
     * @return the commit local service
     */
    public de.hska.wi.awp.datasource.gitlab.service.CommitLocalService getCommitLocalService() {
        return commitLocalService;
    }

    /**
     * Sets the commit local service.
     *
     * @param commitLocalService the commit local service
     */
    public void setCommitLocalService(
        de.hska.wi.awp.datasource.gitlab.service.CommitLocalService commitLocalService) {
        this.commitLocalService = commitLocalService;
    }

    /**
     * Returns the commit remote service.
     *
     * @return the commit remote service
     */
    public de.hska.wi.awp.datasource.gitlab.service.CommitService getCommitService() {
        return commitService;
    }

    /**
     * Sets the commit remote service.
     *
     * @param commitService the commit remote service
     */
    public void setCommitService(
        de.hska.wi.awp.datasource.gitlab.service.CommitService commitService) {
        this.commitService = commitService;
    }

    /**
     * Returns the commit persistence.
     *
     * @return the commit persistence
     */
    public CommitPersistence getCommitPersistence() {
        return commitPersistence;
    }

    /**
     * Sets the commit persistence.
     *
     * @param commitPersistence the commit persistence
     */
    public void setCommitPersistence(CommitPersistence commitPersistence) {
        this.commitPersistence = commitPersistence;
    }

    /**
     * Returns the contributor local service.
     *
     * @return the contributor local service
     */
    public de.hska.wi.awp.datasource.gitlab.service.ContributorLocalService getContributorLocalService() {
        return contributorLocalService;
    }

    /**
     * Sets the contributor local service.
     *
     * @param contributorLocalService the contributor local service
     */
    public void setContributorLocalService(
        de.hska.wi.awp.datasource.gitlab.service.ContributorLocalService contributorLocalService) {
        this.contributorLocalService = contributorLocalService;
    }

    /**
     * Returns the contributor remote service.
     *
     * @return the contributor remote service
     */
    public de.hska.wi.awp.datasource.gitlab.service.ContributorService getContributorService() {
        return contributorService;
    }

    /**
     * Sets the contributor remote service.
     *
     * @param contributorService the contributor remote service
     */
    public void setContributorService(
        de.hska.wi.awp.datasource.gitlab.service.ContributorService contributorService) {
        this.contributorService = contributorService;
    }

    /**
     * Returns the contributor persistence.
     *
     * @return the contributor persistence
     */
    public ContributorPersistence getContributorPersistence() {
        return contributorPersistence;
    }

    /**
     * Sets the contributor persistence.
     *
     * @param contributorPersistence the contributor persistence
     */
    public void setContributorPersistence(
        ContributorPersistence contributorPersistence) {
        this.contributorPersistence = contributorPersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("de.hska.wi.awp.datasource.gitlab.model.Contributor",
            contributorLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "de.hska.wi.awp.datasource.gitlab.model.Contributor");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Contributor.class;
    }

    protected String getModelClassName() {
        return Contributor.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = contributorPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
