package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.Room;
import com.tel_ran.hederkosher.model.security.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Igor on 07.08.2016.
 */
public class RoleDAOImplTest implements RoleDAO {
    private static final AtomicLong counter = new AtomicLong();
    private static List<Role> roles;
    private static ActionDAO actionDAO = ActionDAOFabric.getActionDao("test");

    static{
        roles = createTestRoles();
    }

    private static List<Role> createTestRoles() {
        List<Role> res = new ArrayList<>();

        Room room1 = new Room("Gym 1", "Address gym1", new Date());
        Room room2 = new Room("Gym 2", "Address gym2", new Date());

        res.add(new Role(0, "ADMIN", "Application Administrator", null));
        res.add(new Role(1, "MANAGER 1", "Manager of gym", room1));
        res.add(new Role(2, "TRAINER 1", "Trainer in gym", room1));
        res.add(new Role(3, "CLIENT 1", "Simple user", room1));

        res.add(new Role(4, "MANAGER 2", "Manager of gym", room2));
        res.add(new Role(5, "TRAINER 2", "Trainer in gym", room2));
        res.add(new Role(6, "CLIENT 2", "Simple user", room2));

        createAdminRole(res.get(0));

        createManagerRole(res.get(1));
        createManagerRole(res.get(4));

        createTrainerRole(res.get(2));
        createTrainerRole(res.get(5));

        createClientRole(res.get(3));
        createClientRole(res.get(6));
        return res;
    }

    private static void createClientRole(Role role) {
        Action action = actionDAO.findById(13);
        role.addAction(action);

        action = actionDAO.findById(17);
        role.addAction(action);

        action = actionDAO.findById(21);
        role.addAction(action);

        action = actionDAO.findById(25);
        role.addAction(action);

        action = actionDAO.findById(27);
        role.addAction(action);
    }

    private static void createTrainerRole(Role role) {
        createClientRole(role);

        Action action = actionDAO.findById(9);
        role.addAction(action);

        action = actionDAO.findById(18);
        role.addAction(action);

        action = actionDAO.findById(19);
        role.addAction(action);

        action = actionDAO.findById(20);
        role.addAction(action);

        action = actionDAO.findById(26);
        role.addAction(action);

        action = actionDAO.findById(27);
        role.addAction(action);

        action = actionDAO.findById(28);
        role.addAction(action);
    }

    private static void createManagerRole(Role role) {
        createTrainerRole(role);

        Action action = actionDAO.findById(15);
        role.addAction(action);

        action = actionDAO.findById(15);
        role.addAction(action);
    }

    private static void createAdminRole(Role role) {
        for(Iterator<Action> it = actionDAO.getAllActions().iterator(); it.hasNext();) {
            role.addAction(it.next());
        }
    }

    @Override
    public Role findById(long id) {
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getId() == id)
                return roles.get(i);
        }
        return null;
    }

    @Override
    public Role findByName(String name) {
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getName().equals(name))
                return roles.get(i);
        }
        return null;
    }

    @Override
    public List<Role> getAll() {
        return roles;
    }

    @Override
    public boolean isRoleExist(Role role) {
        return roles.contains(role);
    }

    @Override
    public boolean createRole(Role role) {
        role.setId(counter.addAndGet(1));
        roles.add(role);
        return true;
    }

    @Override
    public boolean updateRole(Role role) {
        int index = roles.indexOf(role);
        roles.set(index, role);
        return true;
    }

    @Override
    public boolean deleteRole(long id) {
        for (Iterator<Role> it = roles.iterator(); it.hasNext(); ) {
            Role role = it.next();
            if (role.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
