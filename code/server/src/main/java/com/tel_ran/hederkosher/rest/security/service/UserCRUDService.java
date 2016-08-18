package com.tel_ran.hederkosher.rest.security.service;

import com.tel_ran.hederkosher.model.security.User;
import com.tel_ran.hederkosher.rest.ServiceResult;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * Created by Igor on 05.08.2016.
 */

public interface UserCRUDService {
    ServiceResult findByID(long id);
    ServiceResult findByEmail(String email);

    ServiceResult findAllUser();

    ServiceResult isUserExist(User user);

    ServiceResult createUser(User user);
    ServiceResult updateUser(User user);
    ServiceResult deleteUser(long id);

}
