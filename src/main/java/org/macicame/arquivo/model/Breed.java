package org.macicame.arquivo.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by acacio on 16/03/19.
 */
public enum Breed {

    BLACKAFRICAN("Negra Africana" ),
    AUSTRALIANBLACK("Negra Australiana"),
    ASIANYELLOW("Amarela Asiática" ),
    EUROPEANWHITE("Branca Europeia");

    Breed(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<Breed> LIST;

    static {
        List<Breed> list = Arrays.asList(BLACKAFRICAN, AUSTRALIANBLACK, ASIANYELLOW, EUROPEANWHITE);
        LIST = list;
    }

    public static List<Breed> getAll(){
        return LIST;
    }
}
