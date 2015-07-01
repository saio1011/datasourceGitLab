package de.hska.wi.awp.datasource.gitlab.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import de.hska.wi.awp.datasource.gitlab.model.Commit;

import java.util.List;

/**
 * The persistence utility for the commit service. This utility wraps {@link CommitPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommitPersistence
 * @see CommitPersistenceImpl
 * @generated
 */
public class CommitUtil {
    private static CommitPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Commit commit) {
        getPersistence().clearCache(commit);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Commit> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Commit> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Commit> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Commit update(Commit commit) throws SystemException {
        return getPersistence().update(commit);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Commit update(Commit commit, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(commit, serviceContext);
    }

    /**
    * Returns all the commits where authorName = &#63; and projectName = &#63;.
    *
    * @param authorName the author name
    * @param projectName the project name
    * @return the matching commits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> findByAuthorNameAndProjectName(
        java.lang.String authorName, java.lang.String projectName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAuthorNameAndProjectName(authorName, projectName);
    }

    /**
    * Returns a range of all the commits where authorName = &#63; and projectName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.CommitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param authorName the author name
    * @param projectName the project name
    * @param start the lower bound of the range of commits
    * @param end the upper bound of the range of commits (not inclusive)
    * @return the range of matching commits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> findByAuthorNameAndProjectName(
        java.lang.String authorName, java.lang.String projectName, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAuthorNameAndProjectName(authorName, projectName,
            start, end);
    }

    /**
    * Returns an ordered range of all the commits where authorName = &#63; and projectName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.CommitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param authorName the author name
    * @param projectName the project name
    * @param start the lower bound of the range of commits
    * @param end the upper bound of the range of commits (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching commits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> findByAuthorNameAndProjectName(
        java.lang.String authorName, java.lang.String projectName, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAuthorNameAndProjectName(authorName, projectName,
            start, end, orderByComparator);
    }

    /**
    * Returns the first commit in the ordered set where authorName = &#63; and projectName = &#63;.
    *
    * @param authorName the author name
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching commit
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a matching commit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit findByAuthorNameAndProjectName_First(
        java.lang.String authorName, java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchCommitException {
        return getPersistence()
                   .findByAuthorNameAndProjectName_First(authorName,
            projectName, orderByComparator);
    }

    /**
    * Returns the first commit in the ordered set where authorName = &#63; and projectName = &#63;.
    *
    * @param authorName the author name
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching commit, or <code>null</code> if a matching commit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit fetchByAuthorNameAndProjectName_First(
        java.lang.String authorName, java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAuthorNameAndProjectName_First(authorName,
            projectName, orderByComparator);
    }

    /**
    * Returns the last commit in the ordered set where authorName = &#63; and projectName = &#63;.
    *
    * @param authorName the author name
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching commit
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a matching commit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit findByAuthorNameAndProjectName_Last(
        java.lang.String authorName, java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchCommitException {
        return getPersistence()
                   .findByAuthorNameAndProjectName_Last(authorName,
            projectName, orderByComparator);
    }

    /**
    * Returns the last commit in the ordered set where authorName = &#63; and projectName = &#63;.
    *
    * @param authorName the author name
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching commit, or <code>null</code> if a matching commit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit fetchByAuthorNameAndProjectName_Last(
        java.lang.String authorName, java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAuthorNameAndProjectName_Last(authorName,
            projectName, orderByComparator);
    }

    /**
    * Returns the commits before and after the current commit in the ordered set where authorName = &#63; and projectName = &#63;.
    *
    * @param commitId the primary key of the current commit
    * @param authorName the author name
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next commit
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a commit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit[] findByAuthorNameAndProjectName_PrevAndNext(
        java.lang.String commitId, java.lang.String authorName,
        java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchCommitException {
        return getPersistence()
                   .findByAuthorNameAndProjectName_PrevAndNext(commitId,
            authorName, projectName, orderByComparator);
    }

    /**
    * Removes all the commits where authorName = &#63; and projectName = &#63; from the database.
    *
    * @param authorName the author name
    * @param projectName the project name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAuthorNameAndProjectName(
        java.lang.String authorName, java.lang.String projectName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByAuthorNameAndProjectName(authorName, projectName);
    }

    /**
    * Returns the number of commits where authorName = &#63; and projectName = &#63;.
    *
    * @param authorName the author name
    * @param projectName the project name
    * @return the number of matching commits
    * @throws SystemException if a system exception occurred
    */
    public static int countByAuthorNameAndProjectName(
        java.lang.String authorName, java.lang.String projectName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByAuthorNameAndProjectName(authorName, projectName);
    }

    /**
    * Returns all the commits where projectName = &#63;.
    *
    * @param projectName the project name
    * @return the matching commits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> findByProjectName(
        java.lang.String projectName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByProjectName(projectName);
    }

    /**
    * Returns a range of all the commits where projectName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.CommitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param projectName the project name
    * @param start the lower bound of the range of commits
    * @param end the upper bound of the range of commits (not inclusive)
    * @return the range of matching commits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> findByProjectName(
        java.lang.String projectName, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByProjectName(projectName, start, end);
    }

    /**
    * Returns an ordered range of all the commits where projectName = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.CommitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param projectName the project name
    * @param start the lower bound of the range of commits
    * @param end the upper bound of the range of commits (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching commits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> findByProjectName(
        java.lang.String projectName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByProjectName(projectName, start, end, orderByComparator);
    }

    /**
    * Returns the first commit in the ordered set where projectName = &#63;.
    *
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching commit
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a matching commit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit findByProjectName_First(
        java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchCommitException {
        return getPersistence()
                   .findByProjectName_First(projectName, orderByComparator);
    }

    /**
    * Returns the first commit in the ordered set where projectName = &#63;.
    *
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching commit, or <code>null</code> if a matching commit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit fetchByProjectName_First(
        java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByProjectName_First(projectName, orderByComparator);
    }

    /**
    * Returns the last commit in the ordered set where projectName = &#63;.
    *
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching commit
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a matching commit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit findByProjectName_Last(
        java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchCommitException {
        return getPersistence()
                   .findByProjectName_Last(projectName, orderByComparator);
    }

    /**
    * Returns the last commit in the ordered set where projectName = &#63;.
    *
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching commit, or <code>null</code> if a matching commit could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit fetchByProjectName_Last(
        java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByProjectName_Last(projectName, orderByComparator);
    }

    /**
    * Returns the commits before and after the current commit in the ordered set where projectName = &#63;.
    *
    * @param commitId the primary key of the current commit
    * @param projectName the project name
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next commit
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a commit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit[] findByProjectName_PrevAndNext(
        java.lang.String commitId, java.lang.String projectName,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchCommitException {
        return getPersistence()
                   .findByProjectName_PrevAndNext(commitId, projectName,
            orderByComparator);
    }

    /**
    * Removes all the commits where projectName = &#63; from the database.
    *
    * @param projectName the project name
    * @throws SystemException if a system exception occurred
    */
    public static void removeByProjectName(java.lang.String projectName)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByProjectName(projectName);
    }

    /**
    * Returns the number of commits where projectName = &#63;.
    *
    * @param projectName the project name
    * @return the number of matching commits
    * @throws SystemException if a system exception occurred
    */
    public static int countByProjectName(java.lang.String projectName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByProjectName(projectName);
    }

    /**
    * Caches the commit in the entity cache if it is enabled.
    *
    * @param commit the commit
    */
    public static void cacheResult(
        de.hska.wi.awp.datasource.gitlab.model.Commit commit) {
        getPersistence().cacheResult(commit);
    }

    /**
    * Caches the commits in the entity cache if it is enabled.
    *
    * @param commits the commits
    */
    public static void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> commits) {
        getPersistence().cacheResult(commits);
    }

    /**
    * Creates a new commit with the primary key. Does not add the commit to the database.
    *
    * @param commitId the primary key for the new commit
    * @return the new commit
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit create(
        java.lang.String commitId) {
        return getPersistence().create(commitId);
    }

    /**
    * Removes the commit with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param commitId the primary key of the commit
    * @return the commit that was removed
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a commit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit remove(
        java.lang.String commitId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchCommitException {
        return getPersistence().remove(commitId);
    }

    public static de.hska.wi.awp.datasource.gitlab.model.Commit updateImpl(
        de.hska.wi.awp.datasource.gitlab.model.Commit commit)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(commit);
    }

    /**
    * Returns the commit with the primary key or throws a {@link de.hska.wi.awp.datasource.gitlab.NoSuchCommitException} if it could not be found.
    *
    * @param commitId the primary key of the commit
    * @return the commit
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a commit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit findByPrimaryKey(
        java.lang.String commitId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchCommitException {
        return getPersistence().findByPrimaryKey(commitId);
    }

    /**
    * Returns the commit with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param commitId the primary key of the commit
    * @return the commit, or <code>null</code> if a commit with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static de.hska.wi.awp.datasource.gitlab.model.Commit fetchByPrimaryKey(
        java.lang.String commitId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(commitId);
    }

    /**
    * Returns all the commits.
    *
    * @return the commits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the commits.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.CommitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of commits
    * @param end the upper bound of the range of commits (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of commits
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<de.hska.wi.awp.datasource.gitlab.model.Commit> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the commits from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of commits.
    *
    * @return the number of commits
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CommitPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CommitPersistence) PortletBeanLocatorUtil.locate(de.hska.wi.awp.datasource.gitlab.service.ClpSerializer.getServletContextName(),
                    CommitPersistence.class.getName());

            ReferenceRegistry.registerReference(CommitUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(CommitPersistence persistence) {
    }
}
