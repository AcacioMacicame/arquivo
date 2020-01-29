package org.macicame.arquivo.model.security;

import java.util.Arrays;
import java.util.List;

/**
 * Created by acacio on 15/03/19.
 */
public enum Role {

    ADMINISTRATOR("Administrador"),
    MANAGER("Gestor"),
    OPERATOR("Operador");

    Role(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<Role> LIST;
    static {
        List<Role> list = Arrays.asList(ADMINISTRATOR, MANAGER, OPERATOR);
        LIST = list;
    }

    public static List<Role> getAll(){
        return LIST;
    }

    public boolean isAdministrator(){
        return ADMINISTRATOR.equals(this);
    }
    public boolean isManager(){
        return MANAGER.equals(this);
    }
    public boolean isOperator(){
        return OPERATOR.equals(this);
    }
}
