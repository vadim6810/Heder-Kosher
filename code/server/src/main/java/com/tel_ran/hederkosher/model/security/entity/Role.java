package com.tel_ran.hederkosher.model.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 07.08.2016.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "role_authority",
               joinColumns = {
                    @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false)
               },
               inverseJoinColumns = {
                   @JoinColumn(name = "AUTH_ID", nullable = false, updatable = false)
               }
    )
    private List<Authority> authorities;

    public Role(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        authorities = new ArrayList<>();
    }

    public Role() {
        this(0, "", "");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void addAuthority(Authority authority) {
        authorities.add(authority);
    }

}
