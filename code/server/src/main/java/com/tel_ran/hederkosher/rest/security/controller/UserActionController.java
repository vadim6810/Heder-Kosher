package com.tel_ran.hederkosher.rest.security.controller;

import com.tel_ran.hederkosher.rest.*;
import com.tel_ran.hederkosher.rest.security.service.UserActionsService;
import com.tel_ran.hederkosher.security.UserLoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.tel_ran.hederkosher.service.Loggers.securityLogger;

/**
 * Created by Igor on 14.08.2016.
 */
@RestController
public class UserActionController {
    @Autowired
    UserActionsService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> login(@RequestBody UserLoginInfo uli, HttpServletRequest request) {
        securityLogger.info("Login request : " + request.getMethod() + " : " + request.getRemoteAddr() + " : " + uli.getEmail());
        ServiceResult res = service.login(uli.getEmail(), uli.getPassHash());
        if (res.getCode() == 0) {
            securityLogger.info("Login result : " + request.getRemoteAddr() + " : " + uli.getEmail() + " : Success");
        } else {
            securityLogger.info("Login result : " + request.getRemoteAddr() + " : " + uli.getEmail() + " : Failed with error : " + res.getMessage());
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
