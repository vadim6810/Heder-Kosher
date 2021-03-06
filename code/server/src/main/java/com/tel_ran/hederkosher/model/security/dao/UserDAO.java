package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.entity.User;

import java.util.List;

/**
 * Created by Igor on 05.08.2016.
 */


public interface UserDAO {
    User findByID(long id);
    User findByMail(String mail);

    List<User> findAllUser();

    boolean createUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(long id);
}
