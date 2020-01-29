package org.macicame.arquivo.model.security;

import org.hibernate.envers.Audited;
import org.macicame.arquivo.model.base.Auditable;

import javax.persistence.*;

/**
 * Created by acacio on 15/03/19.
 */

@Audited
@Entity
public class User extends Auditable {
    @Column
    private String name;

    @Column(nullable = false)
    private boolean enabled;
    @Column
    private String phone;
    @Column(unique = true)
    private String email;
    @Column
    @Lob
    private Byte[] picture;

    @Column(unique = true)
    private String username;
    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
        enabled = true;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean estado) {
        this.enabled = estado;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
