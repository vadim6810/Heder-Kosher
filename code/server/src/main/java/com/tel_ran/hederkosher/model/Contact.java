/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model;

import com.tel_ran.hederkosher.annotations.Markable;
import javax.persistence.*;

//@Markable
@Entity
@Table(name = "contact", schema = "heder-kosher", catalog = "")
public class Contact {

    @Id
    @Column(name = "idContact")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContact;

    @Basic
    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @Column(name = "person")
    private int person;

    @Basic
    @Column(name = "telephones")
    private String telephones;

    @Basic
    @Column(name = "email")
    private String email;

    public Contact(int person, String telephones, String email) {
        this.person = person;
        this.telephones = telephones;
        this.email = email;
    }
    public Contact(){
        this(0, "", "");
    }

    public int getPerson() {
        return person;
    }
    public void setPerson(int person) {
        this.person = person;
    }

    public String getTelephones() {
        return telephones;
    }
    public void setTelephones(String telephones) {
        this.telephones = telephones;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdContact() {
        return idContact;
    }
    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact that = (Contact) o;

        if (person != that.person) return false;
        if (idContact != that.idContact) return false;
        if (telephones != null ? !telephones.equals(that.telephones) : that.telephones != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = person;
        result = 31 * result + (telephones != null ? telephones.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + idContact;
        return result;
    }
}
