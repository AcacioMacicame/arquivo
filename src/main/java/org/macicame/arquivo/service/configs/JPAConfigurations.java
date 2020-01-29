package org.macicame.arquivo.service.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

/**
 * Created by acacio on 15/03/19.
 */

public class JPAConfigurations implements Serializable {

    private final Logger logger = LoggerFactory.getLogger(TransactionalInterceptor.class);
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("arquivoPU");//todo: destroy the factory when closing the app

    @Produces
    @RequestScoped
    public EntityManager entityManager() {
        logger.info("creating my entity manager");
        return factory.createEntityManager();
    }

    public void close(@Disposes EntityManager manager) {
        logger.info("closing my entity manager");
        manager.close();
    }
}