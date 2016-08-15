package com.tel_ran.hederkosher.security;

import com.tel_ran.hederkosher.model.security.User;
import com.tel_ran.hederkosher.model.security.dao.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Igor on 14.08.2016.
 */

@Service("TokenChecker")
public class TokenChecker {

    @Autowired
    private TokenDAO tokenDAO;

    public void verifyToken(String stToken) {
        User user =  tokenDAO.getUser(stToken);

    }

    public TokenChecker() {
    }
}
