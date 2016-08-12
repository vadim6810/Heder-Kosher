package com.tel_ran.hederkosher.rest.security;

import com.tel_ran.hederkosher.model.security.Role;
import com.tel_ran.hederkosher.rest.ServiceResult;

/**
 * Created by Igor on 07.08.2016.
 */
public interface RoleCRUDService {
    ServiceResult findById(long id);
    ServiceResult findAll();

    ServiceResult isRoleExist(Role role);

    ServiceResult createRole(Role role);
    ServiceResult updateRole(Role role);
    ServiceResult deleteRole(long id);
}
