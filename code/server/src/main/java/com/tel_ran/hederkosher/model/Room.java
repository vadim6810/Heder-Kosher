package com.tel_ran.hederkosher.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by user on 12.08.2016.
 */
@Entity
@Table(name = "room", schema = "heder-kosher", catalog = "")
public class Room {
    private int idRoom;
    private String name;
    private String adress;
    private Timestamp dcreate;
    private Timestamp dclose;

    @Id
    @Column(name = "idRoom")
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "dcreate")
    public Timestamp getDcreate() {
        return dcreate;
    }

    public void setDcreate(Timestamp dcreate) {
        this.dcreate = dcreate;
    }

    @Basic
    @Column(name = "dclose")
    public Timestamp getDclose() {
        return dclose;
    }

    public void setDclose(Timestamp dclose) {
        this.dclose = dclose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room that = (Room) o;

        if (idRoom != that.idRoom) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (dcreate != null ? !dcreate.equals(that.dcreate) : that.dcreate != null) return false;
        if (dclose != null ? !dclose.equals(that.dclose) : that.dclose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoom;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (dcreate != null ? dcreate.hashCode() : 0);
        result = 31 * result + (dclose != null ? dclose.hashCode() : 0);
        return result;
    }
}
