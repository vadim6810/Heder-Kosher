package com.tel_ran.hederkosher.model.entity;

import javax.persistence.*;

/**
 * Created by user on 12.08.2016.
 */
@Entity
@Table(name = "token", schema = "heder-kosher", catalog = "")
public class TokenEntity {
    private int idtoken;
    private String token;
    private Byte enabled;
    private int person;

    @Id
    @Column(name = "idtoken")
    public int getIdtoken() {
        return idtoken;
    }

    public void setIdtoken(int idtoken) {
        this.idtoken = idtoken;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "enabled")
    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "person")
    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokenEntity that = (TokenEntity) o;

        if (idtoken != that.idtoken) return false;
        if (person != that.person) return false;
        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtoken;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + person;
        return result;
    }
}
