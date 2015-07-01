package de.hska.wi.awp.datasource.gitlab.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.hska.wi.awp.datasource.gitlab.service.http.CommitServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.gitlab.service.http.CommitServiceSoap
 * @generated
 */
public class CommitSoap implements Serializable {
    private String _commitId;
    private String _authorName;
    private String _authorEmail;
    private String _titleCommit;
    private String _createdAt;
    private String _projectName;

    public CommitSoap() {
    }

    public static CommitSoap toSoapModel(Commit model) {
        CommitSoap soapModel = new CommitSoap();

        soapModel.setCommitId(model.getCommitId());
        soapModel.setAuthorName(model.getAuthorName());
        soapModel.setAuthorEmail(model.getAuthorEmail());
        soapModel.setTitleCommit(model.getTitleCommit());
        soapModel.setCreatedAt(model.getCreatedAt());
        soapModel.setProjectName(model.getProjectName());

        return soapModel;
    }

    public static CommitSoap[] toSoapModels(Commit[] models) {
        CommitSoap[] soapModels = new CommitSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CommitSoap[][] toSoapModels(Commit[][] models) {
        CommitSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CommitSoap[models.length][models[0].length];
        } else {
            soapModels = new CommitSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CommitSoap[] toSoapModels(List<Commit> models) {
        List<CommitSoap> soapModels = new ArrayList<CommitSoap>(models.size());

        for (Commit model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CommitSoap[soapModels.size()]);
    }

    public String getPrimaryKey() {
        return _commitId;
    }

    public void setPrimaryKey(String pk) {
        setCommitId(pk);
    }

    public String getCommitId() {
        return _commitId;
    }

    public void setCommitId(String commitId) {
        _commitId = commitId;
    }

    public String getAuthorName() {
        return _authorName;
    }

    public void setAuthorName(String authorName) {
        _authorName = authorName;
    }

    public String getAuthorEmail() {
        return _authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        _authorEmail = authorEmail;
    }

    public String getTitleCommit() {
        return _titleCommit;
    }

    public void setTitleCommit(String titleCommit) {
        _titleCommit = titleCommit;
    }

    public String getCreatedAt() {
        return _createdAt;
    }

    public void setCreatedAt(String createdAt) {
        _createdAt = createdAt;
    }

    public String getProjectName() {
        return _projectName;
    }

    public void setProjectName(String projectName) {
        _projectName = projectName;
    }
}
