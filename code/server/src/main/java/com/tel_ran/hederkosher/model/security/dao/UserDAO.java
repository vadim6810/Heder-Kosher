package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.entity.Role;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.model.security.entity.UserGrantedAuthority;

import java.util.List;
import java.util.Set;

/**
 * Created by Igor on 05.08.2016.
 */


public interface UserDAO {
    User findByID(long id);
    User findByMail(String mail);

    List<User> findAllUser();

    boolean isUserExist(User user);

    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(long id);
}
