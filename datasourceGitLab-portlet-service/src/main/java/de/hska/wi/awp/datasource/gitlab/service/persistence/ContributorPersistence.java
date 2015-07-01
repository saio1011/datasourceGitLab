package de.hska.wi.awp.datasource.gitlab.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import de.hska.wi.awp.datasource.gitlab.model.Contributor;

/**
 * The persistence interface for the contributor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContributorPersistenceImpl
 * @see ContributorUtil
 * @generated
 */
public interface ContributorPersistence extends BasePersistence<Contributor> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link ContributorUtil} to access the contributor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the contributor where name = &#63; or throws a {@link de.hska.wi.awp.datasource.gitlab.NoSuchContributorException} if it could not be found.
    *
    * @param name the name
    * @return the matching contributor
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchContributorException if a matching contributor could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.gitlab.model.Contributor findByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchContributorException;

    /**
    * Returns the contributor where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param name the name
    * @return the matching contributor, or <code>null</code> if a matching contributor could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.gitlab.model.Contributor fetchByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contributor where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param name the name
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching contributor, or <code>null</code> if a matching contributor could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.gitlab.model.Contributor fetchByName(
        java.lang.String name, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the contributor where name = &#63; from the database.
    *
    * @param name the name
    * @return the contributor that was removed
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.gitlab.model.Contributor removeByName(
        java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchContributorException;

    /**
    * Returns the number of contributors where name = &#63;.
    *
    * @param name the name
    * @return the number of matching contributors
    * @throws SystemException if a system exception occurred
    */
    public int countByName(java.lang.String name)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the contributor in the entity cache if it is enabled.
    *
    * @param contributor the contributor
    */
    public void cacheResult(
        de.hska.wi.awp.datasource.gitlab.model.Contributor contributor);

    /**
    * Caches the contributors in the entity cache if it is enabled.
    *
    * @param contributors the contributors
    */
    public void cacheResult(
        java.util.List<de.hska.wi.awp.datasource.gitlab.model.Contributor> contributors);

    /**
    * Creates a new contributor with the primary key. Does not add the contributor to the database.
    *
    * @param contributorId the primary key for the new contributor
    * @return the new contributor
    */
    public de.hska.wi.awp.datasource.gitlab.model.Contributor create(
        long contributorId);

    /**
    * Removes the contributor with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param contributorId the primary key of the contributor
    * @return the contributor that was removed
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchContributorException if a contributor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.gitlab.model.Contributor remove(
        long contributorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchContributorException;

    public de.hska.wi.awp.datasource.gitlab.model.Contributor updateImpl(
        de.hska.wi.awp.datasource.gitlab.model.Contributor contributor)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the contributor with the primary key or throws a {@link de.hska.wi.awp.datasource.gitlab.NoSuchContributorException} if it could not be found.
    *
    * @param contributorId the primary key of the contributor
    * @return the contributor
    * @throws de.hska.wi.awp.datasource.gitlab.NoSuchContributorException if a contributor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.gitlab.model.Contributor findByPrimaryKey(
        long contributorId)
        throws com.liferay.portal.kernel.exception.SystemException,
            de.hska.wi.awp.datasource.gitlab.NoSuchContributorException;

    /**
    * Returns the contributor with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param contributorId the primary key of the contributor
    * @return the contributor, or <code>null</code> if a contributor with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public de.hska.wi.awp.datasource.gitlab.model.Contributor fetchByPrimaryKey(
        long contributorId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the contributors.
    *
    * @return the contributors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.gitlab.model.Contributor> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<de.hska.wi.awp.datasource.gitlab.model.Contributor> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the contributors.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.hska.wi.awp.datasource.gitlab.model.impl.ContributorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of contributors
    * @param end the upper bound of the range of contributors (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of contributors
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<de.hska.wi.awp.datasource.gitlab.model.Contributor> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the contributors from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of contributors.
    *
    * @return the number of contributors
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
