/**
 * Created by Ruslan on 06.08.2016.
 */

package com.tel_ran.hederkosher.model;
import java.util.Date;

public class Person implements Markable  {
    private int idPerson;
    private String passportNo;
    private String firstname;
    private String secondname;
    private String lastname;
    private Date birthday;

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

}