package org.macicame.arquivo.model.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.Collection;

/**
 * Created by acacio on 15/03/19.
 */
//check SimpleAuthorizationInfoImplementation from shiro
public class UserAuthorizationInfo extends SimplePrincipalCollection implements AuthenticationInfo, AuthorizationInfo {
    private Object credentials;
    private Collection<String> roles;
    private Collection<String> stringPermissions;
    private Collection<Permission> objectPermissions;
    private User user;

    public UserAuthorizationInfo(Object principal, Object credentials, String realmName) {
        this.credentials = credentials;
        if (principal instanceof Collection) {
            addAll((Collection) principal, realmName);
        } else {
            add(principal, realmName);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public PrincipalCollection getPrincipals() {
        return this;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    public void setCredentials(Object credentials) {
        this.credentials = credentials;
    }

    @Override
    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    @Override
    public Collection<String> getStringPermissions() {
        return stringPermissions;
    }

    public void setStringPermissions(Collection<String> stringPermissions) {
        this.stringPermissions = stringPermissions;
    }

    @Override
    public Collection<Permission> getObjectPermissions() {
        return objectPermissions;
    }

    public void setObjectPermissions(Collection<Permission> objectPermissions) {
        this.objectPermissions = objectPermissions;
    }

}