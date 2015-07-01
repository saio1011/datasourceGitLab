package de.hska.wi.awp.datasource.gitlab.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.gitlab.model.Contributor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Contributor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Contributor
 * @generated
 */
public class ContributorCacheModel implements CacheModel<Contributor>,
    Externalizable {
    public long contributorId;
    public String name;
    public String email;
    public int commits;
    public int locAdditions;
    public int locDeletions;
    public String projectName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{contributorId=");
        sb.append(contributorId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", email=");
        sb.append(email);
        sb.append(", commits=");
        sb.append(commits);
        sb.append(", locAdditions=");
        sb.append(locAdditions);
        sb.append(", locDeletions=");
        sb.append(locDeletions);
        sb.append(", projectName=");
        sb.append(projectName);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Contributor toEntityModel() {
        ContributorImpl contributorImpl = new ContributorImpl();

        contributorImpl.setContributorId(contributorId);

        if (name == null) {
            contributorImpl.setName(StringPool.BLANK);
        } else {
            contributorImpl.setName(name);
        }

        if (email == null) {
            contributorImpl.setEmail(StringPool.BLANK);
        } else {
            contributorImpl.setEmail(email);
        }

        contributorImpl.setCommits(commits);
        contributorImpl.setLocAdditions(locAdditions);
        contributorImpl.setLocDeletions(locDeletions);

        if (projectName == null) {
            contributorImpl.setProjectName(StringPool.BLANK);
        } else {
            contributorImpl.setProjectName(projectName);
        }

        contributorImpl.resetOriginalValues();

        return contributorImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        contributorId = objectInput.readLong();
        name = objectInput.readUTF();
        email = objectInput.readUTF();
        commits = objectInput.readInt();
        locAdditions = objectInput.readInt();
        locDeletions = objectInput.readInt();
        projectName = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(contributorId);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        objectOutput.writeInt(commits);
        objectOutput.writeInt(locAdditions);
        objectOutput.writeInt(locDeletions);

        if (projectName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(projectName);
        }
    }
}
