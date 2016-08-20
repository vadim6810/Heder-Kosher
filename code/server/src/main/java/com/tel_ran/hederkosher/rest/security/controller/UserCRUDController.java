package com.tel_ran.hederkosher.rest.security.controller;

import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.security.service.UserCRUDService;
import com.tel_ran.hederkosher.security.UserLoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserCRUDController {

    @Autowired
    UserCRUDService userCRUDService;

    Logger logger = LoggerFactory.getLogger(UserCRUDService.class);

    //------------------Get all users------------------------
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> listAllUsers() {
        ServiceResult res = userCRUDService.findAllUser();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //-------------------------get one user -----------------
    @RequestMapping(value = "/user/{id}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getUser(@PathVariable("id") long id) {
        ServiceResult res = userCRUDService.findByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //-------------Create user ------------------------------
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> createUser(@RequestBody UserLoginInfo uli) {
        //TODO Check if user already exist
        User user = new User();
        user.setEmail(uli.getEmail());
        user.setPassword(uli.getPassHash());
        user.setRegDate(new Date());

        ServiceResult res  = userCRUDService.createUser(user);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    //-----------------Update user ---------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ServiceResult> updateUser(@PathVariable("id") long id, @RequestBody UserLoginInfo uli) {
        ServiceResult res = userCRUDService.findByID(id);
        if (res.getCode() != 0) {
            res = ServiceResultFactory.NOT_FOUND;
            res.setData(id);
            res.setDescription("user with id = " + id + " is not found");
            return new ResponseEntity<>(res, HttpStatus.OK);
        }

        User user = (User) (res.getData());
        if (!uli.getEmail().equals(user.getEmail())) {
            res = ServiceResultFactory.ENTITY_CONFLICT;
            res.setData(id);
            res.setDescription("user with id = " + id + " was created with another email");
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        logger.error("Password before : " + user.getPassword());
        logger.error("uli.passhash : " + uli.getPassHash());
        user.setPassword(uli.getPassHash());
        logger.error("password after : " + user.getPassword());
        user.setId(id);
        res = userCRUDService.updateUser(user);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //----------------Delete user -------------------------------
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteUser(@PathVariable("id") long id) {
        ServiceResult res = userCRUDService.deleteUser(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //---------------get all roles from user --------------------
    @RequestMapping(value = "user/{id}/auth", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getRolesByUser(@PathVariable("id") long id) {
        ServiceResult res = userCRUDService.getAuthoritiesByUser(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
