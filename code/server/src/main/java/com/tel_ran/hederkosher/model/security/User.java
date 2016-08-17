package com.tel_ran.hederkosher.model.security;

import com.tel_ran.hederkosher.model.Room;

import java.util.*;

/**
 * Created by Igor on 05.08.2016.
 */
public class User {
    private long id;
    private String email;
    private String password;
    private Date regDate;
    //private Map<Room, Role> roles;
    private Set<UserGrantedAuthority> authorities;

    public User() {
        this(0, "", "", new Date());
    }

    public User(long id, String email, String password, Date regDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
        authorities = new HashSet<>();
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

    public Set<UserGrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities( Set<UserGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public Role getRole(Room room) {
        for (UserGrantedAuthority ga : this.authorities) {
            if (ga.getRoom().equals(room))
                return ga.getRole();
        }
        return null;
    }

    public Role setRole(Room room, Role role) {
        for (UserGrantedAuthority ga : this.authorities) {
            if (ga.getRoom().equals(room)) {
                Role oldRole = ga.getRole();
                ga.setRole(role);
                return oldRole;
            }
        }
        UserGrantedAuthority uga = new UserGrantedAuthority(new Date(), role, room);
        this.authorities.add(uga);
        return null;
    }
}
