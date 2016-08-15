package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.Token;
import com.tel_ran.hederkosher.model.security.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Igor on 14.08.2016.
 */
public interface TokenDAO {
    User getUser(String token) throws UsernameNotFoundException;
    Token createToken(User user);
    void deleteToken(User user);
    void deleteToken(String token);
}
