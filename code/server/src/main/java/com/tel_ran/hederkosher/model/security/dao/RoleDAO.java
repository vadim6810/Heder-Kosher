package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.Role;

import java.util.List;

/**
 * Created by Igor on 07.08.2016.
 */
public interface RoleDAO {
    Role findById(long id);
    Role findByName(String name);

    List<Role> getAll();

    boolean isRoleExist(Role role);

    boolean createRole(Role role);
    boolean updateRole(Role role);
    boolean deleteRole(long id);
}
