package org.macicame.arquivo.controller.viewbean;

import org.macicame.arquivo.model.security.User;
import org.macicame.arquivo.model.security.UserSession;
import org.macicame.arquivo.service.CrudService;
import org.macicame.arquivo.service.configs.Transactional;
import org.macicame.arquivo.service.security.SecurityService;
import org.macicame.arquivo.service.security.UserService;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by acacio on 15/03/19.
 */

@ViewScoped
@Named
public class UserSelfUpdateViewBean extends CrudViewBean<User> {
    @Inject
    private SecurityService securityService;

    @Inject
    UserSession userSession;

    @Inject
    UserService service;

    @Override
    public CrudService<User> service() {
        return (CrudService<User>)securityService;
    }

    @Override
    public User createNew() {
        return new User();
    }

    @PostConstruct
    public void init(){
        setSelected(userSession.getUser());
    }

    @Transactional
    public void update(){
        super.update(getSelected());
        Messages.addGlobalInfo("Utilizador Actualizado com sucesso");
    }


}



