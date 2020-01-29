package org.macicame.arquivo.model.base;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by acacio on 15/03/19.
 */
@MappedSuperclass
public abstract class Identifiable implements Serializable{
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    public Identifiable() {

    }

    public Identifiable(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identifiable)) return false;

        Identifiable that = (Identifiable) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public boolean isNew()
    {
        return id == null;
    }


    @Override
    public String toString() {
        return "Identifiable{" +
                "id=" + id +
                '}';
    }
}
