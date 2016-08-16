package com.tel_ran.hederkosher.model;

import javax.persistence.*;

/**
 * Created by Egor on 07.08.2016.
 * Entity class for states of Task and Program
 */
@Entity
@Table(name = "state")
public class State {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME", nullable = false)
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
