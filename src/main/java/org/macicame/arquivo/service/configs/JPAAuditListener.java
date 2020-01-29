package org.macicame.arquivo.service.configs;

import org.macicame.arquivo.model.base.Auditable;
import org.macicame.arquivo.service.security.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by acacio on 15/03/19.
 *
 * This will affect only Auditable entities and not all of them
 * This is an implementation totally independent of envers and totally JPA (no hibernate specific).
 * There implementation of XML logs and creation of a revision can be done or even another micro-framework emulating envers
 *
 *
 * This is tested to be executed before envers, so it can be used in combination
 *
 */
public class JPAAuditListener implements Serializable{
    private final Logger logger = LoggerFactory.getLogger(JPAAuditListener.class);

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

    @PrePersist
    public void prePresist(Object o) {
        logger.info("called prePresist");
        if (o instanceof Auditable) {
            Auditable auditable = (Auditable) o;
            final Date created = new Date();
            auditable.setCreatedDate(created);
            auditable.setModifiedDate(null);
            auditable.setCreatedBy(getSecurityService().getCurrent().getUser());
            auditable.setModifiedBy(null);
        }
    }

    @PreUpdate
    public void preUpdate(Object o) {
        logger.info("called preUpdate");
        if (o instanceof Auditable) {
            Auditable auditable = (Auditable) o;
            final Date created = new Date();
            auditable.setModifiedDate(created);
            auditable.setModifiedBy(getSecurityService().getCurrent().getUser());
        }
    }

}
