package com.tel_ran.hederkosher.model;

import com.tel_ran.hederkosher.annotations.Markable;

import javax.persistence.*;

/**
 * Created by Egor on 05.08.2016.
 * Entity class for excercise
 */

@Markable
@Entity
@Table(name = "TASK")
public class Task {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "IS_TEMPLATE")
    private boolean isTemplate;

    @Column(name = "AMOUNT_ITERATIONS")
    private int amountIterations;

    @Column(name = "AMOUNT_TRIES")
    private int amountTries;

    @Column(name = "WEIGHT")
    private int weight;

    @Column(name = "TIME")
    private int time;

    @Column(name = "OWNER_ID")
    @ManyToOne
    private Person owner;

    @Column(name = "STATE_ID")
    @ManyToOne
    private State state;

    public Task(int id, String name, String description, boolean isTemplate, int amountIterations, int amountTries, int weight, int time, Person owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isTemplate = isTemplate;
        this.amountIterations = amountIterations;
        this.amountTries = amountTries;
        this.weight = weight;
        this.time = time;
        this.owner = owner;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public int getAmountIterations() {
        return amountIterations;
    }

    public void setAmountIterations(int amountIterations) {
        this.amountIterations = amountIterations;
    }

    public int getAmountTries() {
        return amountTries;
    }

    public void setAmountTries(int amountTries) {
        this.amountTries = amountTries;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
