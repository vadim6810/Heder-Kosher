/**
 * Created by Ruslan on 06.08.2016.
 */

package com.tel_ran.hederkosher.model;
import com.tel_ran.hederkosher.annotations.Markable;
import com.tel_ran.hederkosher.model.security.User;

import java.util.Date;

@Markable
public class Person {
    private int idPerson;
    private String passportNo;
    private String firstname;
    private String secondname;
    private String lastname;
    private Date birthday;
    private User user;

    public Person(int idPerson, String passportNo, String firstname, String secondname, String lastname, Date birthday, User user) {
        this.idPerson = idPerson;
        this.passportNo = passportNo;
        this.firstname = firstname;
        this.secondname = secondname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.user = user;
    }

    public Person() {
        this(0, "", "", "", "", new Date(), null);
    }

    public int getIdPerson() {
        return this.idPerson;
    }

    public String getPassportNo() {
        return this.passportNo;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return this.lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondName() {
        return this.secondname;
    }

    public void setSecondName(String secondname) {
        this.secondname = secondname;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}