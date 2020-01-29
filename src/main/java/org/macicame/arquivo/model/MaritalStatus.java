package org.macicame.arquivo.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by acacio on 15/03/19.
 */
public enum MaritalStatus {

    NOTMARRIED("Solteiro(a)"),
    MARRIED("Casado(a)"),
    DIVORCED("Divorciado(a)"),
    WIDOWER("Viúvo(a)");

    MaritalStatus(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<MaritalStatus> LIST;

    static {
        List<MaritalStatus> list = Arrays.asList(NOTMARRIED, MARRIED, DIVORCED, WIDOWER);
        LIST = list;
    }

    public static List<MaritalStatus> getAll(){
        return LIST;
    }
}
