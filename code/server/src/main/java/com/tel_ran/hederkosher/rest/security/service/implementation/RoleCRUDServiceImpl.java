package com.tel_ran.hederkosher.rest.security.service.implementation;

import com.tel_ran.hederkosher.model.security.entity.Role;
import com.tel_ran.hederkosher.model.security.dao.*;
import com.tel_ran.hederkosher.rest.*;
import com.tel_ran.hederkosher.rest.security.service.RoleCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Igor on 07.08.2016.
 */
@Service("roleCRUDService")
@Transactional
public class RoleCRUDServiceImpl implements RoleCRUDService {
    @Autowired
    private RoleDAO roleDao;

    private ServiceResult result;

    @Override
    public ServiceResult findById(long id) {
        Role role = null;
        try {
            role = roleDao.findById(id);
            if (role == null) {
                result = ServiceResultFactory.NOT_FOUND;
                result.setData(id);
                result.setDescription("Role with ID = " + id + " not found");
                return result;
            }
        } catch (AccessDeniedException e) {
            result = ServiceResultFactory.ACCESS_DENIED;
            result.setData(id);
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(role);
        return result;
    }

    @Override
    public ServiceResult findAll() {
        result = ServiceResultFactory.OK;
        try {
            result.setData(roleDao.getAll());
        } catch (AccessDeniedException e) {
            result = ServiceResultFactory.ACCESS_DENIED;
            return result;
        }
        return result;
    }

    @Override
    public ServiceResult createRole(Role role) {
        Role oldRole = roleDao.findById(role.getId());
        if (oldRole != null) {
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
