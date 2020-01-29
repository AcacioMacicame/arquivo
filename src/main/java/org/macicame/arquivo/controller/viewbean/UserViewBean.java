package org.macicame.arquivo.controller.viewbean;

import org.macicame.arquivo.model.security.Role;
import org.macicame.arquivo.model.security.User;
import org.macicame.arquivo.model.security.UserSession;
import org.macicame.arquivo.service.CrudService;
import org.macicame.arquivo.service.configs.Transactional;
import org.macicame.arquivo.service.security.SecurityService;
import org.macicame.arquivo.service.security.UserService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by acacio on 15/03/19.
 */

@ViewScoped
@Named
public class UserViewBean extends CrudViewBean<User> {
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

    @Transactional
    public void disable(User user){
        user.setEnabled(false);
        service.save(user);
    }

    @Transactional
    public void enable(User user){
        user.setEnabled(true);
        service.save(user);
    }

    public List<Role> getAllRoles(){
        return Role.getAll();
    }

}



