package org.macicame.arquivo.model.security;

import org.apache.shiro.SecurityUtils;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acacio on 15/03/19.
 */

@ApplicationScoped
public class UserSessionImpl implements UserSession{
    @Override
    public boolean isValid() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    @Override
    public User getUser() {
        UserAuthorizationInfo userAuthorizationInfo = (UserAuthorizationInfo) SecurityUtils.getSubject().getPrincipals();
        return userAuthorizationInfo.getUser();
    }

    @Override
    public List<Role> getRoles() {
        List<Role> list = new ArrayList<>();
        list.add(getUser().getRole());
        return list;
    }

    @Override
    public String getUsername() {
        return getUser().getUsername();
    }
}
