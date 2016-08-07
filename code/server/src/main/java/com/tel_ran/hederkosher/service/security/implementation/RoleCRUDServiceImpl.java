package com.tel_ran.hederkosher.service.security.implementation;

import com.tel_ran.hederkosher.model.security.Role;
import com.tel_ran.hederkosher.model.security.dao.*;
import com.tel_ran.hederkosher.service.*;
import com.tel_ran.hederkosher.service.security.RoleCRUDService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Igor on 07.08.2016.
 */
@Service("roleCRUDService")
@Transactional
public class RoleCRUDServiceImpl implements RoleCRUDService {
    RoleDAO roleDao = RoleDAOFabric.getRoleDAO("test");
    ServiceResult result;

    @Override
    public ServiceResult findById(long id) {
        Role role = roleDao.findById(id);
        if (role == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(id);
            result.setDescription("Role with ID = " + id + " not found");
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(role);
        return result;
    }

    @Override
    public ServiceResult findAll() {
        result = ServiceResultFactory.OK;
        result.setData(roleDao.getAll());
        return result;
    }

    @Override
    public ServiceResult isRoleExist(Role role) {
        result = ServiceResultFactory.OK;
        result.setData(roleDao.isRoleExist(role));
        return result;
    }

    @Override
    public ServiceResult createRole(Role role) {
        if (roleDao.isRoleExist(role)) {
            result = ServiceResultFactory.ENTITY_CONFLICT;
        } else {
            if (roleDao.createRole(role)) {
                result = ServiceResultFactory.OK;
            } else {
                result = ServiceResultFactory.CREATING_ERROR;
            }

        }
        result.setData(role);
        return result;
    }

    @Override
    public ServiceResult updateRole(Role role) {
        Role currentRole = roleDao.findById(role.getId());
        if (currentRole == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(role);
            return result;
        }

        currentRole.setName(role.getName());
        currentRole.setDescription(role.getDescription());

        if (roleDao.updateRole(currentRole)) {
            result = ServiceResultFactory.OK;
            result.setData(currentRole);
        } else {
            result = ServiceResultFactory.UPDATING_ERROR;
            result.setData(role);
        }
        return result;
    }

    @Override
    public ServiceResult deleteRole(long id) {
        Role currentRole = roleDao.findById(id);
        if (currentRole == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(id);
            return result;
        }

        if (roleDao.deleteRole(id)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.DELETING_ERROR;
        }
        result.setData(id);
        return result;
    }

}
