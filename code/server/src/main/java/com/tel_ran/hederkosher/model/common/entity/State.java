package com.tel_ran.hederkosher.model.common.entity;

public enum State {
    NEW,
    READY,
}

//import org.hibernate.annotations.NaturalId;
//
//import javax.persistence.*;
//
///**
// * Created by Egor on 07.08.2016.
// * Entity class for states of Task and Program
// */
//@Entity
//@Table(name = "state")
//public class State {
//
//    @Id
//    @Column(name = "ID", nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @NaturalId
//    @Column(name = "CODE", nullable = false)
//    private String code;
//
//    @Column(name = "NAME", nullable = false)
//    private String name;
//
//    public State() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//}
