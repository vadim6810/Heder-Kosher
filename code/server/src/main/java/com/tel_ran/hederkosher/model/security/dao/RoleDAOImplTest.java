package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Igor on 07.08.2016.
 */
public class RoleDAOImplTest implements RoleDAO {
    private static final AtomicLong counter = new AtomicLong();
    private static List<Role> roles;
    
    static{
        roles = createTestRoles();
    }

    private static List<Role> createTestRoles() {
        List<Role> res = new ArrayList<>();
        res.add(new Role(1, "ADMIN", "Application Administrator"));
        res.add(new Role(2, "MANAGER", "Manager of gym"));
        res.add(new Role(3, "TRAINER", "Trainer in gym"));
        res.add(new Role(4, "CLIENT", "Simple user"));
        return res;
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
