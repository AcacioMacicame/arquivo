package org.macicame.arquivo.model;

import org.hibernate.envers.Audited;
import org.macicame.arquivo.model.base.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by acacio on 16/03/19.
 */

@Audited
@Entity
public class Province extends Identifiable {

    @Column(unique = true)
    private String code;

    @Column(unique = true)
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
