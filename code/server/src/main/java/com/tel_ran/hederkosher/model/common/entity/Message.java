/**
 * Created by Ruslan on 17.11.2016.
 */

package com.tel_ran.hederkosher.model.common.entity;

import com.tel_ran.hederkosher.model.security.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "message")
public class Message {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "DATE", nullable = false)
    private Date date;

    @Column(name = "TEXT", nullable = false, columnDefinition = "TEXT")
    private String text;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATE", length = 100)
    private MessageState state;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", length = 100)
    private MessageType type;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<User> usersTo;

    @OneToOne(fetch = FetchType.LAZY)
    private User userFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    private Program program;

    @ManyToOne(fetch = FetchType.LAZY)
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
