package com.tel_ran.hederkosher.rest;

/**
 * Created by Igor on 05.08.2016.
 */
public class ServiceResultFactory {
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
}


