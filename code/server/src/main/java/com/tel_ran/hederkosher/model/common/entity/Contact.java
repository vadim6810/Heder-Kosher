package com.tel_ran.hederkosher.model.common.entity;

import javax.persistence.*;

/**
 * Created by Ruslan on 12.08.2016.
 */
@Entity
@Table(name = "person_contact") //, schema = "heder-kosher", catalog = ""
public class Contact {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "TELEPHONES", nullable = false)
    private String telephones;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", foreignKey = @ForeignKey(name = "FK_PERSON_CONTACT$PERSON_ID"))
    private Person person;

    public Contact(String telephones, String email, Person person) {
        this.telephones = telephones;
        this.email = email;
        this.person = person;
    }
    public Contact() {
    }


    public long getId() {
        return id;
    }
//    public void setId(long id) {
//        this.ID = id;
//    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact that = (Contact) o;

        if (id != that.id) return false;
        if (person != null ? !person.equals(that.person) : that.person != null) return false;
        if (telephones != null ? !telephones.equals(that.telephones) : that.telephones != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)id ;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (telephones != null ? telephones.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
