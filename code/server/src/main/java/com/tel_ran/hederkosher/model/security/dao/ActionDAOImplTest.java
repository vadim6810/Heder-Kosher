package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.Action;

import java.util.*;

/**
 * Created by Igor on 07.08.2016.
 */
public class ActionDAOImplTest implements ActionDAO {
    private static List<Action> actions;
    static {
        actions = fillActions();
    }

    private static List<Action> fillActions() {
        List<Action> res = new ArrayList<>();
        res.add(new Action(1, "LIST ALL USERS", ""));
        res.add(new Action(2, "CREATE USER", ""));
        res.add(new Action(3, "UPDATE USER", ""));
        res.add(new Action(4, "DELETE USER", ""));

        res.add(new Action(5, "LIST ROLES", ""));
        res.add(new Action(6, "CREATE ROLE", ""));
        res.add(new Action(7, "UPDATE ROLE", ""));
        res.add(new Action(8, "DELETE ROLE", ""));
        return res;
    }

    @Override
    public Action findById(long id) {
        for (Iterator<Action> it = actions.iterator(); it.hasNext(); ) {
            Action action = it.next();
            if (action.getId() == id) {
                return action;
            }
        }
        return null;
    }
}
