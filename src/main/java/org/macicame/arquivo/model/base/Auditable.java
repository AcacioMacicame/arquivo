package org.macicame.arquivo.model.base;

import org.hibernate.envers.Audited;
import org.macicame.arquivo.model.security.User;
import org.macicame.arquivo.service.configs.JPAAuditListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by acacio on 15/03/19.
 */
@MappedSuperclass
@EntityListeners(JPAAuditListener.class)
@Audited
public abstract class Auditable extends Identifiable {
    @ManyToOne
    private User createdBy;
    @Column
    private Date createdDate;
    @ManyToOne
    private User modifiedBy;
    @Column
    private Date modifiedDate;

    public Auditable() {
    }

    public Auditable(User createdBy, Date createdDate, User modifiedBy, Date modifiedDate) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
