package de.hska.wi.awp.datasource.gitlab.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import de.hska.wi.awp.datasource.gitlab.NoSuchContributorException;
import de.hska.wi.awp.datasource.gitlab.model.Contributor;
import de.hska.wi.awp.datasource.gitlab.model.impl.ContributorImpl;
import de.hska.wi.awp.datasource.gitlab.model.impl.ContributorModelImpl;
import de.hska.wi.awp.datasource.gitlab.service.persistence.ContributorPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contributor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContributorPersistence
 * @see ContributorUtil
 * @generated
 */
public class ContributorPersistenceImpl extends BasePersistenceImpl<Contributor>
    implements ContributorPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link ContributorUtil} to access the contributor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = ContributorImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ContributorModelImpl.ENTITY_CACHE_ENABLED,
            ContributorModelImpl.FINDER_CACHE_ENABLED, ContributorImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ContributorModelImpl.ENTITY_CACHE_ENABLED,
            ContributorModelImpl.FINDER_CACHE_ENABLED, ContributorImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContributorModelImpl.ENTITY_CACHE_ENABLED,
            ContributorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(ContributorModelImpl.ENTITY_CACHE_ENABLED,
            ContributorModelImpl.FINDER_CACHE_ENABLED, ContributorImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByName",
            new String[] { String.class.getName() },
            ContributorModelImpl.NAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(ContributorModelImpl.ENTITY_CACHE_ENABLED,
            ContributorModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_NAME_NAME_1 = "contributor.name IS NULL";
    private static final String _FINDER_COLUMN_NAME_NAME_2 = "contributor.name = ?";
    private static final String _FINDER_COLUMN_NAME_NAME_3 = "(contributor.name IS NULL OR contributor.name = '')";
    private static final String _SQL_SELECT_CONTRIBUTOR = "SELECT contributor FROM Contributor contributor";
    private static final String _SQL_SELECT_CONTRIBUTOR_WHERE = "SELECT contributor FROM Contributor contributor WHERE ";
    private static final String _SQL_COUNT_CONTRIBUTOR = "SELECT COUNT(contributor) FROM Contributor contributor";
    private static final String _SQL_COUNT_CONTRIBUTOR_WHERE = "SELECT COUNT(contributor) FROM Contributor contributor WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "contributor.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contributor exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Contributor exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(ContributorPersistenceImpl.class);
    private static Contributor _nullContributor = new ContributorImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Contributor> toCacheModel() {
                return _nullContributorCacheModel;
            }
        };

    private static CacheModel<Contributor> _nullContributorCacheModel = new CacheModel<Contributor>() {
            @Override
            public Contributor toEntityModel() {
                return _nullContributor;
            }
        };

    public ContributorPersistenceImpl() {
        setModelClass(Contributor.class);
    }

    /**
     * Returns the contributor where name = &#63; or throws a {@link de.hska.wi.awp.datasource.gitlab.NoSuchContributorException} if it could not be found.
     *
     * @param name the name
     * @return the matching contributor
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchContributorException if a matching contributor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor findByName(String name)
        throws NoSuchContributorException, SystemException {
        Contributor contributor = fetchByName(name);

        if (contributor == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("name=");
            msg.append(name);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchContributorException(msg.toString());
        }

        return contributor;
    }

    /**
     * Returns the contributor where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param name the name
     * @return the matching contributor, or <code>null</code> if a matching contributor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor fetchByName(String name) throws SystemException {
        return fetchByName(name, true);
    }

    /**
     * Returns the contributor where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param name the name
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching contributor, or <code>null</code> if a matching contributor could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor fetchByName(String name, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { name };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs, this);
        }

        if (result instanceof Contributor) {
            Contributor contributor = (Contributor) result;

            if (!Validator.equals(name, contributor.getName())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_CONTRIBUTOR_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                List<Contributor> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "ContributorPersistenceImpl.fetchByName(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    Contributor contributor = list.get(0);

                    result = contributor;

                    cacheResult(contributor);

                    if ((contributor.getName() == null) ||
                            !contributor.getName().equals(name)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
                            finderArgs, contributor);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (Contributor) result;
        }
    }

    /**
     * Removes the contributor where name = &#63; from the database.
     *
     * @param name the name
     * @return the contributor that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor removeByName(String name)
        throws NoSuchContributorException, SystemException {
        Contributor contributor = findByName(name);

        return remove(contributor);
    }

    /**
     * Returns the number of contributors where name = &#63;.
     *
     * @param name the name
     * @return the number of matching contributors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByName(String name) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

        Object[] finderArgs = new Object[] { name };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CONTRIBUTOR_WHERE);

            boolean bindName = false;

            if (name == null) {
                query.append(_FINDER_COLUMN_NAME_NAME_1);
            } else if (name.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NAME_NAME_3);
            } else {
                bindName = true;

                query.append(_FINDER_COLUMN_NAME_NAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindName) {
                    qPos.add(name);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the contributor in the entity cache if it is enabled.
     *
     * @param contributor the contributor
     */
    @Override
    public void cacheResult(Contributor contributor) {
        EntityCacheUtil.putResult(ContributorModelImpl.ENTITY_CACHE_ENABLED,
            ContributorImpl.class, contributor.getPrimaryKey(), contributor);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
            new Object[] { contributor.getName() }, contributor);

        contributor.resetOriginalValues();
    }

    /**
     * Caches the contributors in the entity cache if it is enabled.
     *
     * @param contributors the contributors
     */
    @Override
    public void cacheResult(List<Contributor> contributors) {
        for (Contributor contributor : contributors) {
            if (EntityCacheUtil.getResult(
                        ContributorModelImpl.ENTITY_CACHE_ENABLED,
                        ContributorImpl.class, contributor.getPrimaryKey()) == null) {
                cacheResult(contributor);
            } else {
                contributor.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all contributors.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(ContributorImpl.class.getName());
        }

        EntityCacheUtil.clearCache(ContributorImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the contributor.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Contributor contributor) {
        EntityCacheUtil.removeResult(ContributorModelImpl.ENTITY_CACHE_ENABLED,
            ContributorImpl.class, contributor.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(contributor);
    }

    @Override
    public void clearCache(List<Contributor> contributors) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Contributor contributor : contributors) {
            EntityCacheUtil.removeResult(ContributorModelImpl.ENTITY_CACHE_ENABLED,
                ContributorImpl.class, contributor.getPrimaryKey());

            clearUniqueFindersCache(contributor);
        }
    }

    protected void cacheUniqueFindersCache(Contributor contributor) {
        if (contributor.isNew()) {
            Object[] args = new Object[] { contributor.getName() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
                contributor);
        } else {
            ContributorModelImpl contributorModelImpl = (ContributorModelImpl) contributor;

            if ((contributorModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { contributor.getName() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
                    contributor);
            }
        }
    }

    protected void clearUniqueFindersCache(Contributor contributor) {
        ContributorModelImpl contributorModelImpl = (ContributorModelImpl) contributor;

        Object[] args = new Object[] { contributor.getName() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

        if ((contributorModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
            args = new Object[] { contributorModelImpl.getOriginalName() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
        }
    }

    /**
     * Creates a new contributor with the primary key. Does not add the contributor to the database.
     *
     * @param contributorId the primary key for the new contributor
     * @return the new contributor
     */
    @Override
    public Contributor create(long contributorId) {
        Contributor contributor = new ContributorImpl();

        contributor.setNew(true);
        contributor.setPrimaryKey(contributorId);

        return contributor;
    }

    /**
     * Removes the contributor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param contributorId the primary key of the contributor
     * @return the contributor that was removed
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchContributorException if a contributor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor remove(long contributorId)
        throws NoSuchContributorException, SystemException {
        return remove((Serializable) contributorId);
    }

    /**
     * Removes the contributor with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the contributor
     * @return the contributor that was removed
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchContributorException if a contributor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor remove(Serializable primaryKey)
        throws NoSuchContributorException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Contributor contributor = (Contributor) session.get(ContributorImpl.class,
                    primaryKey);

            if (contributor == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchContributorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(contributor);
        } catch (NoSuchContributorException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Contributor removeImpl(Contributor contributor)
        throws SystemException {
        contributor = toUnwrappedModel(contributor);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(contributor)) {
                contributor = (Contributor) session.get(ContributorImpl.class,
                        contributor.getPrimaryKeyObj());
            }

            if (contributor != null) {
                session.delete(contributor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (contributor != null) {
            clearCache(contributor);
        }

        return contributor;
    }

    @Override
    public Contributor updateImpl(
        de.hska.wi.awp.datasource.gitlab.model.Contributor contributor)
        throws SystemException {
        contributor = toUnwrappedModel(contributor);

        boolean isNew = contributor.isNew();

        Session session = null;

        try {
            session = openSession();

            if (contributor.isNew()) {
                session.save(contributor);

                contributor.setNew(false);
            } else {
                session.merge(contributor);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !ContributorModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(ContributorModelImpl.ENTITY_CACHE_ENABLED,
            ContributorImpl.class, contributor.getPrimaryKey(), contributor);

        clearUniqueFindersCache(contributor);
        cacheUniqueFindersCache(contributor);

        return contributor;
    }

    protected Contributor toUnwrappedModel(Contributor contributor) {
        if (contributor instanceof ContributorImpl) {
            return contributor;
        }

        ContributorImpl contributorImpl = new ContributorImpl();

        contributorImpl.setNew(contributor.isNew());
        contributorImpl.setPrimaryKey(contributor.getPrimaryKey());

        contributorImpl.setContributorId(contributor.getContributorId());
        contributorImpl.setName(contributor.getName());
        contributorImpl.setEmail(contributor.getEmail());
        contributorImpl.setCommits(contributor.getCommits());
        contributorImpl.setLocAdditions(contributor.getLocAdditions());
        contributorImpl.setLocDeletions(contributor.getLocDeletions());
        contributorImpl.setProjectName(contributor.getProjectName());

        return contributorImpl;
    }

    /**
     * Returns the contributor with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the contributor
     * @return the contributor
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchContributorException if a contributor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor findByPrimaryKey(Serializable primaryKey)
        throws NoSuchContributorException, SystemException {
        Contributor contributor = fetchByPrimaryKey(primaryKey);

        if (contributor == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchContributorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return contributor;
    }

    /**
     * Returns the contributor with the primary key or throws a {@link de.hska.wi.awp.datasource.gitlab.NoSuchContributorException} if it could not be found.
     *
     * @param contributorId the primary key of the contributor
     * @return the contributor
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchContributorException if a contributor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor findByPrimaryKey(long contributorId)
        throws NoSuchContributorException, SystemException {
        return findByPrimaryKey((Serializable) contributorId);
    }

    /**
     * Returns the contributor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the contributor
     * @return the contributor, or <code>null</code> if a contributor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Contributor contributor = (Contributor) EntityCacheUtil.getResult(ContributorModelImpl.ENTITY_CACHE_ENABLED,
                ContributorImpl.class, primaryKey);

        if (contributor == _nullContributor) {
            return null;
        }

        if (contributor == null) {
            Session session = null;

            try {
                session = openSession();

                contributor = (Contributor) session.get(ContributorImpl.class,
                        primaryKey);

                if (contributor != null) {
                    cacheResult(contributor);
                } else {
                    EntityCacheUtil.putResult(ContributorModelImpl.ENTITY_CACHE_ENABLED,
                        ContributorImpl.class, primaryKey, _nullContributor);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(ContributorModelImpl.ENTITY_CACHE_ENABLED,
                    ContributorImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return contributor;
    }

    /**
     * Returns the contributor with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param contributorId the primary key of the contributor
     * @return the contributor, or <code>null</code> if a contributor with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Contributor fetchByPrimaryKey(long contributorId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) contributorId);
    }

    /**
     * Returns all the contributors.
     *
     * @return the contributors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Contributor> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Contributor> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

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
    @Override
    public List<Contributor> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Contributor> list = (List<Contributor>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CONTRIBUTOR);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CONTRIBUTOR;

                if (pagination) {
                    sql = sql.concat(ContributorModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Contributor>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Contributor>(list);
                } else {
                    list = (List<Contributor>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the contributors from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Contributor contributor : findAll()) {
            remove(contributor);
        }
    }

    /**
     * Returns the number of contributors.
     *
     * @return the number of contributors
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CONTRIBUTOR);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the contributor persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.hska.wi.awp.datasource.gitlab.model.Contributor")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Contributor>> listenersList = new ArrayList<ModelListener<Contributor>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Contributor>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(ContributorImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
