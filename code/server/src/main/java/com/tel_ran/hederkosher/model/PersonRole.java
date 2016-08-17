/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model;

import com.tel_ran.hederkosher.annotations.Markable;

import javax.persistence.*;

//@Markable
@Entity
@Table(name = "personrole", schema = "heder-kosher", catalog = "")
public class PersonRole {

    @Id
    @Column(name = "idRole")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Basic
    @Column(name = "name")
    private String name;

    public PersonRole(String name) {
        this.name = name;
    }

    public PersonRole(){this("");
    }

    public int getIdRole() {
        return idRole;
    }
    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonRole that = (PersonRole) o;

        if (idRole != that.idRole) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }
    @Override
    public int hashCode() {
        int result = idRole;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
