package de.hska.wi.awp.datasource.gitlab.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Commit}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Commit
 * @generated
 */
public class CommitWrapper implements Commit, ModelWrapper<Commit> {
    private Commit _commit;

    public CommitWrapper(Commit commit) {
        _commit = commit;
    }

    @Override
    public Class<?> getModelClass() {
        return Commit.class;
    }

    @Override
    public String getModelClassName() {
        return Commit.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("commitId", getCommitId());
        attributes.put("authorName", getAuthorName());
        attributes.put("authorEmail", getAuthorEmail());
        attributes.put("titleCommit", getTitleCommit());
        attributes.put("createdAt", getCreatedAt());
        attributes.put("projectName", getProjectName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String commitId = (String) attributes.get("commitId");

        if (commitId != null) {
            setCommitId(commitId);
        }

        String authorName = (String) attributes.get("authorName");

        if (authorName != null) {
            setAuthorName(authorName);
        }

        String authorEmail = (String) attributes.get("authorEmail");

        if (authorEmail != null) {
            setAuthorEmail(authorEmail);
        }

        String titleCommit = (String) attributes.get("titleCommit");

        if (titleCommit != null) {
            setTitleCommit(titleCommit);
        }

        String createdAt = (String) attributes.get("createdAt");

        if (createdAt != null) {
            setCreatedAt(createdAt);
        }

        String projectName = (String) attributes.get("projectName");

        if (projectName != null) {
            setProjectName(projectName);
        }
    }

    /**
    * Returns the primary key of this commit.
    *
    * @return the primary key of this commit
    */
    @Override
    public java.lang.String getPrimaryKey() {
        return _commit.getPrimaryKey();
    }

    /**
    * Sets the primary key of this commit.
    *
    * @param primaryKey the primary key of this commit
    */
    @Override
    public void setPrimaryKey(java.lang.String primaryKey) {
        _commit.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the commit ID of this commit.
    *
    * @return the commit ID of this commit
    */
    @Override
    public java.lang.String getCommitId() {
        return _commit.getCommitId();
    }

    /**
    * Sets the commit ID of this commit.
    *
    * @param commitId the commit ID of this commit
    */
    @Override
    public void setCommitId(java.lang.String commitId) {
        _commit.setCommitId(commitId);
    }

    /**
    * Returns the author name of this commit.
    *
    * @return the author name of this commit
    */
    @Override
    public java.lang.String getAuthorName() {
        return _commit.getAuthorName();
    }

    /**
    * Sets the author name of this commit.
    *
    * @param authorName the author name of this commit
    */
    @Override
    public void setAuthorName(java.lang.String authorName) {
        _commit.setAuthorName(authorName);
    }

    /**
    * Returns the author email of this commit.
    *
    * @return the author email of this commit
    */
    @Override
    public java.lang.String getAuthorEmail() {
        return _commit.getAuthorEmail();
    }

    /**
    * Sets the author email of this commit.
    *
    * @param authorEmail the author email of this commit
    */
    @Override
    public void setAuthorEmail(java.lang.String authorEmail) {
        _commit.setAuthorEmail(authorEmail);
    }

    /**
    * Returns the title commit of this commit.
    *
    * @return the title commit of this commit
    */
    @Override
    public java.lang.String getTitleCommit() {
        return _commit.getTitleCommit();
    }

    /**
    * Sets the title commit of this commit.
    *
    * @param titleCommit the title commit of this commit
    */
    @Override
    public void setTitleCommit(java.lang.String titleCommit) {
        _commit.setTitleCommit(titleCommit);
    }

    /**
    * Returns the created at of this commit.
    *
    * @return the created at of this commit
    */
    @Override
    public java.lang.String getCreatedAt() {
        return _commit.getCreatedAt();
    }

    /**
    * Sets the created at of this commit.
    *
    * @param createdAt the created at of this commit
    */
    @Override
    public void setCreatedAt(java.lang.String createdAt) {
        _commit.setCreatedAt(createdAt);
    }

    /**
    * Returns the project name of this commit.
    *
    * @return the project name of this commit
    */
    @Override
    public java.lang.String getProjectName() {
        return _commit.getProjectName();
    }

    /**
    * Sets the project name of this commit.
    *
    * @param projectName the project name of this commit
    */
    @Override
    public void setProjectName(java.lang.String projectName) {
        _commit.setProjectName(projectName);
    }

    @Override
    public boolean isNew() {
        return _commit.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _commit.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _commit.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _commit.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _commit.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _commit.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _commit.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _commit.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _commit.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _commit.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _commit.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CommitWrapper((Commit) _commit.clone());
    }

    @Override
    public int compareTo(de.hska.wi.awp.datasource.gitlab.model.Commit commit) {
        return _commit.compareTo(commit);
    }

    @Override
    public int hashCode() {
        return _commit.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.hska.wi.awp.datasource.gitlab.model.Commit> toCacheModel() {
        return _commit.toCacheModel();
    }

    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Commit toEscapedModel() {
        return new CommitWrapper(_commit.toEscapedModel());
    }

    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Commit toUnescapedModel() {
        return new CommitWrapper(_commit.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _commit.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _commit.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _commit.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CommitWrapper)) {
            return false;
        }

        CommitWrapper commitWrapper = (CommitWrapper) obj;

        if (Validator.equals(_commit, commitWrapper._commit)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Commit getWrappedCommit() {
        return _commit;
    }

    @Override
    public Commit getWrappedModel() {
        return _commit;
    }

    @Override
    public void resetOriginalValues() {
        _commit.resetOriginalValues();
    }
}
