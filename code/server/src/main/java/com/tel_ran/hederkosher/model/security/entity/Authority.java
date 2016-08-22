package com.tel_ran.hederkosher.model.security.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by Igor on 07.08.2016.
 */
@Entity
@Table(name = "authority")
public class Authority {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", insertable = false)
    @NaturalId
    private String name;

    @Column(name = "description")
    private String description;

    public Authority(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Authority() {
        this(0, "", "");
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
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
}
