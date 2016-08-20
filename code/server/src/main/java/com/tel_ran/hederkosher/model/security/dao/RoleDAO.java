package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.entity.Role;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * Created by Igor on 07.08.2016.
 */
public interface RoleDAO {

    @PreAuthorize("@Verifier.checkAuthority('LIST_ROLES')")
    Role findById(long id);

    Role findByName(String name);

    @PreAuthorize("@Verifier.checkAuthority('LIST_ROLES')")
    List<Role> getAll();

    boolean isRoleExist(Role role);

    @PreAuthorize("@Verifier.checkAuthority('CREATE_ROLE')")
    boolean createRole(Role role);
    @PreAuthorize("@Verifier.checkAuthority('UPDATE_ROLE')")
    boolean updateRole(Role role);
    @PreAuthorize("@Verifier.checkAuthority('DELETE_ROLE')")
    boolean deleteRole(long id);
}
