package de.hska.wi.awp.datasource.gitlab.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Contributor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Contributor
 * @generated
 */
public class ContributorWrapper implements Contributor,
    ModelWrapper<Contributor> {
    private Contributor _contributor;

    public ContributorWrapper(Contributor contributor) {
        _contributor = contributor;
    }

    @Override
    public Class<?> getModelClass() {
        return Contributor.class;
    }

    @Override
    public String getModelClassName() {
        return Contributor.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contributorId", getContributorId());
        attributes.put("name", getName());
        attributes.put("email", getEmail());
        attributes.put("commits", getCommits());
        attributes.put("locAdditions", getLocAdditions());
        attributes.put("locDeletions", getLocDeletions());
        attributes.put("projectName", getProjectName());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long contributorId = (Long) attributes.get("contributorId");

        if (contributorId != null) {
            setContributorId(contributorId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        Integer commits = (Integer) attributes.get("commits");

        if (commits != null) {
            setCommits(commits);
        }

        Integer locAdditions = (Integer) attributes.get("locAdditions");

        if (locAdditions != null) {
            setLocAdditions(locAdditions);
        }

        Integer locDeletions = (Integer) attributes.get("locDeletions");

        if (locDeletions != null) {
            setLocDeletions(locDeletions);
        }

        String projectName = (String) attributes.get("projectName");

        if (projectName != null) {
            setProjectName(projectName);
        }
    }

    /**
    * Returns the primary key of this contributor.
    *
    * @return the primary key of this contributor
    */
    @Override
    public long getPrimaryKey() {
        return _contributor.getPrimaryKey();
    }

    /**
    * Sets the primary key of this contributor.
    *
    * @param primaryKey the primary key of this contributor
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _contributor.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the contributor ID of this contributor.
    *
    * @return the contributor ID of this contributor
    */
    @Override
    public long getContributorId() {
        return _contributor.getContributorId();
    }

    /**
    * Sets the contributor ID of this contributor.
    *
    * @param contributorId the contributor ID of this contributor
    */
    @Override
    public void setContributorId(long contributorId) {
        _contributor.setContributorId(contributorId);
    }

    /**
    * Returns the name of this contributor.
    *
    * @return the name of this contributor
    */
    @Override
    public java.lang.String getName() {
        return _contributor.getName();
    }

    /**
    * Sets the name of this contributor.
    *
    * @param name the name of this contributor
    */
    @Override
    public void setName(java.lang.String name) {
        _contributor.setName(name);
    }

    /**
    * Returns the email of this contributor.
    *
    * @return the email of this contributor
    */
    @Override
    public java.lang.String getEmail() {
        return _contributor.getEmail();
    }

    /**
    * Sets the email of this contributor.
    *
    * @param email the email of this contributor
    */
    @Override
    public void setEmail(java.lang.String email) {
        _contributor.setEmail(email);
    }

    /**
    * Returns the commits of this contributor.
    *
    * @return the commits of this contributor
    */
    @Override
    public int getCommits() {
        return _contributor.getCommits();
    }

    /**
    * Sets the commits of this contributor.
    *
    * @param commits the commits of this contributor
    */
    @Override
    public void setCommits(int commits) {
        _contributor.setCommits(commits);
    }

    /**
    * Returns the loc additions of this contributor.
    *
    * @return the loc additions of this contributor
    */
    @Override
    public int getLocAdditions() {
        return _contributor.getLocAdditions();
    }

    /**
    * Sets the loc additions of this contributor.
    *
    * @param locAdditions the loc additions of this contributor
    */
    @Override
    public void setLocAdditions(int locAdditions) {
        _contributor.setLocAdditions(locAdditions);
    }

    /**
    * Returns the loc deletions of this contributor.
    *
    * @return the loc deletions of this contributor
    */
    @Override
    public int getLocDeletions() {
        return _contributor.getLocDeletions();
    }

    /**
    * Sets the loc deletions of this contributor.
    *
    * @param locDeletions the loc deletions of this contributor
    */
    @Override
    public void setLocDeletions(int locDeletions) {
        _contributor.setLocDeletions(locDeletions);
    }

    /**
    * Returns the project name of this contributor.
    *
    * @return the project name of this contributor
    */
    @Override
    public java.lang.String getProjectName() {
        return _contributor.getProjectName();
    }

    /**
    * Sets the project name of this contributor.
    *
    * @param projectName the project name of this contributor
    */
    @Override
    public void setProjectName(java.lang.String projectName) {
        _contributor.setProjectName(projectName);
    }

    @Override
    public boolean isNew() {
        return _contributor.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _contributor.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _contributor.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _contributor.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _contributor.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _contributor.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _contributor.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _contributor.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _contributor.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _contributor.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _contributor.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ContributorWrapper((Contributor) _contributor.clone());
    }

    @Override
    public int compareTo(
        de.hska.wi.awp.datasource.gitlab.model.Contributor contributor) {
        return _contributor.compareTo(contributor);
    }

    @Override
    public int hashCode() {
        return _contributor.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<de.hska.wi.awp.datasource.gitlab.model.Contributor> toCacheModel() {
        return _contributor.toCacheModel();
    }

    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Contributor toEscapedModel() {
        return new ContributorWrapper(_contributor.toEscapedModel());
    }

    @Override
    public de.hska.wi.awp.datasource.gitlab.model.Contributor toUnescapedModel() {
        return new ContributorWrapper(_contributor.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _contributor.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _contributor.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _contributor.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContributorWrapper)) {
            return false;
        }

        ContributorWrapper contributorWrapper = (ContributorWrapper) obj;

        if (Validator.equals(_contributor, contributorWrapper._contributor)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Contributor getWrappedContributor() {
        return _contributor;
    }

    @Override
    public Contributor getWrappedModel() {
        return _contributor;
    }

    @Override
    public void resetOriginalValues() {
        _contributor.resetOriginalValues();
    }
}
