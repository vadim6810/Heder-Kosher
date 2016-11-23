package com.tel_ran.hederkosher.rest.api.entities;

import org.hibernate.validator.constraints.NotEmpty;

public class ProgramData {
    private long id;           //Optional: (required for update)

    @NotEmpty
    private String name;       //Required:
    private String description;//Optional:
    private String dateCreate; //Optional: "2011-02-28T23:59:00"
    private String dateClose;  //Optional: "2011-02-28T23:59:00"
    private boolean template;  //Optional: default false
    private long creatorId;    //Required: User Id
    private long roomId;       //Required: Room Id
    private String state;      //Optional: default DRAFT

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public String getDateClose() {
        return dateClose;
    }

    public boolean isTemplate() {
        return template;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public long getRoomId() {
        return roomId;
    }

    public String getState() {
        return state;
    }
}