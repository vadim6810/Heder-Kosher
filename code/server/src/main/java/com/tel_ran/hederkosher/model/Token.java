/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model;

import com.tel_ran.hederkosher.annotations.Markable;

import javax.persistence.*;

//@Markable
@Entity
@Table(name = "token", schema = "heder-kosher", catalog = "")
public class Token {

    @Id
    @Column(name = "idtoken")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idtoken;

    @Basic
    @Column(name = "token", columnDefinition = "TEXT")
    private String token;

    @Basic
    @Column(name = "enabled")
    private Byte enabled;

    @Basic
    @Column(name = "person")
    private int person;

    public Token(String token, int person) {
        this.token = token;
        this.person = person;
        this.enabled = 1;
    }
    public Token(){this("",0);
    }

    public int getIdtoken() {
        return idtoken;
    }
    public void setIdtoken(int idtoken) {
        this.idtoken = idtoken;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public Byte getEnabled() {
        return enabled;
    }
    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

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

        Token that = (Token) o;

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
