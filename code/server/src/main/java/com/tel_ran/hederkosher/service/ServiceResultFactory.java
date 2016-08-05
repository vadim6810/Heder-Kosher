package com.tel_ran.hederkosher.service;

/**
 * Created by Igor on 05.08.2016.
 */
public class ServiceResultFactory {
    public static final ServiceResult OK;
    public static ServiceResult USER_NOT_FOUND;
    public static ServiceResult ACCESS_DENIED;
    public static ServiceResult CREATING_ERROR;
    public static ServiceResult UPDATING_ERROR;
    public static ServiceResult DELETING_ERROR;
    public static ServiceResult USER_CONFLICT;

    static {
        OK = new ServiceResult(0, "Ok");
        USER_NOT_FOUND = new ServiceResult(-1, "User not found");
        ACCESS_DENIED = new ServiceResult(-2, "Access denied");
        CREATING_ERROR = new ServiceResult(-3, "user was not created!");
        UPDATING_ERROR = new ServiceResult(-4, "user was not updated!");
        DELETING_ERROR = new ServiceResult(-5, "user was not deleted!");
        USER_CONFLICT = new ServiceResult(-6, "user already exist");
    }
}


