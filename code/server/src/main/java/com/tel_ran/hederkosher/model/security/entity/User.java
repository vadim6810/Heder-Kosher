package com.tel_ran.hederkosher.model.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tel_ran.hederkosher.model.common.entity.Room;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Igor on 05.08.2016.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NaturalId
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @JsonIgnore
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @JsonIgnore
    @Column(name = "REG_DATE", nullable = false)
    private Date regDate;

    //TODO Return authorities
    //@JsonIgnore
    /*@OneToMany(targetEntity = UserGrantedAuthority.class)
    @Lazy*/
    //private Set<UserGrantedAuthority> authorities;
    /*
    @OneToMany(targetEntity = Task.class, mappedBy = "owner")
    private List<Task> tasks;
     */

    public User() {
        this(0, "", "", new Date());
    }

    public User(long id, String email, String password, Date regDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.regDate = regDate;
        //authorities = new HashSet<>();
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

//    public Set<UserGrantedAuthority> getAuthorities() {
//        return null;
//        //return this.authorities;
//    }

    public void setAuthorities( Set<UserGrantedAuthority> authorities) {
        //this.authorities = authorities;
    }

    public Role getRole(Room room) {
        /*for (UserGrantedAuthority ga : this.authorities) {
            if (ga.getRoom().equals(room))
                return ga.getRole();
        }*/
        return null;
    }

    public Role setRole(Room room, Role role) {
        /*for (UserGrantedAuthority ga : this.authorities) {
            if (ga.getRoom().equals(room)) {
                Role oldRole = ga.getRole();
                ga.setRole(role);
                return oldRole;
            }
        }
        UserGrantedAuthority uga = new UserGrantedAuthority(new Date(), role, room);
        this.authorities.add(uga);*/
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!email.equals(user.email)) return false;
        return regDate.equals(user.regDate);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + email.hashCode();
        result = 31 * result + regDate.hashCode();
        return result;
    }
}
