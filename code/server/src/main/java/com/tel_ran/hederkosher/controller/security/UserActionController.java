package com.tel_ran.hederkosher.controller.security;

import com.tel_ran.hederkosher.model.security.Token;
import com.tel_ran.hederkosher.model.security.User;
import com.tel_ran.hederkosher.model.security.dao.TokenDAO;
import com.tel_ran.hederkosher.model.security.dao.UserDAO;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.security.UserLoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
