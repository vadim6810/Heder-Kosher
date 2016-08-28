package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.entity.Authority;
import com.tel_ran.hederkosher.model.security.entity.Role;

import java.util.List;

/**
 * Created by Igor on 07.08.2016.
 */
public interface RoleDAO {

    //@PreAuthorize("@Verifier.checkAuthority('LIST_ROLES')")
    Role findById(long id);

    Role findByName(String name);

    List<Role> getAll();

    boolean createRole(Role role);
    boolean updateRole(Role role);
    boolean deleteRole(long id);

    List<Authority> getAuthorities(Role role);
}
