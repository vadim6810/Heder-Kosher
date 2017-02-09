package com.tel_ran.hederkosher.security;

import com.tel_ran.hederkosher.model.security.dao.implementation.UserDAOImpl;
import com.tel_ran.hederkosher.model.security.entity.Account;
import com.tel_ran.hederkosher.model.security.entity.AuthUser;
import com.tel_ran.hederkosher.model.security.entity.UserGrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class AuthService implements UserDetailsService {

    private final UserDAOImpl userDao;

    @Autowired
    public AuthService(UserDAOImpl userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Looking for " + username);
        Account account = userDao.findByMail(username);
        if (account != null) {
            System.out.println("Found " + account);
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (UserGrantedAuthority authority : account.getAuthorities()) {
                authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
            }
            AuthUser authUser = new AuthUser(account.getEmail(), account.getPassword(), authorities);
            return authUser;
        } else {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
    }
}
