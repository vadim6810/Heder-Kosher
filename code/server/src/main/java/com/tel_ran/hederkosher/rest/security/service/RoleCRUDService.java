package com.tel_ran.hederkosher.rest.security.service;

import com.tel_ran.hederkosher.model.security.entity.Role;
import com.tel_ran.hederkosher.rest.ServiceResult;

/**
 * Created by Igor on 07.08.2016.
 */
public interface RoleCRUDService {
    ServiceResult findById(long id);
    ServiceResult findAll();

    ServiceResult createRole(Role role);
    ServiceResult updateRole(Role role);
    ServiceResult deleteRole(long id);

    ServiceResult getRoleAuth(long id);
}
