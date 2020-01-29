package org.macicame.arquivo.service.configs;

/**
 * Created by acacio on 15/03/19.
 */

import org.omnifaces.util.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

@Transactional @Interceptor
public class TransactionalInterceptor implements Serializable{
    private final Logger logger = LoggerFactory.getLogger(TransactionalInterceptor.class);

    @Inject
    EntityManager entityManager;

    @AroundInvoke
    public Object manageTransaction(InvocationContext context) throws Exception {
        EntityTransaction tx = entityManager.getTransaction();
        String methodName = context.getMethod().getDeclaringClass().getSimpleName() + "#" + context.getMethod().getName();
        if(!tx.isActive()){
            tx.begin();
            logger.info("transaction opened from " + methodName);
            Object result = null;
            try {
                result = context.proceed();
            }catch (Throwable e){
                logger.info("rolling back transaction ..." + methodName);
                tx.rollback();
               throw e;
            }
            try {
                tx.commit();

                logger.info("Committing transaction from " + methodName );
                if(context.getMethod().getName().equals("delete")){
                    Messages.addGlobalInfo("Eliminado  com sucesso ");
                }
                return result;

            }catch(javax.persistence.RollbackException e){
                    if(context.getMethod().getName().equals("add")){

                        Messages.addFlashGlobalWarn("Não pode duplicar os dados ");

                        return  null;
                    }

            }
        }

        logger.info("joining transaction from " + methodName);
        return context.proceed();
    }
}
