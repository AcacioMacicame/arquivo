package org.macicame.arquivo.service.security;

import org.macicame.arquivo.model.security.User;
import org.macicame.arquivo.model.security.UserSession;
import org.macicame.arquivo.service.base.BaseService;

/**
 * Created by acacio on 15/03/19.
 */

public interface SecurityService extends BaseService {
    UserSession getAttachedToWebRequest();
    UserSession getCurrent();
    void login(String username, String password);
    void logout();
    User findByUsername(String username);
}