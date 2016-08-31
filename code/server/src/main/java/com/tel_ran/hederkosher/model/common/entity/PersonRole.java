/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "person_role") //, schema = "heder-kosher", catalog = ""
public class PersonRole {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;


    public PersonRole(String name) {
        this.name = name;
    }
    public PersonRole() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonRole that = (PersonRole) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
