package de.hska.wi.awp.datasource.gitlab.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import de.hska.wi.awp.datasource.gitlab.model.Contributor;
import de.hska.wi.awp.datasource.gitlab.service.ContributorLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ContributorActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ContributorActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ContributorLocalServiceUtil.getService());
        setClass(Contributor.class);

        setClassLoader(de.hska.wi.awp.datasource.gitlab.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("contributorId");
    }
}
