package com.tel_ran.hederkosher.service;

/**
 * Created by Igor on 05.08.2016.
 */
public class ServiceResultFactory {
    public static final ServiceResult OK;
    public static ServiceResult NOT_FOUND;
    public static ServiceResult ACCESS_DENIED;
    public static ServiceResult CREATING_ERROR;
    public static ServiceResult UPDATING_ERROR;
    public static ServiceResult DELETING_ERROR;
    public static ServiceResult ENTITY_CONFLICT;

    static {
        OK = new ServiceResult(0, "Ok");
        NOT_FOUND = new ServiceResult(-1, "Object not found");
        ACCESS_DENIED = new ServiceResult(-2, "Access denied");
        CREATING_ERROR = new ServiceResult(-3, "Object was not created!");
        UPDATING_ERROR = new ServiceResult(-4, "Object was not updated!");
        DELETING_ERROR = new ServiceResult(-5, "Object was not deleted!");
        ENTITY_CONFLICT = new ServiceResult(-6, "Object already exist");
    }
}


