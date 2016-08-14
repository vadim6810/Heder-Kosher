package com.tel_ran.hederkosher.model;

/**
 * Created by Egor on 07.08.2016.
 * Entity class for states of Task and Program
 */
public class State {
    private int id;
    private String name;

    public State(String name) {
        this.name = name;
    }

    public State(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public State() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
