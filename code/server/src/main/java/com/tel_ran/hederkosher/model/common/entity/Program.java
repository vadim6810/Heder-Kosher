package com.tel_ran.hederkosher.model.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.tel_ran.hederkosher.annotations.Markable;
import com.tel_ran.hederkosher.model.security.entity.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @Column(name = "DATE_CREATE", nullable = false)
    private LocalDateTime dateCreate;

    @Column(name = "DATE_CLOSE")
    private LocalDateTime dateClose;

    @Column(name = "IS_TEMPLATE", nullable = false)
    private boolean isTemplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR_ID", foreignKey = @ForeignKey(name = "FK_PROGRAM$CREATOR_ID"))
    private User creator;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "program_clients")
    private List<User> clients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROOM_ID", foreignKey = @ForeignKey(name = "FK_PROGRAM$ROOM_ID"))
    private Room room;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATE", length = 50, nullable = false)
    private ProgramState state;

    @OneToMany(mappedBy = "program", fetch = FetchType.LAZY)
    private List<Task> tasks;

    public Program() {
    }

    public Program(String name, String description, LocalDateTime dateCreate, LocalDateTime dateClose, boolean isTemplate, User creator, Room room) {
        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate;
        this.dateClose = dateClose;
        this.isTemplate = isTemplate;
        this.creator = creator;
        this.room = room;

        //Default programState
        this.state = ProgramState.DRAFT;
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

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateClose() {
        return dateClose;
    }

    public void setDateClose(LocalDateTime dateClose) {
        this.dateClose = dateClose;
    }

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<User> getClients() {
        return clients;
    }

    public void setClients(List<User> clients) {
        this.clients = clients;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public ProgramState getState() {
        return state;
    }

    public void setState(ProgramState state) {
        this.state = state;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
