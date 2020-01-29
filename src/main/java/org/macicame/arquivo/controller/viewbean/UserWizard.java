package org.macicame.arquivo.controller.viewbean;

import org.macicame.arquivo.model.User;
import org.macicame.arquivo.model.security.Role;
import org.macicame.arquivo.model.security.UserSession;
import org.macicame.arquivo.service.CrudService;
import org.macicame.arquivo.service.configs.Transactional;
import org.macicame.arquivo.service.security.SecurityService;
import org.macicame.arquivo.service.security.UserService;
import org.primefaces.event.FlowEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by acacio on 15/03/19.
 */

@ManagedBean
@ViewScoped
public class UserWizard implements Serializable {

    private User user = new User();

    private boolean skip;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void save() {
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getFirstname());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}



