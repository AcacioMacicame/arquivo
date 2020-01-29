package org.macicame.arquivo.service.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.macicame.arquivo.model.security.User;
import org.macicame.arquivo.model.security.UserSession;
import org.macicame.arquivo.service.CrudService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by acacio on 15/03/19.
 */

@ApplicationScoped
public class SecurityServiceImpl implements SecurityService, CrudService<User> {
    @Inject
    UserService userService;

    @Inject
    UserSession userSession;

    @Override
    public void login(String username, String password) {
        try {
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password, false));
        }catch(AuthenticationException e){
            throw new org.macicame.arquivo.model.security.AuthenticationException(e.getMessage(), e);
        }
    }

    @Override
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    @Override
    public User findByUsername(String username) {
        return userService.findByUsername(username);
    }

    @Override
    public User save(User entity) {
        //todo: securitylogic goes here

        return userService.save(entity);
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
        throw new RuntimeException("bulk user save not implemented.");
    }



    @Override
    public Optional<User> findById(Long aLong) {
        return userService.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return userService.existsById(aLong);
    }

    @Override
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> longs) {
        return userService.findAllById(longs);
    }

    @Override
    public long count() {
        return userService.count();
    }

    @Override
    public void deleteById(Long aLong) {
        userService.deleteById(aLong);
    }

    @Override
    public void delete(User entity) {
        userService.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {
        userService.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userService.deleteAll();
    }

    @Override
    public UserSession getAttachedToWebRequest() {
        //the inner implementation of getUser is Web Request contextualized since Shiro's implementation is based on ThreadLocal
        return userSession;
    }

    @Override
    public UserSession getCurrent() {
        //the inner implementation of getUser is Web Request contextualized since Shiro's implementation is based on ThreadLocal
        return getAttachedToWebRequest();
    }
}
