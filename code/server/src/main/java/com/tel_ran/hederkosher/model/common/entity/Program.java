package com.tel_ran.hederkosher.model.common.entity;

import com.tel_ran.hederkosher.annotations.Markable;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by Egor on 07.08.2016.
 * Entity class for program of excercises
 */

@Markable
@Entity
@Table(name = "program")
public class Program {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DATE_CREATE", nullable = false)
    private LocalDateTime dCreate;

    @Column(name = "DATE_CLOSE")
    private LocalDateTime dClose;

    @Column(name = "IS_TEMPLATE", nullable = false)
    private boolean isTemplate;

    //@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "OWNER_ID", foreignKey = @ForeignKey(name = "FK_PROGRAM$OWNER_ID"))
    private Person owner;

    //@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "PRODUCER_ID", foreignKey = @ForeignKey(name = "FK_PROGRAM$PRODUCER_ID"))
    private Person producer;

    //@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", foreignKey = @ForeignKey(name = "FK_PROGRAM$CLIENT_ID"))
    private Person client;

    //@ManyToOne(targetEntity = Room.class, fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "ROOM_ID", foreignKey = @ForeignKey(name = "FK_PROGRAM$ROOM_ID"))
    private Room room;

    //@ManyToOne(targetEntity = State.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "STATE", length = 100)
    private State state;

    @OneToMany(targetEntity = Task.class, mappedBy = "owner")
    private List<Task> tasks;

    public Program() {
    }

    public Program(String name, LocalDateTime dCreate, LocalDateTime dClose, boolean isTemplate, Person owner, Person producer, Person client, Room room, State state) {
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

    public LocalDateTime getdCreate() {
        return dCreate;
    }

    public void setdCreate(LocalDateTime dCreate) {
        this.dCreate = dCreate;
    }

    public LocalDateTime getdClose() {
        return dClose;
    }

    public void setdClose(LocalDateTime dClose) {
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
