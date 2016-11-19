/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.common.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DATE_CREATE", nullable = false)
    private Date dCreate;

    @Column(name = "DATE_CLOSE")
    private Date dClose;

    @ManyToOne(fetch = FetchType.LAZY)
    private Office office;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Address> address;

    @Column(name = "IS_ENABLE", nullable = false)
    private boolean isEnable;

    public Room(String name, Set<Address> address, Date dCreate, boolean isEnable) {
        this.name = name;
        this.address = address;
        this.dCreate = dCreate;
        this.isEnable = isEnable;
    }
    public Room() {
    }


    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
    public Set<Address> getAddress() {
        return address;
    }

    public Date getDcreate() {
        return dCreate;
    }
    public void setDcreate(Date dCreate) {
        this.dCreate = dCreate;
    }

    public Date getDclose() {
        return dClose;
    }
    public void setDclose(Date dClose) {
        this.dClose = dClose;
    }

    public boolean isEnable() {
        return isEnable;
    }
    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room that = (Room) o;

        if (id != that.id) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (address != null ? !address.equals(that.address) : that.address != null) return false;
//        if (dCreate != null ? !dCreate.equals(that.dCreate) : that.dCreate != null) return false;
//        if (dClose != null ? !dClose.equals(that.dClose) : that.dClose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (address != null ? address.hashCode() : 0);
//        result = 31 * result + (dCreate != null ? dCreate.hashCode() : 0);
//        result = 31 * result + (dClose != null ? dClose.hashCode() : 0);
        return result;
    }
}
