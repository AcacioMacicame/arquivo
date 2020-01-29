package org.macicame;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.macicame.arquivo.controller.viewbean.UserViewBean;
import org.macicame.arquivo.model.security.Role;
import org.macicame.arquivo.model.security.User;
import org.macicame.arquivo.service.security.UserService;

import javax.inject.Inject;
import java.util.Optional;


/**
 * Hello world!
 *
 */
public class Test {

    @org.junit.Test
    public void salvar(){

        User user = new User();
        user.setEnabled(true);
        user.setUsername("insert into User(id,enabled, password, username,role) values(1,1,\"admin\",\"admin\",\"ADMINISTRATOR\");");
        user.setPassword("admin");
        user.setRole(Role.ADMINISTRATOR);

        UserViewBean userViewBean = new UserViewBean();
        userViewBean.service().save(user);
    }
}
