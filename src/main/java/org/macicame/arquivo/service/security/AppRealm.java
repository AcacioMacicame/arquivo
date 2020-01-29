package org.macicame.arquivo.service.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.macicame.arquivo.model.security.User;
import org.macicame.arquivo.model.security.UserAuthorizationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by acacio on 15/03/19.
 */
public class AppRealm extends AuthorizingRealm {
    //This object is created by shiro and is not CDI aware
    //@Inject
    //SecurityService securityService;

    private final Logger logger = LoggerFactory.getLogger(AppRealm.class);

    public AppRealm() {
        this.setCacheManager(new MemoryConstrainedCacheManager());
        logger.info("app custom real initiatized with in-memory cache" + getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return (UserAuthorizationInfo) principals;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        logger.info("Collecting authentication info from realm " + getName());
        if (!(token instanceof UsernamePasswordToken)) {
            String message = "Unsupported token of type " + token.getClass().getName() + ".  " + UsernamePasswordToken.class.getName() + " is required.";
            logger.warn(message);
            throw new UnsupportedTokenException(message);
        }
        UsernamePasswordToken uptoken = (UsernamePasswordToken) token;

        Instance<SecurityService> securityServiceInstance = CDI.current().select(SecurityService.class);
        SecurityService securityService = securityServiceInstance.get();
        User user = securityService.findByUsername(uptoken.getUsername());

        //todo: hash and salt passwords
        if (user == null || user.getPassword() == null) {
            throw new AuthenticationException("invalid credentials");
        }


        if (!user.isEnabled()){
            throw new AuthenticationException("user disabled");
        }

        String password = String.copyValueOf(uptoken.getPassword());
        if (!user.getPassword().equals(password)) {
            throw new AuthenticationException("invalid credentials");
        }

        //collect information
        UserAuthorizationInfo info = new UserAuthorizationInfo(uptoken.getPrincipal(), uptoken.getCredentials(), this.getName());
        //add the role: app supports only 1 up to now
        Collection<String> rolesList = new ArrayList<>(1);
        rolesList.add(user.getRole().getName());
        info.setRoles(rolesList);
        //no fine grained permissions set yet
        info.setStringPermissions(new ArrayList<>());
        info.setObjectPermissions(new ArrayList<>());
        info.setUser(user);

        securityServiceInstance.destroy(securityService);
        return info;

    }


}