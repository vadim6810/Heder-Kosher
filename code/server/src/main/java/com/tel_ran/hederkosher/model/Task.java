package com.tel_ran.hederkosher.model;

/**
 * Created by Egor on 05.08.2016.
 * Entity class for excercise
 */
public class Task {
    private int id;
    private String name;
    private String description;
    private boolean isTemplate;
    private int amountIterations;
    private int amountTries;
    private int weight;
    private int time;
    private Program program;
    private Person owner;
    private State state;

    public Task(int id, String name, String description, boolean isTemplate, int amountIterations, int amountTries, int weight, int time, Program program, Person owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isTemplate = isTemplate;
        this.amountIterations = amountIterations;
        this.amountTries = amountTries;
        this.weight = weight;
        this.time = time;
        this.program = program;
        this.owner = owner;
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

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
