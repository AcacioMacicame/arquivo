package org.macicame.arquivo.service.security;

import org.macicame.arquivo.model.security.User;
import org.macicame.arquivo.service.CrudService;

/**
 * Created by acacio on 15/03/19.
 */
//not public, only accessible within this package
public interface UserService extends CrudService<User> {
    User findByUsername(String username);

}
