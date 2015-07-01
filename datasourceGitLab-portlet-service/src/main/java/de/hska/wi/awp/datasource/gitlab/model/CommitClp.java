package de.hska.wi.awp.datasource.gitlab.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import de.hska.wi.awp.datasource.gitlab.service.ClpSerializer;
import de.hska.wi.awp.datasource.gitlab.service.CommitLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class CommitClp extends BaseModelImpl<Commit> implements Commit {
    private String _commitId;
    private String _authorName;
    private String _authorEmail;
    private String _titleCommit;
    private String _createdAt;
    private String _projectName;
    private BaseModel<?> _commitRemoteModel;
    private Class<?> _clpSerializerClass = de.hska.wi.awp.datasource.gitlab.service.ClpSerializer.class;

    public CommitClp() {
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
    public String getPrimaryKey() {
        return _commitId;
    }

    @Override
    public void setPrimaryKey(String primaryKey) {
        setCommitId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _commitId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((String) primaryKeyObj);
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

    @Override
    public String getCommitId() {
        return _commitId;
    }

    @Override
    public void setCommitId(String commitId) {
        _commitId = commitId;

        if (_commitRemoteModel != null) {
            try {
                Class<?> clazz = _commitRemoteModel.getClass();

                Method method = clazz.getMethod("setCommitId", String.class);

                method.invoke(_commitRemoteModel, commitId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAuthorName() {
        return _authorName;
    }

    @Override
    public void setAuthorName(String authorName) {
        _authorName = authorName;

        if (_commitRemoteModel != null) {
            try {
                Class<?> clazz = _commitRemoteModel.getClass();

                Method method = clazz.getMethod("setAuthorName", String.class);

                method.invoke(_commitRemoteModel, authorName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAuthorEmail() {
        return _authorEmail;
    }

    @Override
    public void setAuthorEmail(String authorEmail) {
        _authorEmail = authorEmail;

        if (_commitRemoteModel != null) {
            try {
                Class<?> clazz = _commitRemoteModel.getClass();

                Method method = clazz.getMethod("setAuthorEmail", String.class);

                method.invoke(_commitRemoteModel, authorEmail);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitleCommit() {
        return _titleCommit;
    }

    @Override
    public void setTitleCommit(String titleCommit) {
        _titleCommit = titleCommit;

        if (_commitRemoteModel != null) {
            try {
                Class<?> clazz = _commitRemoteModel.getClass();

                Method method = clazz.getMethod("setTitleCommit", String.class);

                method.invoke(_commitRemoteModel, titleCommit);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCreatedAt() {
        return _createdAt;
    }

    @Override
    public void setCreatedAt(String createdAt) {
        _createdAt = createdAt;

        if (_commitRemoteModel != null) {
            try {
                Class<?> clazz = _commitRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatedAt", String.class);

                method.invoke(_commitRemoteModel, createdAt);
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

        if (_commitRemoteModel != null) {
            try {
                Class<?> clazz = _commitRemoteModel.getClass();

                Method method = clazz.getMethod("setProjectName", String.class);

                method.invoke(_commitRemoteModel, projectName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getCommitRemoteModel() {
        return _commitRemoteModel;
    }

    public void setCommitRemoteModel(BaseModel<?> commitRemoteModel) {
        _commitRemoteModel = commitRemoteModel;
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

        Class<?> remoteModelClass = _commitRemoteModel.getClass();

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

        Object returnValue = method.invoke(_commitRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CommitLocalServiceUtil.addCommit(this);
        } else {
            CommitLocalServiceUtil.updateCommit(this);
        }
    }

    @Override
    public Commit toEscapedModel() {
        return (Commit) ProxyUtil.newProxyInstance(Commit.class.getClassLoader(),
            new Class[] { Commit.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CommitClp clone = new CommitClp();

        clone.setCommitId(getCommitId());
        clone.setAuthorName(getAuthorName());
        clone.setAuthorEmail(getAuthorEmail());
        clone.setTitleCommit(getTitleCommit());
        clone.setCreatedAt(getCreatedAt());
        clone.setProjectName(getProjectName());

        return clone;
    }

    @Override
    public int compareTo(Commit commit) {
        String primaryKey = commit.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CommitClp)) {
            return false;
        }

        CommitClp commit = (CommitClp) obj;

        String primaryKey = commit.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
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
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{commitId=");
        sb.append(getCommitId());
        sb.append(", authorName=");
        sb.append(getAuthorName());
        sb.append(", authorEmail=");
        sb.append(getAuthorEmail());
        sb.append(", titleCommit=");
        sb.append(getTitleCommit());
        sb.append(", createdAt=");
        sb.append(getCreatedAt());
        sb.append(", projectName=");
        sb.append(getProjectName());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("de.hska.wi.awp.datasource.gitlab.model.Commit");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>commitId</column-name><column-value><![CDATA[");
        sb.append(getCommitId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorName</column-name><column-value><![CDATA[");
        sb.append(getAuthorName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>authorEmail</column-name><column-value><![CDATA[");
        sb.append(getAuthorEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>titleCommit</column-name><column-value><![CDATA[");
        sb.append(getTitleCommit());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdAt</column-name><column-value><![CDATA[");
        sb.append(getCreatedAt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>projectName</column-name><column-value><![CDATA[");
        sb.append(getProjectName());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
