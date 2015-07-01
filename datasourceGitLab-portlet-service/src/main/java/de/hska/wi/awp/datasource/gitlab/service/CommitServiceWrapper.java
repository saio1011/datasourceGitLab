package de.hska.wi.awp.datasource.gitlab.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommitService}.
 *
 * @author Brian Wing Shun Chan
 * @see CommitService
 * @generated
 */
public class CommitServiceWrapper implements CommitService,
    ServiceWrapper<CommitService> {
    private CommitService _commitService;

    public CommitServiceWrapper(CommitService commitService) {
        _commitService = commitService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _commitService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _commitService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _commitService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public CommitService getWrappedCommitService() {
        return _commitService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedCommitService(CommitService commitService) {
        _commitService = commitService;
    }

    @Override
    public CommitService getWrappedService() {
        return _commitService;
    }

    @Override
    public void setWrappedService(CommitService commitService) {
        _commitService = commitService;
    }
}
