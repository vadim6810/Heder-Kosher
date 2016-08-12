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

        res.add(new Action(9, "LIST PERSON", ""));
        res.add(new Action(10, "CREATE PERSON", ""));
        res.add(new Action(11, "UPDATE PERSON", ""));
        res.add(new Action(12, "DELETE PERSON", ""));

        res.add(new Action(13, "LIST ROOM", ""));
        res.add(new Action(14, "CREATE ROOM", ""));
        res.add(new Action(15, "UPDATE ROOM", ""));
        res.add(new Action(16, "DELETE ROOM", ""));

        res.add(new Action(17, "LIST PROGRAM", ""));
        res.add(new Action(18, "CREATE PROGRAM", ""));
        res.add(new Action(19, "UPDATE PROGRAM", ""));
        res.add(new Action(20, "DELETE PROGRAM", ""));

        res.add(new Action(21, "LIST STATE", ""));
        res.add(new Action(22, "CREATE STATE", ""));
        res.add(new Action(23, "UPDATE STATE", ""));
        res.add(new Action(24, "DELETE STATE", ""));

        res.add(new Action(25, "LIST TASK", ""));
        res.add(new Action(26, "CREATE TASK", ""));
        res.add(new Action(27, "UPDATE TASK", ""));
        res.add(new Action(28, "DELETE TASK", ""));

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

    @Override
    public List<Action> getAllActions() {
        return actions;
    }
}
