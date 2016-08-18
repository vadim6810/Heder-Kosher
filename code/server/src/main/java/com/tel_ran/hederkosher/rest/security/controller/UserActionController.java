package com.tel_ran.hederkosher.rest.security.controller;

import com.tel_ran.hederkosher.rest.*;
import com.tel_ran.hederkosher.rest.security.service.UserActionsService;
import com.tel_ran.hederkosher.security.UserLoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Igor on 14.08.2016.
 */
@RestController
public class UserActionController {
    @Autowired
    UserActionsService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> login(@RequestBody UserLoginInfo uli) {
        ServiceResult res = service.login(uli.getEmail(), uli.getPassHash());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
