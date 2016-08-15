package com.tel_ran.hederkosher.model.security;

import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by Igor on 14.08.2016.
 */
public class Token {
    private BigInteger id;
    private String token;
    private User user;
    private Date tsCreate;

    public Date getTsCreate() {
        return tsCreate;
    }

    public void setTsCreate(Date tsCreate) {
        this.tsCreate = tsCreate;
    }

    public Token() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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
