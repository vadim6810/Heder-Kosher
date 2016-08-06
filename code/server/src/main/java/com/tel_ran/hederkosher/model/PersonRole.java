/**
 * Created by Ruslan on 06.08.2016.
 */

package com.tel_ran.hederkosher.model;

public class PersonRole {
    private int idRole;

    private String name;

    public PersonRole() {
    }
    public PersonRole(String name) {
        this.name = name;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

