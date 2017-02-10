package com.tel_ran.hederkosher.web.service;

/**
 * Created by Ruslan on 10/02/17.
 */

public interface SecurityService {
    String findLoggedUserName();
    void autoLogin(String username,String password);
}
