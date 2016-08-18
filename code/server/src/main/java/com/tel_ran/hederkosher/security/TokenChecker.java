package com.tel_ran.hederkosher.security;

import com.tel_ran.hederkosher.model.security.Role;
import com.tel_ran.hederkosher.model.security.User;
import com.tel_ran.hederkosher.model.security.dao.RoleDAO;
import com.tel_ran.hederkosher.model.security.dao.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 14.08.2016.
 */

@Service("TokenChecker")
public class TokenChecker {

    @Autowired
    private TokenDAO tokenDAO;

    @Autowired
    private RoleDAO roleDAO;

    List<GrantedAuthority> authorities = new ArrayList<>();

    public void verifyToken(String stToken) {
        User user =  tokenDAO.getUser(stToken);
        //Role role = roleDAO.findByName("ADMIN");

        authorities.add(new SimpleGrantedAuthority("LIST_ROLES"));
        authorities.add(new SimpleGrantedAuthority("FUUUUUUU!!!!!11111"));

        Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("VerifyToken:\n").append("Principal = ").append(auth.getPrincipal()+"\n");
//        sb.append("");
    }

    public TokenChecker() {
    }
}
