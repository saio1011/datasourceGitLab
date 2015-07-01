package de.hska.wi.awp.datasource.gitlab.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import de.hska.wi.awp.datasource.gitlab.model.Commit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Commit in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Commit
 * @generated
 */
public class CommitCacheModel implements CacheModel<Commit>, Externalizable {
    public String commitId;
    public String authorName;
    public String authorEmail;
    public String titleCommit;
    public String createdAt;
    public String projectName;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{commitId=");
        sb.append(commitId);
        sb.append(", authorName=");
        sb.append(authorName);
        sb.append(", authorEmail=");
        sb.append(authorEmail);
        sb.append(", titleCommit=");
        sb.append(titleCommit);
        sb.append(", createdAt=");
        sb.append(createdAt);
        sb.append(", projectName=");
        sb.append(projectName);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Commit toEntityModel() {
        CommitImpl commitImpl = new CommitImpl();

        if (commitId == null) {
            commitImpl.setCommitId(StringPool.BLANK);
        } else {
            commitImpl.setCommitId(commitId);
        }

        if (authorName == null) {
            commitImpl.setAuthorName(StringPool.BLANK);
        } else {
            commitImpl.setAuthorName(authorName);
        }

        if (authorEmail == null) {
            commitImpl.setAuthorEmail(StringPool.BLANK);
        } else {
            commitImpl.setAuthorEmail(authorEmail);
        }

        if (titleCommit == null) {
            commitImpl.setTitleCommit(StringPool.BLANK);
        } else {
            commitImpl.setTitleCommit(titleCommit);
        }

        if (createdAt == null) {
            commitImpl.setCreatedAt(StringPool.BLANK);
        } else {
            commitImpl.setCreatedAt(createdAt);
        }

        if (projectName == null) {
            commitImpl.setProjectName(StringPool.BLANK);
        } else {
            commitImpl.setProjectName(projectName);
        }

        commitImpl.resetOriginalValues();

        return commitImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        commitId = objectInput.readUTF();
        authorName = objectInput.readUTF();
        authorEmail = objectInput.readUTF();
        titleCommit = objectInput.readUTF();
        createdAt = objectInput.readUTF();
        projectName = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (commitId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(commitId);
        }

        if (authorName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(authorName);
        }

        if (authorEmail == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(authorEmail);
        }

        if (titleCommit == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(titleCommit);
        }

        if (createdAt == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(createdAt);
        }

        if (projectName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(projectName);
        }
    }
}
