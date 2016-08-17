package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created by Igor on 07.08.2016.
 */
public interface RoleDAO {

    @PreAuthorize("@Verifier.checkAuthority('GET_ROLE')")
    Role findById(long id);

    Role findByName(String name);

    @PreAuthorize("@Verifier.checkAuthority('LIST_ROLES')")
    List<Role> getAll();

    boolean isRoleExist(Role role);

    boolean createRole(Role role);
    boolean updateRole(Role role);
    boolean deleteRole(long id);
}
