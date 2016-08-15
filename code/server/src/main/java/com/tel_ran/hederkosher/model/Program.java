package com.tel_ran.hederkosher.model;

import com.tel_ran.hederkosher.annotations.Markable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Egor on 07.08.2016.
 * Entity class for programm of excercises
 */

@Markable
@Entity
@Table(name = "program")
public class Program {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DATE_CREATE")
    private Date dCreate;

    @Column(name = "DATE_CLOSE")
    private Date dClose;

    @Column(name = "IS_TEMPLATE")
    private boolean isTemplate;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    private Person owner;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    private Person producer;

    @ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    private Person client;

    @ManyToOne(targetEntity = Room.class, fetch = FetchType.LAZY)
    private Room room;

    @ManyToOne(targetEntity = State.class)
    private State state;

    @OneToMany(targetEntity = Task.class, mappedBy = "owner")
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

}
