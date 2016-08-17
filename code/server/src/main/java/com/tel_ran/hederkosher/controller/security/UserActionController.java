package com.tel_ran.hederkosher.controller.security;

import com.tel_ran.hederkosher.model.security.*;
import com.tel_ran.hederkosher.model.security.dao.*;
import com.tel_ran.hederkosher.rest.*;
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
    UserDAO userDAO;

    @Autowired
    TokenDAO tokenDAO;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> login(@RequestBody UserLoginInfo uli) {
        ServiceResult res;

        User user = userDAO.findByMail(uli.getEmail());
        if (user == null) {
            res = ServiceResultFactory.CREDENTIALS_NOT_FOUND;
            return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
        }
        /*String hashEmail = DigestUtils.md5DigestAsHex(user.getEmail().getBytes());
        String hashPass  = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        String hash = DigestUtils.md5DigestAsHex((hashEmail + hashPass).getBytes());
        if (!hash.equals(uli.getPassHash())) {
            res = ServiceResultFactory.CREDENTIALS_NOT_FOUND;
            return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
        } */
        res = ServiceResultFactory.OK;
        Token token = tokenDAO.createToken(user);
        res.setData(token.getToken());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
