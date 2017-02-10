package com.tel_ran.hederkosher.web.service;

import com.tel_ran.hederkosher.web.model.User;

/**
 * Created by Ruslan on 10/02/17.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
