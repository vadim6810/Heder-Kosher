package com.tr2016.hederkosher.entity;

/**
 * Created by Ruslan on 17/11/16.
 */

public class Gym {

    private long id;

    private String name;

    // @OneToOne(fetch = FetchType.LAZY)
    private Address address;

    public Gym() {
    }

    public Gym(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Gym{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
