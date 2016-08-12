/**
 * Created by Ruslan on 06.08.2016.
 */

package com.tel_ran.hederkosher.model;
import java.util.Date;

public class Room   {
    private int idRoom;
    private String name;
    private String address;
    private Date dCreate;
    private Date dClose;

    public int getIdRoom() {
        return this.idRoom;
    }

    public Room(String name, String address, Date dCreate) {
        this.name = name;
        this.address = address;
        this.dCreate = dCreate;
    }
    public Room(String name, String address) {
        this(name,address,new Date());
    }
    public Room(String name) {
        this(name,"",new Date());
    }

    public Room() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDCreate() {
        return this.dCreate;
    }

    public void setDCreate(Date dCreate) {
        this.dCreate = dCreate;
    }

    public Date getDClose() {
        return this.dClose;
    }

    public void setDClose(Date dClose) {
        this.dClose = dClose;
    }

}