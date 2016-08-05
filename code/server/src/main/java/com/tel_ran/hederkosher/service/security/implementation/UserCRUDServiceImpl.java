package com.tel_ran.hederkosher.service.security.implementation;

import com.tel_ran.hederkosher.model.security.User;
import com.tel_ran.hederkosher.model.security.dao.UserDAO;
import com.tel_ran.hederkosher.service.security.UserCRUDService;
import com.tel_ran.hederkosher.service.serviceResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Igor on 05.08.2016.
 */
@Service("user")
@Transactional
public class UserCRUDServiceImpl implements UserCRUDService {
    private UserDAO userDao;

    @Override
    public serviceResult findByID(long id) {
        return null;
    }

    @Override
    public serviceResult findByName(String name) {
        return null;
    }

    @Override
    public serviceResult findAllUser() {
        return null;
    }

    @Override
    public serviceResult isUserExist(User user) {
        return null;
    }

    @Override
    public serviceResult createUser(User user) {
        return null;
    }

    @Override
    public serviceResult updateUser(User user) {
        return null;
    }

    @Override
    public serviceResult deleteUser(User user) {
        return null;
    }

    @Override
    public serviceResult deleteUser(long id) {
        return null;
    }
}
