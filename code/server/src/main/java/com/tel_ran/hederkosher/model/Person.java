/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model;

import com.tel_ran.hederkosher.annotations.Markable;
import com.tel_ran.hederkosher.model.security.User;

import org.hibernate.annotations.Type;
import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;


@Markable
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "idPerson")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerson;

    @Basic
    @Column(name = "passportNo")
    private String passportNo;

    @Basic
    @Column(name = "fistName")
    private String fistName;

    @Basic
    @Column(name = "lastname")
    private String lastname;

    @Basic
    @Column(name = "secondname")
    private String secondname;

    @Basic
    @Column(name = "birthday")
    private Date birthday;

    @Basic
    @Column(name = "user")
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

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }


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
