package com.tel_ran.hederkosher.model;

/**
 * Created by Egor on 07.08.2016.
 * Entity class for states of Task and Program
 */
public class State {
    private String name;

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
