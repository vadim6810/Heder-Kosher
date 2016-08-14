package com.tel_ran.hederkosher.controller.security;

import com.tel_ran.hederkosher.model.security.User;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.security.UserCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class UserCRUDController {

    @Autowired
    UserCRUDService userCRUDService;

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
    public ResponseEntity<ServiceResult> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        ServiceResult res  = userCRUDService.createUser(user);
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        //return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    //-----------------Update user ---------------------------
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ServiceResult> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        user.setId(id);
        ServiceResult res = userCRUDService.updateUser(user);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //----------------Delete user -------------------------------
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteUser(@PathVariable("id") long id) {
        ServiceResult res = userCRUDService.deleteUser(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
