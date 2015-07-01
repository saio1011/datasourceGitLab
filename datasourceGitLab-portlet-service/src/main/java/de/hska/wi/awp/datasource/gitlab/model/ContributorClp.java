package de.hska.wi.awp.datasource.gitlab.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.gitlab.service.ClpSerializer;
import de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class ContributorClp extends BaseModelImpl<Contributor>
    implements Contributor {
    private long _contributorId;
    private String _name;
    private String _email;
    private int _commits;
    private int _locAdditions;
    private int _locDeletions;
    private String _projectName;
    private BaseModel<?> _contributorRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.gitlab.service.ClpSerializer.class;

    public ContributorClp() {
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
    public long getPrimaryKey() {
        return _contributorId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setContributorId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _contributorId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getContributorId() {
        return _contributorId;
    }

    @Override
    public void setContributorId(long contributorId) {
        _contributorId = contributorId;

        if (_contributorRemoteModel != null) {
            try {
                Class<?> clazz = _contributorRemoteModel.getClass();

                Method method = clazz.getMethod("setContributorId", long.class);

                method.invoke(_contributorRemoteModel, contributorId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_contributorRemoteModel != null) {
            try {
                Class<?> clazz = _contributorRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_contributorRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_contributorRemoteModel != null) {
            try {
                Class<?> clazz = _contributorRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_contributorRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getCommits() {
        return _commits;
    }

    @Override
    public void setCommits(int commits) {
        _commits = commits;

        if (_contributorRemoteModel != null) {
            try {
                Class<?> clazz = _contributorRemoteModel.getClass();

                Method method = clazz.getMethod("setCommits", int.class);

                method.invoke(_contributorRemoteModel, commits);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getLocAdditions() {
        return _locAdditions;
    }

    @Override
    public void setLocAdditions(int locAdditions) {
        _locAdditions = locAdditions;

        if (_contributorRemoteModel != null) {
            try {
                Class<?> clazz = _contributorRemoteModel.getClass();

                Method method = clazz.getMethod("setLocAdditions", int.class);

                method.invoke(_contributorRemoteModel, locAdditions);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getLocDeletions() {
        return _locDeletions;
    }

    @Override
    public void setLocDeletions(int locDeletions) {
        _locDeletions = locDeletions;

        if (_contributorRemoteModel != null) {
            try {
                Class<?> clazz = _contributorRemoteModel.getClass();

                Method method = clazz.getMethod("setLocDeletions", int.class);

                method.invoke(_contributorRemoteModel, locDeletions);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getProjectName() {
        return _projectName;
    }

    @Override
    public void setProjectName(String projectName) {
        _projectName = projectName;

        if (_contributorRemoteModel != null) {
            try {
                Class<?> clazz = _contributorRemoteModel.getClass();

                Method method = clazz.getMethod("setProjectName", String.class);

                method.invoke(_contributorRemoteModel, projectName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getContributorRemoteModel() {
        return _contributorRemoteModel;
    }

    public void setContributorRemoteModel(BaseModel<?> contributorRemoteModel) {
        _contributorRemoteModel = contributorRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _contributorRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_contributorRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            ContributorLocalServiceUtil.addContributor(this);
        } else {
            ContributorLocalServiceUtil.updateContributor(this);
        }
    }

    @Override
    public Contributor toEscapedModel() {
        return (Contributor) ProxyUtil.newProxyInstance(Contributor.class.getClassLoader(),
            new Class[] { Contributor.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        ContributorClp clone = new ContributorClp();

        clone.setContributorId(getContributorId());
        clone.setName(getName());
        clone.setEmail(getEmail());
        clone.setCommits(getCommits());
        clone.setLocAdditions(getLocAdditions());
        clone.setLocDeletions(getLocDeletions());
        clone.setProjectName(getProjectName());

        return clone;
    }

    @Override
    public int compareTo(Contributor contributor) {
        long primaryKey = contributor.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ContributorClp)) {
            return false;
        }

        ContributorClp contributor = (ContributorClp) obj;

        long primaryKey = contributor.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{contributorId=");
        sb.append(getContributorId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", commits=");
        sb.append(getCommits());
        sb.append(", locAdditions=");
        sb.append(getLocAdditions());
        sb.append(", locDeletions=");
        sb.append(getLocDeletions());
        sb.append(", projectName=");
        sb.append(getProjectName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.gitlab.model.Contributor");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contributorId</column-name><column-value><![CDATA[");
        sb.append(getContributorId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>commits</column-name><column-value><![CDATA[");
        sb.append(getCommits());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>locAdditions</column-name><column-value><![CDATA[");
        sb.append(getLocAdditions());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>locDeletions</column-name><column-value><![CDATA[");
        sb.append(getLocDeletions());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>projectName</column-name><column-value><![CDATA[");
        sb.append(getProjectName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
