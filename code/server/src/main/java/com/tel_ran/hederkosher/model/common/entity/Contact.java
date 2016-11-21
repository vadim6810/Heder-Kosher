package com.tel_ran.hederkosher.model.common.entity;

import javax.persistence.*;

/**
 * Created by Ruslan on 12.08.2016.
 */
@Entity
@Table(name = "contact")
public class Contact {
//    public enum ContactType {EMAIL,TELEPHONE}

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

//    @Embedded
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", length = 20)
    private ContactType type;

    @Column(name = "VALUE")
    private String value;

    public Contact() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public ContactType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }


    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
