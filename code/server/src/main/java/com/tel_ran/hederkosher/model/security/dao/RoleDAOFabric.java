package com.tel_ran.hederkosher.model.security.dao;

/**
 * Created by Igor on 07.08.2016.
 */
public class RoleDAOFabric {
    private RoleDAOFabric() {    }

    public static RoleDAO getRoleDAO(String type) {
        if ("test".equals(type)) {
            return new RoleDAOImplTest();
        }
        return null;
    }
}
