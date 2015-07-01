package de.hska.wi.awp.datasource.gitlab.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ContributorService}.
 *
 * @author Brian Wing Shun Chan
 * @see ContributorService
 * @generated
 */
public class ContributorServiceWrapper implements ContributorService,
    ServiceWrapper<ContributorService> {
    private ContributorService _contributorService;

    public ContributorServiceWrapper(ContributorService contributorService) {
        _contributorService = contributorService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _contributorService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _contributorService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _contributorService.invokeMethod(name, parameterTypes, arguments);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public ContributorService getWrappedContributorService() {
        return _contributorService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedContributorService(
        ContributorService contributorService) {
        _contributorService = contributorService;
    }

    @Override
    public ContributorService getWrappedService() {
        return _contributorService;
    }

    @Override
    public void setWrappedService(ContributorService contributorService) {
        _contributorService = contributorService;
    }
}
