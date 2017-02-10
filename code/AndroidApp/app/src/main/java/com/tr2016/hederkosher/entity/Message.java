/**
 * Created by Ruslan on 17.11.2016.
 */

package com.tr2016.hederkosher.entity;

import java.util.Date;
import java.util.Set;


public class Message {

    private long id;

    private Date date;

    private String text;

    private MessageState state;

    private MessageType type;

    private Set<User> usersTo;

    private User userFrom;

    private Program program;

    private Task task;

    public Message(Date date, String text, MessageState state, MessageType type, User userFrom, Program program, Task task) {
        this.date = date;
        this.text = text;
        this.state = state;
        this.type = type;
        this.userFrom = userFrom;
        this.program = program;
        this.task = task;
    }

    public Message(){    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageState getState() {
        return state;
    }

    public void setState(MessageState state) {
        this.state = state;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Set<User> getUsersTo() {
        return usersTo;
    }

    public void setUsersTo(Set<User> usersTo) {
        this.usersTo = usersTo;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (date != null ? !date.equals(message.date) : message.date != null) return false;
        if (state != message.state) return false;
        if (type != message.type) return false;
        if (userFrom != null ? !userFrom.equals(message.userFrom) : message.userFrom != null) return false;
        if (program != null ? !program.equals(message.program) : message.program != null) return false;
        return task != null ? task.equals(message.task) : message.task == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (userFrom != null ? userFrom.hashCode() : 0);
        result = 31 * result + (program != null ? program.hashCode() : 0);
        result = 31 * result + (task != null ? task.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", state=" + state +
                ", type=" + type +
                ", usersTo=" + usersTo +
                ", userFrom=" + userFrom +
                ", program=" + program +
                ", task=" + task +
                '}';
    }
}
