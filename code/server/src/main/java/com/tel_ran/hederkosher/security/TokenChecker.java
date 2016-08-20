package com.tel_ran.hederkosher.security;

import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.model.security.dao.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Igor on 14.08.2016.
 */

@Service("TokenChecker")
public class TokenChecker {

    Logger logger = LoggerFactory.getLogger(TokenChecker.class);

    @Autowired
    private TokenDAO tokenDAO;

    List<GrantedAuthority> authorities = new ArrayList<>();

    public void verifyToken(String stToken) {
        logger.info("Verify token : " + stToken);

        User user =  tokenDAO.getUser(stToken);
        logger.info("Got user + " + user);
        for (GrantedAuthority ga : user.getAuthorities()) {
            logger.info("     roles : " + ga);
            authorities.add(ga);
        }

        Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    public TokenChecker() {
    }
}
