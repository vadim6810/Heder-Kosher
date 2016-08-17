/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model;

import com.tel_ran.hederkosher.annotations.Markable;

import javax.persistence.*;
//import java.sql.Timestamp;
import java.util.Date;

//@Markable
@Entity
@Table(name = "room", schema = "heder-kosher", catalog = "")
public class Room {
    @Id
    @Column(name = "idRoom")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRoom;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "adress", columnDefinition = "TEXT")
    private String adress;

    @Basic
    @Column(name = "dcreate")
    private Date dcreate;

    @Basic
    @Column(name = "dclose")
    private Date dclose;

    public Room(String name, String adress, Date dcreate) {
        this.name = name;
        this.adress = adress;
        this.dcreate = dcreate;
    }

    public Room(){this("","",new Date());
    }

    public int getIdRoom() {
        return idRoom;
    }
    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getDcreate() {
        return dcreate;
    }
    public void setDcreate(Date dcreate) {
        this.dcreate = dcreate;
    }

    public Date getDclose() {
        return dclose;
    }
    public void setDclose(Date dclose) {
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
