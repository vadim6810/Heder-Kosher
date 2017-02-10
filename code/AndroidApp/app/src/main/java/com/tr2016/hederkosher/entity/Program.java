package com.tr2016.hederkosher.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.tel_ran.hederkosher.annotations.Markable;
import com.tel_ran.hederkosher.model.security.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public class Program {

    private long id;

    private String name;

    private String description;

    private LocalDateTime dateCreate;

    private LocalDateTime dateClose;

    private boolean template;

    private User creator;

    private List<User> clients;

    private Room room;

    private ProgramState state;

    private List<Task> tasks;

    public Program() {
    }

    public Program(String name, String description, LocalDateTime dateCreate, LocalDateTime dateClose, boolean template, User creator, Room room) {
        this.name = name;
        this.description = description;
        this.dateCreate = dateCreate;
        this.dateClose = dateClose;
        this.template = template;
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
        return template;
    }

    public void setTemplate(boolean template) {
        this.template = template;
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
