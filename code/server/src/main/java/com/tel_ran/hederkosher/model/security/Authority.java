package com.tel_ran.hederkosher.model.security;

/**
 * Created by Igor on 07.08.2016.
 */
public class Authority {
    private long id;
    private String name;
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