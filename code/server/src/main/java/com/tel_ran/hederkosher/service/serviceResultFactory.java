package com.tel_ran.hederkosher.service;

/**
 * Created by Igor on 05.08.2016.
 */
public class serviceResultFactory {
    public static final serviceResult OK;
    public static serviceResult USER_NOT_FOUND;
    public static serviceResult ACCESS_DENIED;

    static {
        OK = new serviceResult(0, "Ok");
        USER_NOT_FOUND = new serviceResult(-1, "User not found");
        ACCESS_DENIED = new serviceResult(-2, "Access denied");
    }
}
