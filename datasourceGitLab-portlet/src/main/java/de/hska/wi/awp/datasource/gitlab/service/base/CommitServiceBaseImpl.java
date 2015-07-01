package de.hska.wi.awp.datasource.gitlab.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import de.hska.wi.awp.datasource.gitlab.model.Commit;
import de.hska.wi.awp.datasource.gitlab.service.CommitService;
import de.hska.wi.awp.datasource.gitlab.service.persistence.CommitPersistence;
import de.hska.wi.awp.datasource.gitlab.service.persistence.ContributorPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the commit remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link de.hska.wi.awp.datasource.gitlab.service.impl.CommitServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.gitlab.service.impl.CommitServiceImpl
 * @see de.hska.wi.awp.datasource.gitlab.service.CommitServiceUtil
 * @generated
 */
public abstract class CommitServiceBaseImpl extends BaseServiceImpl
    implements CommitService, IdentifiableBean {
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
    private CommitServiceClpInvoker _clpInvoker = new CommitServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link de.hska.wi.awp.datasource.gitlab.service.CommitServiceUtil} to access the commit remote service.
     */

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
    }

    public void destroy() {
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
        return Commit.class;
    }

    protected String getModelClassName() {
        return Commit.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = commitPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
