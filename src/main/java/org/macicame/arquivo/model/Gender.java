package org.macicame.arquivo.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by acacio on 15/03/19.
 */
public enum Gender {

    MALE("Masculino"),
    FEMALE("Feminino");

    Gender(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<Gender> LIST;

    static {
        List<Gender> list = Arrays.asList(MALE, FEMALE);
        LIST = list;
    }

    public static List<Gender> getAll(){
        return LIST;
    }
}
