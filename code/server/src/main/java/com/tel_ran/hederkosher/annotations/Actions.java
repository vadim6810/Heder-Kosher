package com.tel_ran.hederkosher.annotations;

/**
 * Created by Igor on 12.08.2016.
 */
public enum Actions {
    LIST_ALL_USERS (1, "LIST ALL USERS"),
    CREATE_USER (2, "CREATE USER"),
    UPDATE_USER (3, "UPDATE USER"),
    DELETE_USER (4, "DELETE USER"),
    LIST_ROLES (5, "LIST ROLES"),
    CREATE_ROLE (6, "CREATE ROLE"),
    UPDATE_ROLE (7, "UPDATE ROLE"),
    DELETE_ROLE (8, "DELETE ROLE"),
    LIST_PERSON (9, "LIST PERSON"),
    CREATE_PERSON (10, "CREATE PERSON"),
    UPDATE_PERSON (11, "UPDATE PERSON"),
    DELETE_PERSON (12, "DELETE PERSON"),
    LIST_ROOM (13, "LIST ROOM"),
    CREATE_ROOM (14, "CREATE ROOM"),
    UPDATE_ROOM (15, "UPDATE ROOM"),
    DELETE_ROOM (16, "DELETE ROOM"),
    LIST_PROGRAM (17, "LIST PROGRAM"),
    CREATE_PROGRAM (18, "CREATE PROGRAM"),
    UPDATE_PROGRAM (19, "UPDATE PROGRAM"),
    DELETE_PROGRAM (20, "DELETE PROGRAM"),
    LIST_STATE (21, "LIST STATE"),
    CREATE_STATE (22, "CREATE STATE"),
    UPDATE_STATE (23, "UPDATE STATE"),
    DELETE_STATE (24, "DELETE STATE"),
    LIST_TASK (25, "LIST TASK"),
    CREATE_TASK (26, "CREATE TASK"),
    UPDATE_TASK (27, "UPDATE TASK"),
    DELETE_TASK (28, "DELETE TASK");

    private final int id;
    private final String name;

    Actions(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
