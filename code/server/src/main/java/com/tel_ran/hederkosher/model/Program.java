package com.tel_ran.hederkosher.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Egor on 07.08.2016.
 * Entity class for programm of excercises
 */
public class Program implements Markable {
    private int id;
    private String name;
    private Date dCreate;
    private Date dClose;
    private boolean isTemplate;
    private Person owner;
    private Person producer;
    private Person client;
    private Room room;
    private State state;

    private List<Task> tasks;

    public Program(int id, String name, Date dCreate, Date dClose, boolean isTemplate, Person owner, Person producer, Person client, Room room, State state) {
        this.id = id;
        this.name = name;
        this.dCreate = dCreate;
        this.dClose = dClose;
        this.isTemplate = isTemplate;
        this.owner = owner;
        this.producer = producer;
        this.client = client;
        this.room = room;
        this.state = state;
    }

    public Program() {
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

    public Date getdCreate() {
        return dCreate;
    }

    public void setdCreate(Date dCreate) {
        this.dCreate = dCreate;
    }

    public Date getdClose() {
        return dClose;
    }

    public void setdClose(Date dClose) {
        this.dClose = dClose;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Person getProducer() {
        return producer;
    }

    public void setProducer(Person producer) {
        this.producer = producer;
    }

    public Person getClient() {
        return client;
    }

    public void setClient(Person client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Task> getTasks() {
        if (tasks == null){
            tasks = getTasksList();
        }
        return tasks;
    }

    private List<Task> getTasksList() {
        //TODO DAL
        return new ArrayList<>();
    }

//    public void setTasks(List<Task> tasks) {
//        this.tasks = tasks;
//    }
}
