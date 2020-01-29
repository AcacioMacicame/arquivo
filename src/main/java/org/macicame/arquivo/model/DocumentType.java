package org.macicame.arquivo.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by acacio on 15/03/19.
 */
public enum DocumentType {

    BI ("Bilhete de Identidade"),
    VOTERTICKET("Cartão de Eleitor"),
    DRIVINGLICENSE("Carta de Condução");

    DocumentType(String description) {
        this.description = description;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name();
    }

    private static final List<DocumentType> LIST;

    static {
        List<DocumentType> list = Arrays.asList(BI, DRIVINGLICENSE, VOTERTICKET);
        LIST = list;
    }

    public static List<DocumentType> getAll(){
        return LIST;
    }
}
