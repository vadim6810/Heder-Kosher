package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.entity.Token;
import com.tel_ran.hederkosher.model.security.entity.User;

/**
 * Created by Igor on 14.08.2016.
 */
public interface TokenDAO {
    User getUser(String token);// throws UsernameNotFoundException;
    Token createToken(User user);
    void deleteToken(User user);
    void deleteToken(String token);
}
