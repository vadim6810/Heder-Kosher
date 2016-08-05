package com.tel_ran.hederkosher.service.security;

import com.tel_ran.hederkosher.model.security.User;
import com.tel_ran.hederkosher.service.serviceResult;

/**
 * Created by Igor on 05.08.2016.
 */
public interface UserCRUDService {
    serviceResult findByID(long id);

    serviceResult findByName(String name);
    serviceResult findAllUser();

    serviceResult isUserExist(User user);

    serviceResult createUser(User user);
    serviceResult updateUser(User user);
    serviceResult deleteUser(User user);
    serviceResult deleteUser(long id);

}
