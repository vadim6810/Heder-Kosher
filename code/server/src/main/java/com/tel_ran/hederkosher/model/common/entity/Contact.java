package com.tel_ran.hederkosher.model.common.entity;

import javax.persistence.*;

/**
 * Created by user on 12.08.2016.
 */
@Entity
@Table(name = "contact", schema = "heder-kosher", catalog = "")
public class Contact {
    private int person;
    private String telephones;
    private String email;
    private int idPerson;

    @Basic
    @Column(name = "person")
    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    @Basic
    @Column(name = "telephones")
    public String getTelephones() {
        return telephones;
    }

    public void setTelephones(String telephones) {
        this.telephones = telephones;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @Column(name = "idPerson")
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact that = (Contact) o;

        if (person != that.person) return false;
        if (idPerson != that.idPerson) return false;
        if (telephones != null ? !telephones.equals(that.telephones) : that.telephones != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = person;
        result = 31 * result + (telephones != null ? telephones.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + idPerson;
        return result;
    }
}
