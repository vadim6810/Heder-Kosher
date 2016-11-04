/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.common.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "office") //, schema = "heder-kosher", catalog = ""
public class Office {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS", nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(name = "DATE_CREATE", nullable = false)
    private LocalDateTime dCreate;

    @Column(name = "DATE_CLOSE")
    private LocalDateTime dClose;



    public Office(String name, String address, LocalDateTime dCreate) {
        this.name = name;
        this.address = address;
        this.dCreate = dCreate;
    }
    public Office() {
    }


//    public void setId(long id) {
//        this.id = id;
//    }
    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public LocalDateTime getDcreate() {
        return dCreate;
    }
    public void setDcreate(LocalDateTime dCreate) {
        this.dCreate = dCreate;
    }

    public LocalDateTime getDclose() {
        return dClose;
    }
    public void setDclose(LocalDateTime dClose) {
        this.dClose = dClose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office that = (Office) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (dCreate != null ? !dCreate.equals(that.dCreate) : that.dCreate != null) return false;
        if (dClose != null ? !dClose.equals(that.dClose) : that.dClose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (dCreate != null ? dCreate.hashCode() : 0);
        result = 31 * result + (dClose != null ? dClose.hashCode() : 0);
        return result;
    }
}