package com.tel_ran.hederkosher.exception;

/**
 * Created by Ruslan on 09/11/16.
 */
public class PersonNotFoundException extends Exception {
    long id;
    String personName;

    public long getId() {
        return id;
    }
    public String getName() {
        return personName;
    }

    public PersonNotFoundException(long personId) {
        super("Person not found " + personId);
        id=personId;
    }

    public PersonNotFoundException(String personName) {
        super("Person not found" + personName);
        personName=personName;
    }
}
