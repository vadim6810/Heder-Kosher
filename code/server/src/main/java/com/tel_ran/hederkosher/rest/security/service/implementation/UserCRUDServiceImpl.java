package com.tel_ran.hederkosher.rest.security.service.implementation;

import com.tel_ran.hederkosher.model.security.dao.UserDAO;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.security.service.UserCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Igor on 05.08.2016.
 */
@Service("userCRUDService")
@Transactional
public class UserCRUDServiceImpl implements UserCRUDService {

    @Autowired
    private UserDAO userDao;

    private ServiceResult result;

    @Override
    public ServiceResult findByID(long id) {
        User user = userDao.findByID(id);
        if (user == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData((Long)id);
            result.setDescription("user with id = " + id + " not found");
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(user);
        return result;
    }

    @Override
    public ServiceResult findByEmail(String email) {
        User user = userDao.findByMail(email);
        if (user == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(email);
            result.setDescription("user with email = '" + email + "' not found");
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(user);
        return result;
    }

    @Override
    public ServiceResult findAllUser() {
        result = ServiceResultFactory.OK;
        result.setData(userDao.findAllUser());
        return result;
    }

    @Override
    public ServiceResult createUser(User user) {
        User oldUser = userDao.findByID(user.getId());
        if (oldUser != null) {
            result = ServiceResultFactory.ENTITY_CONFLICT;
        } else {
            if (userDao.createUser(user)) {
                result = ServiceResultFactory.OK;
            } else {
                result = ServiceResultFactory.CREATING_ERROR;
            }
        }
        result.setData(user);
        return result;
    }

    @Override
    public ServiceResult updateUser(User user) {
        User currentUser = userDao.findByID(user.getId());
        if (currentUser == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(user);
            return result;
        }

        currentUser.setPassword(user.getPassword());

        if (userDao.updateUser(currentUser)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.UPDATING_ERROR;
        }
        result.setData(currentUser);
        return result;
    }

    @Override
    public ServiceResult deleteUser(long id) {
        User currentUser = userDao.findByID(id);
        if (currentUser == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(id);
            return result;
        }

        if (userDao.deleteUser(id)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.DELETING_ERROR;
        }
        result.setData(id);
        return result;
    }

    @Override
    public ServiceResult getAuthoritiesByUser(long id) {
        User user = userDao.findByID(id);
        if (user == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData((Long)id);
            result.setDescription("user with id = " + id + " not found");
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(user.getAuthorities());
        return result;
    }
}
