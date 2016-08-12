package com.tel_ran.hederkosher.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by user on 12.08.2016.
 */
@Entity
@Table(name = "personroom", schema = "heder-kosher", catalog = "")
public class PersonRoomEntity {
    private int id;
    private int person;
    private int role;
    private int room;
    private Timestamp date;
    private byte enabled;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "person")
    public int getPerson() {
        return person;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    @Basic
    @Column(name = "role")
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Basic
    @Column(name = "room")
    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "enabled")
    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonRoomEntity that = (PersonRoomEntity) o;

        if (id != that.id) return false;
        if (person != that.person) return false;
        if (role != that.role) return false;
        if (room != that.room) return false;
        if (enabled != that.enabled) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person;
        result = 31 * result + role;
        result = 31 * result + room;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) enabled;
        return result;
    }
}
