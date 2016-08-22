package com.tel_ran.hederkosher.model.common.entity;

import com.tel_ran.hederkosher.annotations.Markable;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Egor on 05.08.2016.
 * Entity class for excercise
 */

@Markable
@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "IS_TEMPLATE", nullable = false)
    private boolean isTemplate;

    @Column(name = "AMOUNT_ITERATIONS", nullable = false)
    private int amountIterations;

    @Column(name = "AMOUNT_TRIES", nullable = false)
    private int amountTries;

    @Column(name = "WEIGHT")
    private int weight;

    @Column(name = "TIME")
    private int time;

    @ManyToOne//(targetEntity = Person.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID", foreignKey = @ForeignKey(name = "FK_TASK$OWNER_ID"))
    private Person owner;

    //@ManyToOne(targetEntity = State.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "STATE", length = 100)
    private State state;

    public Task() {}

    public Task(String name, String description, boolean isTemplate, int amountIterations, int amountTries, int weight, int time, Person owner, State state) {
        this.name = name;
        this.description = description;
        this.isTemplate = isTemplate;
        this.amountIterations = amountIterations;
        this.amountTries = amountTries;
        this.weight = weight;
        this.time = time;
        this.owner = owner;
        this.state = state;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
