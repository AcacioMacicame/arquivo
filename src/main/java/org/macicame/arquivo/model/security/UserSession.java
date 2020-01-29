package org.macicame.arquivo.model.security;

import java.io.Serializable;
import java.util.List;

/**
 * Created by acacio on 15/03/19.
 */

//TODO: REFACTOR THE INTERFACE IN HIS OWN PROJECT
public interface UserSession /*TODO<K, V>*/ extends Serializable {
    public boolean isValid();
    public User getUser();
    public List<Role> getRoles();
    String getUsername();
}
