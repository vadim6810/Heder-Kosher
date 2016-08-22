package com.tel_ran.hederkosher.rest.security.controller;

import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.security.service.UserActionsService;
import com.tel_ran.hederkosher.security.UserLoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.tel_ran.hederkosher.service.Loggers.securityLogger;

/**
 * Created by Igor on 14.08.2016.
 */
@RestController
public class UserActionController {
    public static final String DELIM = " : ";

    @Autowired
    private UserActionsService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> login(@RequestBody UserLoginInfo uli, HttpServletRequest request) {
        securityLogger.info("Login request : " + request.getMethod() + DELIM + request.getRemoteAddr() + DELIM + uli.getEmail());
        ServiceResult res = service.login(uli.getEmail(), uli.getPassHash());
        if (res.getCode() == 0) {
            securityLogger.info("Login result : " + request.getRemoteAddr() + DELIM + uli.getEmail() + " : Success");
        } else {
            securityLogger.info("Login result : " + request.getRemoteAddr() + DELIM + uli.getEmail() + " : Failed with error : " + res.getMessage());
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
