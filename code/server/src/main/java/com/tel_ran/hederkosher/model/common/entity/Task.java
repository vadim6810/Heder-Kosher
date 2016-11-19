package com.tel_ran.hederkosher.model.common.entity;

import com.tel_ran.hederkosher.annotations.Markable;
import com.tel_ran.hederkosher.model.security.entity.User;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNER_ID", foreignKey = @ForeignKey(name = "FK_TASK$OWNER_ID"))
    private User creator;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATE", length = 50, nullable = false)
    private TaskState state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROGRAM_ID", foreignKey = @ForeignKey(name = "FK_TASK$PROGRAM_ID"))
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
