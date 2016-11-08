package com.tel_ran.hederkosher.model.common.entity;

import com.tel_ran.hederkosher.annotations.Markable;

import javax.persistence.*;
import java.io.Serializable;

@Markable
@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "IS_TEMPLATE", nullable = false)
    private boolean isTemplate;

    @Column(name = "N_ITERATIONS", nullable = false)
    private Integer nIterations;

    @Column(name = "N_TRIES", nullable = false)
    private Integer nTries;

    @Column(name = "WEIGHT")
    private Integer weight;

    @Column(name = "TIME")
    private Integer time;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID", foreignKey = @ForeignKey(name = "FK_TASK$OWNER_ID"))
    private Person owner;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATE", length = 100)
    private State state;

    public Task() {}

    public Task(String name, String description, boolean isTemplate, int nIterations, int nTries, int weight, int time, Person owner, State state) {
        this.name = name;
        this.description = description;
        this.isTemplate = isTemplate;
        this.nIterations = nIterations;
        this.nTries = nTries;
        this.weight = weight;
        this.time = time;
        this.owner = owner;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Integer getnIterations() {
        return nIterations;
    }

    public void setnIterations(Integer nIterations) {
        this.nIterations = nIterations;
    }

    public Integer getnTries() {
        return nTries;
    }

    public void setnTries(Integer nTries) {
        this.nTries = nTries;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
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
