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

import de.hska.wi.awp.datasource.gitlab.NoSuchCommitException;
import de.hska.wi.awp.datasource.gitlab.model.Commit;
import de.hska.wi.awp.datasource.gitlab.model.impl.CommitImpl;
import de.hska.wi.awp.datasource.gitlab.model.impl.CommitModelImpl;
import de.hska.wi.awp.datasource.gitlab.service.persistence.CommitPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the commit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CommitPersistence
 * @see CommitUtil
 * @generated
 */
public class CommitPersistenceImpl extends BasePersistenceImpl<Commit>
    implements CommitPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CommitUtil} to access the commit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CommitImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitModelImpl.FINDER_CACHE_ENABLED, CommitImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitModelImpl.FINDER_CACHE_ENABLED, CommitImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORNAMEANDPROJECTNAME =
        new FinderPath(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitModelImpl.FINDER_CACHE_ENABLED, CommitImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByAuthorNameAndProjectName",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORNAMEANDPROJECTNAME =
        new FinderPath(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitModelImpl.FINDER_CACHE_ENABLED, CommitImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByAuthorNameAndProjectName",
            new String[] { String.class.getName(), String.class.getName() },
            CommitModelImpl.AUTHORNAME_COLUMN_BITMASK |
            CommitModelImpl.PROJECTNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORNAMEANDPROJECTNAME =
        new FinderPath(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByAuthorNameAndProjectName",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_1 =
        "commit.authorName IS NULL AND ";
    private static final String _FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_2 =
        "commit.authorName = ? AND ";
    private static final String _FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_3 =
        "(commit.authorName IS NULL OR commit.authorName = '') AND ";
    private static final String _FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_1 =
        "commit.projectName IS NULL";
    private static final String _FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_2 =
        "commit.projectName = ?";
    private static final String _FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_3 =
        "(commit.projectName IS NULL OR commit.projectName = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTNAME =
        new FinderPath(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitModelImpl.FINDER_CACHE_ENABLED, CommitImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProjectName",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTNAME =
        new FinderPath(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitModelImpl.FINDER_CACHE_ENABLED, CommitImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProjectName",
            new String[] { String.class.getName() },
            CommitModelImpl.PROJECTNAME_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PROJECTNAME = new FinderPath(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProjectName",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_PROJECTNAME_PROJECTNAME_1 = "commit.projectName IS NULL";
    private static final String _FINDER_COLUMN_PROJECTNAME_PROJECTNAME_2 = "commit.projectName = ?";
    private static final String _FINDER_COLUMN_PROJECTNAME_PROJECTNAME_3 = "(commit.projectName IS NULL OR commit.projectName = '')";
    private static final String _SQL_SELECT_COMMIT = "SELECT commit FROM Commit commit";
    private static final String _SQL_SELECT_COMMIT_WHERE = "SELECT commit FROM Commit commit WHERE ";
    private static final String _SQL_COUNT_COMMIT = "SELECT COUNT(commit) FROM Commit commit";
    private static final String _SQL_COUNT_COMMIT_WHERE = "SELECT COUNT(commit) FROM Commit commit WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "commit.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Commit exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Commit exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CommitPersistenceImpl.class);
    private static Commit _nullCommit = new CommitImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Commit> toCacheModel() {
                return _nullCommitCacheModel;
            }
        };

    private static CacheModel<Commit> _nullCommitCacheModel = new CacheModel<Commit>() {
            @Override
            public Commit toEntityModel() {
                return _nullCommit;
            }
        };

    public CommitPersistenceImpl() {
        setModelClass(Commit.class);
    }

    /**
     * Returns all the commits where authorName = &#63; and projectName = &#63;.
     *
     * @param authorName the author name
     * @param projectName the project name
     * @return the matching commits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Commit> findByAuthorNameAndProjectName(String authorName,
        String projectName) throws SystemException {
        return findByAuthorNameAndProjectName(authorName, projectName,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Commit> findByAuthorNameAndProjectName(String authorName,
        String projectName, int start, int end) throws SystemException {
        return findByAuthorNameAndProjectName(authorName, projectName, start,
            end, null);
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
    @Override
    public List<Commit> findByAuthorNameAndProjectName(String authorName,
        String projectName, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORNAMEANDPROJECTNAME;
            finderArgs = new Object[] { authorName, projectName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AUTHORNAMEANDPROJECTNAME;
            finderArgs = new Object[] {
                    authorName, projectName,
                    
                    start, end, orderByComparator
                };
        }

        List<Commit> list = (List<Commit>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Commit commit : list) {
                if (!Validator.equals(authorName, commit.getAuthorName()) ||
                        !Validator.equals(projectName, commit.getProjectName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_COMMIT_WHERE);

            boolean bindAuthorName = false;

            if (authorName == null) {
                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_1);
            } else if (authorName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_3);
            } else {
                bindAuthorName = true;

                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_2);
            }

            boolean bindProjectName = false;

            if (projectName == null) {
                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_1);
            } else if (projectName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_3);
            } else {
                bindProjectName = true;

                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CommitModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAuthorName) {
                    qPos.add(authorName);
                }

                if (bindProjectName) {
                    qPos.add(projectName);
                }

                if (!pagination) {
                    list = (List<Commit>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Commit>(list);
                } else {
                    list = (List<Commit>) QueryUtil.list(q, getDialect(),
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
     * Returns the first commit in the ordered set where authorName = &#63; and projectName = &#63;.
     *
     * @param authorName the author name
     * @param projectName the project name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching commit
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a matching commit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit findByAuthorNameAndProjectName_First(String authorName,
        String projectName, OrderByComparator orderByComparator)
        throws NoSuchCommitException, SystemException {
        Commit commit = fetchByAuthorNameAndProjectName_First(authorName,
                projectName, orderByComparator);

        if (commit != null) {
            return commit;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("authorName=");
        msg.append(authorName);

        msg.append(", projectName=");
        msg.append(projectName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCommitException(msg.toString());
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
    @Override
    public Commit fetchByAuthorNameAndProjectName_First(String authorName,
        String projectName, OrderByComparator orderByComparator)
        throws SystemException {
        List<Commit> list = findByAuthorNameAndProjectName(authorName,
                projectName, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Commit findByAuthorNameAndProjectName_Last(String authorName,
        String projectName, OrderByComparator orderByComparator)
        throws NoSuchCommitException, SystemException {
        Commit commit = fetchByAuthorNameAndProjectName_Last(authorName,
                projectName, orderByComparator);

        if (commit != null) {
            return commit;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("authorName=");
        msg.append(authorName);

        msg.append(", projectName=");
        msg.append(projectName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCommitException(msg.toString());
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
    @Override
    public Commit fetchByAuthorNameAndProjectName_Last(String authorName,
        String projectName, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByAuthorNameAndProjectName(authorName, projectName);

        if (count == 0) {
            return null;
        }

        List<Commit> list = findByAuthorNameAndProjectName(authorName,
                projectName, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Commit[] findByAuthorNameAndProjectName_PrevAndNext(
        String commitId, String authorName, String projectName,
        OrderByComparator orderByComparator)
        throws NoSuchCommitException, SystemException {
        Commit commit = findByPrimaryKey(commitId);

        Session session = null;

        try {
            session = openSession();

            Commit[] array = new CommitImpl[3];

            array[0] = getByAuthorNameAndProjectName_PrevAndNext(session,
                    commit, authorName, projectName, orderByComparator, true);

            array[1] = commit;

            array[2] = getByAuthorNameAndProjectName_PrevAndNext(session,
                    commit, authorName, projectName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Commit getByAuthorNameAndProjectName_PrevAndNext(
        Session session, Commit commit, String authorName, String projectName,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_COMMIT_WHERE);

        boolean bindAuthorName = false;

        if (authorName == null) {
            query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_1);
        } else if (authorName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_3);
        } else {
            bindAuthorName = true;

            query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_2);
        }

        boolean bindProjectName = false;

        if (projectName == null) {
            query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_1);
        } else if (projectName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_3);
        } else {
            bindProjectName = true;

            query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CommitModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindAuthorName) {
            qPos.add(authorName);
        }

        if (bindProjectName) {
            qPos.add(projectName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(commit);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Commit> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the commits where authorName = &#63; and projectName = &#63; from the database.
     *
     * @param authorName the author name
     * @param projectName the project name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAuthorNameAndProjectName(String authorName,
        String projectName) throws SystemException {
        for (Commit commit : findByAuthorNameAndProjectName(authorName,
                projectName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(commit);
        }
    }

    /**
     * Returns the number of commits where authorName = &#63; and projectName = &#63;.
     *
     * @param authorName the author name
     * @param projectName the project name
     * @return the number of matching commits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAuthorNameAndProjectName(String authorName,
        String projectName) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_AUTHORNAMEANDPROJECTNAME;

        Object[] finderArgs = new Object[] { authorName, projectName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_COMMIT_WHERE);

            boolean bindAuthorName = false;

            if (authorName == null) {
                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_1);
            } else if (authorName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_3);
            } else {
                bindAuthorName = true;

                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_AUTHORNAME_2);
            }

            boolean bindProjectName = false;

            if (projectName == null) {
                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_1);
            } else if (projectName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_3);
            } else {
                bindProjectName = true;

                query.append(_FINDER_COLUMN_AUTHORNAMEANDPROJECTNAME_PROJECTNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAuthorName) {
                    qPos.add(authorName);
                }

                if (bindProjectName) {
                    qPos.add(projectName);
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
     * Returns all the commits where projectName = &#63;.
     *
     * @param projectName the project name
     * @return the matching commits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Commit> findByProjectName(String projectName)
        throws SystemException {
        return findByProjectName(projectName, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Commit> findByProjectName(String projectName, int start, int end)
        throws SystemException {
        return findByProjectName(projectName, start, end, null);
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
    @Override
    public List<Commit> findByProjectName(String projectName, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTNAME;
            finderArgs = new Object[] { projectName };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PROJECTNAME;
            finderArgs = new Object[] { projectName, start, end, orderByComparator };
        }

        List<Commit> list = (List<Commit>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Commit commit : list) {
                if (!Validator.equals(projectName, commit.getProjectName())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_COMMIT_WHERE);

            boolean bindProjectName = false;

            if (projectName == null) {
                query.append(_FINDER_COLUMN_PROJECTNAME_PROJECTNAME_1);
            } else if (projectName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PROJECTNAME_PROJECTNAME_3);
            } else {
                bindProjectName = true;

                query.append(_FINDER_COLUMN_PROJECTNAME_PROJECTNAME_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(CommitModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindProjectName) {
                    qPos.add(projectName);
                }

                if (!pagination) {
                    list = (List<Commit>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Commit>(list);
                } else {
                    list = (List<Commit>) QueryUtil.list(q, getDialect(),
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
     * Returns the first commit in the ordered set where projectName = &#63;.
     *
     * @param projectName the project name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching commit
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a matching commit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit findByProjectName_First(String projectName,
        OrderByComparator orderByComparator)
        throws NoSuchCommitException, SystemException {
        Commit commit = fetchByProjectName_First(projectName, orderByComparator);

        if (commit != null) {
            return commit;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("projectName=");
        msg.append(projectName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCommitException(msg.toString());
    }

    /**
     * Returns the first commit in the ordered set where projectName = &#63;.
     *
     * @param projectName the project name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching commit, or <code>null</code> if a matching commit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit fetchByProjectName_First(String projectName,
        OrderByComparator orderByComparator) throws SystemException {
        List<Commit> list = findByProjectName(projectName, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Commit findByProjectName_Last(String projectName,
        OrderByComparator orderByComparator)
        throws NoSuchCommitException, SystemException {
        Commit commit = fetchByProjectName_Last(projectName, orderByComparator);

        if (commit != null) {
            return commit;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("projectName=");
        msg.append(projectName);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCommitException(msg.toString());
    }

    /**
     * Returns the last commit in the ordered set where projectName = &#63;.
     *
     * @param projectName the project name
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching commit, or <code>null</code> if a matching commit could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit fetchByProjectName_Last(String projectName,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByProjectName(projectName);

        if (count == 0) {
            return null;
        }

        List<Commit> list = findByProjectName(projectName, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Commit[] findByProjectName_PrevAndNext(String commitId,
        String projectName, OrderByComparator orderByComparator)
        throws NoSuchCommitException, SystemException {
        Commit commit = findByPrimaryKey(commitId);

        Session session = null;

        try {
            session = openSession();

            Commit[] array = new CommitImpl[3];

            array[0] = getByProjectName_PrevAndNext(session, commit,
                    projectName, orderByComparator, true);

            array[1] = commit;

            array[2] = getByProjectName_PrevAndNext(session, commit,
                    projectName, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Commit getByProjectName_PrevAndNext(Session session,
        Commit commit, String projectName, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_COMMIT_WHERE);

        boolean bindProjectName = false;

        if (projectName == null) {
            query.append(_FINDER_COLUMN_PROJECTNAME_PROJECTNAME_1);
        } else if (projectName.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_PROJECTNAME_PROJECTNAME_3);
        } else {
            bindProjectName = true;

            query.append(_FINDER_COLUMN_PROJECTNAME_PROJECTNAME_2);
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(CommitModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindProjectName) {
            qPos.add(projectName);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(commit);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Commit> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the commits where projectName = &#63; from the database.
     *
     * @param projectName the project name
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByProjectName(String projectName)
        throws SystemException {
        for (Commit commit : findByProjectName(projectName, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(commit);
        }
    }

    /**
     * Returns the number of commits where projectName = &#63;.
     *
     * @param projectName the project name
     * @return the number of matching commits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByProjectName(String projectName) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_PROJECTNAME;

        Object[] finderArgs = new Object[] { projectName };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_COMMIT_WHERE);

            boolean bindProjectName = false;

            if (projectName == null) {
                query.append(_FINDER_COLUMN_PROJECTNAME_PROJECTNAME_1);
            } else if (projectName.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_PROJECTNAME_PROJECTNAME_3);
            } else {
                bindProjectName = true;

                query.append(_FINDER_COLUMN_PROJECTNAME_PROJECTNAME_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindProjectName) {
                    qPos.add(projectName);
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
     * Caches the commit in the entity cache if it is enabled.
     *
     * @param commit the commit
     */
    @Override
    public void cacheResult(Commit commit) {
        EntityCacheUtil.putResult(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitImpl.class, commit.getPrimaryKey(), commit);

        commit.resetOriginalValues();
    }

    /**
     * Caches the commits in the entity cache if it is enabled.
     *
     * @param commits the commits
     */
    @Override
    public void cacheResult(List<Commit> commits) {
        for (Commit commit : commits) {
            if (EntityCacheUtil.getResult(
                        CommitModelImpl.ENTITY_CACHE_ENABLED, CommitImpl.class,
                        commit.getPrimaryKey()) == null) {
                cacheResult(commit);
            } else {
                commit.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all commits.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CommitImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CommitImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the commit.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Commit commit) {
        EntityCacheUtil.removeResult(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitImpl.class, commit.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Commit> commits) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Commit commit : commits) {
            EntityCacheUtil.removeResult(CommitModelImpl.ENTITY_CACHE_ENABLED,
                CommitImpl.class, commit.getPrimaryKey());
        }
    }

    /**
     * Creates a new commit with the primary key. Does not add the commit to the database.
     *
     * @param commitId the primary key for the new commit
     * @return the new commit
     */
    @Override
    public Commit create(String commitId) {
        Commit commit = new CommitImpl();

        commit.setNew(true);
        commit.setPrimaryKey(commitId);

        return commit;
    }

    /**
     * Removes the commit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param commitId the primary key of the commit
     * @return the commit that was removed
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a commit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit remove(String commitId)
        throws NoSuchCommitException, SystemException {
        return remove((Serializable) commitId);
    }

    /**
     * Removes the commit with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the commit
     * @return the commit that was removed
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a commit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit remove(Serializable primaryKey)
        throws NoSuchCommitException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Commit commit = (Commit) session.get(CommitImpl.class, primaryKey);

            if (commit == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCommitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(commit);
        } catch (NoSuchCommitException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Commit removeImpl(Commit commit) throws SystemException {
        commit = toUnwrappedModel(commit);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(commit)) {
                commit = (Commit) session.get(CommitImpl.class,
                        commit.getPrimaryKeyObj());
            }

            if (commit != null) {
                session.delete(commit);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (commit != null) {
            clearCache(commit);
        }

        return commit;
    }

    @Override
    public Commit updateImpl(
        de.hska.wi.awp.datasource.gitlab.model.Commit commit)
        throws SystemException {
        commit = toUnwrappedModel(commit);

        boolean isNew = commit.isNew();

        CommitModelImpl commitModelImpl = (CommitModelImpl) commit;

        Session session = null;

        try {
            session = openSession();

            if (commit.isNew()) {
                session.save(commit);

                commit.setNew(false);
            } else {
                session.merge(commit);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CommitModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((commitModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORNAMEANDPROJECTNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        commitModelImpl.getOriginalAuthorName(),
                        commitModelImpl.getOriginalProjectName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORNAMEANDPROJECTNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORNAMEANDPROJECTNAME,
                    args);

                args = new Object[] {
                        commitModelImpl.getAuthorName(),
                        commitModelImpl.getProjectName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AUTHORNAMEANDPROJECTNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AUTHORNAMEANDPROJECTNAME,
                    args);
            }

            if ((commitModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTNAME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        commitModelImpl.getOriginalProjectName()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTNAME,
                    args);

                args = new Object[] { commitModelImpl.getProjectName() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PROJECTNAME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PROJECTNAME,
                    args);
            }
        }

        EntityCacheUtil.putResult(CommitModelImpl.ENTITY_CACHE_ENABLED,
            CommitImpl.class, commit.getPrimaryKey(), commit);

        return commit;
    }

    protected Commit toUnwrappedModel(Commit commit) {
        if (commit instanceof CommitImpl) {
            return commit;
        }

        CommitImpl commitImpl = new CommitImpl();

        commitImpl.setNew(commit.isNew());
        commitImpl.setPrimaryKey(commit.getPrimaryKey());

        commitImpl.setCommitId(commit.getCommitId());
        commitImpl.setAuthorName(commit.getAuthorName());
        commitImpl.setAuthorEmail(commit.getAuthorEmail());
        commitImpl.setTitleCommit(commit.getTitleCommit());
        commitImpl.setCreatedAt(commit.getCreatedAt());
        commitImpl.setProjectName(commit.getProjectName());

        return commitImpl;
    }

    /**
     * Returns the commit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the commit
     * @return the commit
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a commit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit findByPrimaryKey(Serializable primaryKey)
        throws NoSuchCommitException, SystemException {
        Commit commit = fetchByPrimaryKey(primaryKey);

        if (commit == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchCommitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return commit;
    }

    /**
     * Returns the commit with the primary key or throws a {@link de.hska.wi.awp.datasource.gitlab.NoSuchCommitException} if it could not be found.
     *
     * @param commitId the primary key of the commit
     * @return the commit
     * @throws de.hska.wi.awp.datasource.gitlab.NoSuchCommitException if a commit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit findByPrimaryKey(String commitId)
        throws NoSuchCommitException, SystemException {
        return findByPrimaryKey((Serializable) commitId);
    }

    /**
     * Returns the commit with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the commit
     * @return the commit, or <code>null</code> if a commit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Commit commit = (Commit) EntityCacheUtil.getResult(CommitModelImpl.ENTITY_CACHE_ENABLED,
                CommitImpl.class, primaryKey);

        if (commit == _nullCommit) {
            return null;
        }

        if (commit == null) {
            Session session = null;

            try {
                session = openSession();

                commit = (Commit) session.get(CommitImpl.class, primaryKey);

                if (commit != null) {
                    cacheResult(commit);
                } else {
                    EntityCacheUtil.putResult(CommitModelImpl.ENTITY_CACHE_ENABLED,
                        CommitImpl.class, primaryKey, _nullCommit);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(CommitModelImpl.ENTITY_CACHE_ENABLED,
                    CommitImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return commit;
    }

    /**
     * Returns the commit with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param commitId the primary key of the commit
     * @return the commit, or <code>null</code> if a commit with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Commit fetchByPrimaryKey(String commitId) throws SystemException {
        return fetchByPrimaryKey((Serializable) commitId);
    }

    /**
     * Returns all the commits.
     *
     * @return the commits
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Commit> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Commit> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Commit> findAll(int start, int end,
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

        List<Commit> list = (List<Commit>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_COMMIT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_COMMIT;

                if (pagination) {
                    sql = sql.concat(CommitModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Commit>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Commit>(list);
                } else {
                    list = (List<Commit>) QueryUtil.list(q, getDialect(),
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
     * Removes all the commits from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Commit commit : findAll()) {
            remove(commit);
        }
    }

    /**
     * Returns the number of commits.
     *
     * @return the number of commits
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

                Query q = session.createQuery(_SQL_COUNT_COMMIT);

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
     * Initializes the commit persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.de.hska.wi.awp.datasource.gitlab.model.Commit")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Commit>> listenersList = new ArrayList<ModelListener<Commit>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Commit>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CommitImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
