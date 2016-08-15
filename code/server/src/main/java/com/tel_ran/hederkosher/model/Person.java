/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model;

import com.tel_ran.hederkosher.annotations.Markable;
import com.tel_ran.hederkosher.model.security.User;

import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;


@Markable
@Entity
@Table(name = "person", schema = "heder-kosher", catalog = "")
public class Person {
    private int idPerson;
    private String passportNo;
    private String fistName;
    private String lastname;
    private String secondname;
    private Date birthday;
    private User user;

    public Person(int idPerson, String passportNo, String firstname, String secondname, String lastname, Date birthday, User user) {
        this.idPerson = idPerson;
        this.passportNo = passportNo;
        this.fistName = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.user = user;
    }

    public Person() {
        this(0, "", "", "", "", new Date(), null);
    }

    @Id
    @Column(name = "idPerson")
    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    @Basic
    @Column(name = "passportNo")
    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    @Basic
    @Column(name = "fistName")
    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "secondname")
    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Basic
    @Column(name = "user")
//    public User getUser() {
//        return user;
//    }
//    public void setUser(User user) {
//        this.user = user;
//    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        if (idPerson != that.idPerson) return false;
        if (passportNo != null ? !passportNo.equals(that.passportNo) : that.passportNo != null) return false;
        if (fistName != null ? !fistName.equals(that.fistName) : that.fistName != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (secondname != null ? !secondname.equals(that.secondname) : that.secondname != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPerson;
        result = 31 * result + (passportNo != null ? passportNo.hashCode() : 0);
        result = 31 * result + (fistName != null ? fistName.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
