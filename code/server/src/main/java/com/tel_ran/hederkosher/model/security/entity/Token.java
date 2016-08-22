package com.tel_ran.hederkosher.model.security.entity;

import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Igor on 14.08.2016.
 */
@Entity
@Table(name = "token")
public class Token {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "token", nullable = false)
    @NaturalId
    private String token;

    @Column(name = "tsCreate", nullable = false)
    private Date tsCreate;

    @Lazy
    @ManyToOne()
    private User user;

    public Date getTsCreate() {
        return tsCreate;
    }

    public void setTsCreate(Date tsCreate) {
        this.tsCreate = tsCreate;
    }

    public Token() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
