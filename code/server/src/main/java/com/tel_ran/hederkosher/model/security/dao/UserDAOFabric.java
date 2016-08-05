package com.tel_ran.hederkosher.model.security.dao;

/**
 * Created by Igor on 05.08.2016.
 */
public class UserDAOFabric {
    private static UserDAOFabric instance = new UserDAOFabric();

    private UserDAOFabric() {}

    public static UserDAO getUserDAO(String type) {
        if ("test".equalsIgnoreCase(type)) {
            return new UserDAOImplTest();
        }
        return null;
    }
}
