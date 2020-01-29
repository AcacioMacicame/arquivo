package org.macicame.arquivo.controller.viewbean;

import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.macicame.arquivo.model.security.AuthenticationException;
import org.macicame.arquivo.service.security.SecurityService;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by acacio on 15/03/19.
 */

@RequestScoped
@Named
public class LoginViewBean implements Serializable{
    private final Logger logger = LoggerFactory.getLogger(LoginViewBean.class);

    @Inject
    SecurityService securityService;

    private String username;
    private String password;

    public void doLogin(){
        try {
            securityService.login(username, password);
            SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(Faces.getRequest());
            Faces.redirect(savedRequest != null ? savedRequest.getRequestUrl() : Faces.getRequestContextPath());
        }
        catch (AuthenticationException e) {
            Messages.addGlobalError("Utilizador desconhecido, por favor, tente de novo");
            logger.info("", e);
        } catch (IOException e) {
            Messages.addGlobalError("Erro inesperado " + e.getMessage());
            logger.info("", e);
        }
    }

    public void doLogout() throws IOException {
        securityService.logout();
        Faces.invalidateSession();
        Faces.redirect(Faces.getRequestContextPath());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
