package com.tel_ran.hederkosher.exception;

/**
 * Created by Ruslan on 09/11/16.
 */
public class TemplateNotFoundException extends Exception {
//    long id;
//    String objectName;

//    public long getId() {
//        return id;
//    }
//    public String getName() {
//        return objectName;
//    }

    public TemplateNotFoundException(String objectName, long Id) {
        super(objectName+" not found " + Id);
//        this.id=id;
    }

}
