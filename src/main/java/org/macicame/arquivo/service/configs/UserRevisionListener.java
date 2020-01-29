package org.macicame.arquivo.service.configs;

import org.hibernate.envers.RevisionListener;
import org.macicame.arquivo.model.base.UserRevEntity;
import org.macicame.arquivo.service.security.SecurityService;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;

/**
 * Created by acacio on 15/03/19.
 */

public class UserRevisionListener implements RevisionListener {
    //@Inject
    SecurityService securityService;

    public SecurityService getSecurityService(){
        //TODO: if not CDI-aware, check inner code, if an instance is only located and returned or created (performance)
        if(securityService == null) {
            Instance<SecurityService> securityServiceInstance = CDI.current().select(SecurityService.class);
            securityService = securityServiceInstance.get();
        }
        return securityService;
        //TODO: check code to understand the destruction, for performance reasons this can compromise performance
        //securityServiceInstance.destroy(securityService);
    }

    @Override
    public void newRevision(Object revisionEntity) {
        UserRevEntity userRevEntity = (UserRevEntity) revisionEntity;
        userRevEntity.setUserPrincipal(getSecurityService().getCurrent().getUsername());

    }
}