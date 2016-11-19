/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.common.entity;

import com.tel_ran.hederkosher.annotations.Markable;
import com.tel_ran.hederkosher.model.security.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


//@Markable
@Entity
@Table(name = "person")
public class Person  {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "PASSPORT_NO", nullable = false) //, length = 50
    private String passportNo;

    @Column(name = "FIRST_NAME", nullable = false)
    private String fistName;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTHDAY", nullable = false)
    private Date birthday;

//    @Column(name = "AGE", nullable = false)
//    private boolean age ;

    @Column(name = "SEX", nullable = false)
    private boolean sex ;

    @Column(name = "HEIGHT", nullable = false)
    private int height ;

    @Column(name = "WEIGHT", nullable = false)
    private int weight ;

    @OneToOne(fetch = FetchType.LAZY)
    private Gym gym ;



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private Set<Contact> contacts;

//    @OneToOne(fetch = FetchType.LAZY)
//    private User user;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Address> address;


    public Person(String passportNo, String firstName, String secondName, String lastName
            , Date birthday,  Set<Address> address) { //User user,
        //this.id = id;
        this.passportNo = passportNo;
        this.fistName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
//        this.user = user;
        this.address = address;
    }

    public Person(){    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
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
        return lastName;
    }
    public void setLastname(String lastname) {
        this.lastName = lastname;
    }

    public String getSecondname() {
        return secondName;
    }
    public void setSecondname(String secondname) {
        this.secondName = secondname;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
    public Set<Address> getAddress() {
        return address;
    }

//    public User getUser() {
//        return user;
//    }
//    public void setUser(User user) {
//        this.user = user;
//    }


    public Set<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person that = (Person) o;

        if (id != that.id) return false;
        if (passportNo != null ? !passportNo.equals(that.passportNo) : that.passportNo != null) return false;
        if (fistName != null ? !fistName.equals(that.fistName) : that.fistName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (secondName != null ? !secondName.equals(that.secondName) : that.secondName != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int)id;
        result = 31 * result + (passportNo != null ? passportNo.hashCode() : 0);
        result = 31 * result + (fistName != null ? fistName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
       return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", passportNo='" + passportNo + '\'' +
                ", fistName='" + fistName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
//                ", user=" + user +
                '}';
    }

}
