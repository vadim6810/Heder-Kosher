package com.tel_ran.hederkosher.model.security.dao;

/**
 * Created by Igor on 07.08.2016.
 */
public class ActionDAOFabric {
    private ActionDAOFabric() {
    }

    public static ActionDAO getActionDao(String type) {
        if ("test".equals(type)) {
            return new ActionDAOImplTest();
        }
        return null;
    }
}
