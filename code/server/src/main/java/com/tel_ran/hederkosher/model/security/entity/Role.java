package com.tel_ran.hederkosher.model.security.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Igor on 07.08.2016.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "role_authority",
               joinColumns = {
                    @JoinColumn(name = "role_id", nullable = false, updatable = false)
               },
               inverseJoinColumns = {
                   @JoinColumn(name = "auth_id", nullable = false, updatable = false)
               }
    )
    private Set<Authority> authorities;

    public Role(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        authorities = new HashSet<>();
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

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void addAuthority(Authority authority) {
        authorities.add(authority);
    }

}
