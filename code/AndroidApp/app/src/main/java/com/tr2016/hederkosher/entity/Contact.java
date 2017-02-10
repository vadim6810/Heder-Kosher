package com.tr2016.hederkosher.entity;

/**
 * Created by Ruslan on 12.08.2016.
 */
public class Contact {
//    public enum ContactType {EMAIL,TELEPHONE}

    private long id;

    private Person person;

    private ContactType type;

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
