package org.macicame.arquivo.model.base;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.macicame.arquivo.service.configs.UserRevisionListener;

import javax.persistence.Entity;

/**
 * Created by acacio on 15/03/19.
 */
@Entity
@RevisionEntity(UserRevisionListener.class)
public class UserRevEntity extends DefaultRevisionEntity {
    private String userPrincipal;

    public String getUserPrincipal() {
        return userPrincipal;
    }

    public void setUserPrincipal(String userPrincipal) {
        this.userPrincipal = userPrincipal;
    }
}