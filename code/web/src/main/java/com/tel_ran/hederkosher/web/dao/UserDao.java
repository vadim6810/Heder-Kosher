package com.tel_ran.hederkosher.web.dao;

import com.tel_ran.hederkosher.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ruslan on 10/02/17.
 */
public interface UserDao extends JpaRepository<User,Long> {
    User findByUsername(String username);

}
