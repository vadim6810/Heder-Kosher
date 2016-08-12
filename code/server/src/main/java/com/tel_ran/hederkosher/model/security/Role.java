package com.tel_ran.hederkosher.model.security;

import com.tel_ran.hederkosher.model.Room;

import java.util.*;

/**
 * Created by Igor on 07.08.2016.
 */
public class Role {
    private long id;
    private String name;
    private String description;
    private HashSet<Action> actions;

    public Role(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        actions = new HashSet<>();
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

    public HashSet<Action> getActions() {
        return actions;
    }

    public void addAction(Action action) {
        actions.add(action);
    }

}
