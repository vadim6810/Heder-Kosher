/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tr2016.hederkosher.entity;

import java.util.Date;

public class Office {

    private long id;

    private String name;

    private Date dateCreate;

    private Date dateClose;

    private boolean enable;

    public Office(String name, Date dateCreate, boolean enable) {
        this.name = name;
        this.dateCreate = dateCreate;
        this.enable = enable;
    }

    public Office() {
    }


    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public Date getDateClose() {
        return dateClose;
    }

    public boolean isEnable() {
        return enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office that = (Office) o;

        if (id != that.id) return false;
//        if (name != null ? !name.equals(that.name) : that.name != null) return false;
//        if (address != null ? !address.equals(that.address) : that.address != null) return false;
//        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
//        if (dateClose != null ? !dateClose.equals(that.dateClose) : that.dateClose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (address != null ? address.hashCode() : 0);
//        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
//        result = 31 * result + (dateClose != null ? dateClose.hashCode() : 0);
        return result;
    }
}
