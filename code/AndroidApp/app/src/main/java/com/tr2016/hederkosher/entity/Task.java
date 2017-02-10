package com.tr2016.hederkosher.entity;

import java.io.Serializable;

public class Task implements Serializable {

    private Long id;

    private String name;

    private String description;

    private boolean isTemplate;

    private Integer nIterations;

    private Integer nTries;

    private Integer weight;

    private Integer time;

    private User creator;

    private TaskState state;

    private Program program;

    public Task() {

    }

    public Task(String name, String description, boolean isTemplate, Integer nIterations, Integer nTries, Integer weight, Integer time, User creator, Program program) {
        this.name = name;
        this.description = description;
        this.isTemplate = isTemplate;
        this.nIterations = nIterations;
        this.nTries = nTries;
        this.weight = weight;
        this.time = time;
        this.creator = creator;
        this.program = program;

        //Default state
        this.state = TaskState.DRAFT;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
