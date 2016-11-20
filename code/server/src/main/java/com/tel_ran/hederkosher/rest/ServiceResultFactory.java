package com.tel_ran.hederkosher.rest;

/**
 * Created by Igor on 05.08.2016.
 */
public final class ServiceResultFactory {

    public enum Type {

        OK(0, "Ok"),
        NOT_FOUND(-1, "Object not found"),
        ACCESS_DENIED(-2, "Access denied"),
        CREATING_ERROR(-3, "Object was not created!"),
        UPDATING_ERROR(-4, "Object was not updated!"),
        DELETING_ERROR(-5, "Object was not deleted!"),
        ENTITY_CONFLICT(-6, "Object already exist"),
        CREDENTIALS_NOT_FOUND(-7, "Username or password are invalid."),
        INVALID_REQUEST(-8, "Request is invalid"),
        ;

        private int code;
        private String message;

        Type(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    /* VVV !!! THIS PART IS DEPRECATED !!! VVV */
    public static ServiceResult OK;
    public static ServiceResult INVALID_REQUEST;
    public static ServiceResult NOT_FOUND;
    public static ServiceResult ACCESS_DENIED;
    public static ServiceResult CREATING_ERROR;
    public static ServiceResult UPDATING_ERROR;
    public static ServiceResult DELETING_ERROR;
    public static ServiceResult ENTITY_CONFLICT;
    public static ServiceResult CREDENTIALS_NOT_FOUND;

    static {
        OK = new ServiceResult(0, "Ok");
        NOT_FOUND = new ServiceResult(-1, "Object not found");
        ACCESS_DENIED = new ServiceResult(-2, "Access denied");
        CREATING_ERROR = new ServiceResult(-3, "Object was not created!");
        UPDATING_ERROR = new ServiceResult(-4, "Object was not updated!");
        DELETING_ERROR = new ServiceResult(-5, "Object was not deleted!");
        ENTITY_CONFLICT = new ServiceResult(-6, "Object already exist");
        CREDENTIALS_NOT_FOUND = new ServiceResult(-7, "Username or password are invalid.");
        INVALID_REQUEST = new ServiceResult(-8, "Request is invalid");
    }
    /* ^^^ !!! THIS PART IS DEPRECATED !!! ^^^ */

    private ServiceResultFactory() {
    }

    public static ServiceResult getResultObject(Type type){
        return new ServiceResult(type.code, type.message);
    }
}


