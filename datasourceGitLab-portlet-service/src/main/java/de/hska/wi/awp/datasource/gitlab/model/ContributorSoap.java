package de.hska.wi.awp.datasource.gitlab.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link de.hska.wi.awp.datasource.gitlab.service.http.ContributorServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see de.hska.wi.awp.datasource.gitlab.service.http.ContributorServiceSoap
 * @generated
 */
public class ContributorSoap implements Serializable {
    private long _contributorId;
    private String _name;
    private String _email;
    private int _commits;
    private int _locAdditions;
    private int _locDeletions;
    private String _projectName;

    public ContributorSoap() {
    }

    public static ContributorSoap toSoapModel(Contributor model) {
        ContributorSoap soapModel = new ContributorSoap();

        soapModel.setContributorId(model.getContributorId());
        soapModel.setName(model.getName());
        soapModel.setEmail(model.getEmail());
        soapModel.setCommits(model.getCommits());
        soapModel.setLocAdditions(model.getLocAdditions());
        soapModel.setLocDeletions(model.getLocDeletions());
        soapModel.setProjectName(model.getProjectName());

        return soapModel;
    }

    public static ContributorSoap[] toSoapModels(Contributor[] models) {
        ContributorSoap[] soapModels = new ContributorSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static ContributorSoap[][] toSoapModels(Contributor[][] models) {
        ContributorSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new ContributorSoap[models.length][models[0].length];
        } else {
            soapModels = new ContributorSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static ContributorSoap[] toSoapModels(List<Contributor> models) {
        List<ContributorSoap> soapModels = new ArrayList<ContributorSoap>(models.size());

        for (Contributor model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new ContributorSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _contributorId;
    }

    public void setPrimaryKey(long pk) {
        setContributorId(pk);
    }

    public long getContributorId() {
        return _contributorId;
    }

    public void setContributorId(long contributorId) {
        _contributorId = contributorId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public int getCommits() {
        return _commits;
    }

    public void setCommits(int commits) {
        _commits = commits;
    }

    public int getLocAdditions() {
        return _locAdditions;
    }

    public void setLocAdditions(int locAdditions) {
        _locAdditions = locAdditions;
    }

    public int getLocDeletions() {
        return _locDeletions;
    }

    public void setLocDeletions(int locDeletions) {
        _locDeletions = locDeletions;
    }

    public String getProjectName() {
        return _projectName;
    }

    public void setProjectName(String projectName) {
        _projectName = projectName;
    }
}
