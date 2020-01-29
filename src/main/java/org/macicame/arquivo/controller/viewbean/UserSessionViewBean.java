package org.macicame.arquivo.controller.viewbean;

import org.macicame.arquivo.model.security.UserSession;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by acacio on 15/03/19.
 */
@RequestScoped
@Named
public class UserSessionViewBean {
    @Inject
    UserSession userSession;

    public UserSession getUserSession() {
        return userSession;
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }
}
