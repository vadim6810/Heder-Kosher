package com.tel_ran.hederkosher.model.security;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Igor on 05.08.2016.
 */
public class User {
    private long id;
    private String email;
    private String password;
    private Date regDate;

    public User() {
        this(0, "", "", new Date());
    }

    public User(long id, String email, String password, Date regDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
