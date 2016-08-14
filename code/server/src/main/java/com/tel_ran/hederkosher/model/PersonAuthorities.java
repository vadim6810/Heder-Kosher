/**
 * Created by Ruslan on 06.08.2016.
 */

package com.tel_ran.hederkosher.model;
import com.tel_ran.hederkosher.model.security.Role;

import java.util.Date;
import java.util.HashSet;

public class PersonAuthorities {
    private int id;
    private Date date;

    private HashSet<Role> roles;
    private Person person;
    private Room room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HashSet<Role> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<Role> roles) {
        this.roles = roles;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}