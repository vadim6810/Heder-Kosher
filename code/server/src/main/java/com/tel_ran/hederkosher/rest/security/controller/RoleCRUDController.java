package com.tel_ran.hederkosher.rest.security.controller;

import com.tel_ran.hederkosher.model.security.entity.Role;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.security.service.RoleCRUDService;
import com.tel_ran.hederkosher.security.TokenChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Igor on 07.08.2016.
 */

@RestController
public class RoleCRUDController {

    @Autowired
    private TokenChecker checker;

    @Autowired
    private RoleCRUDService service;

    //----------------Get one role
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    //public ResponseEntity<ServiceResult> getRole(@PathVariable("id") long id, @RequestParam("token") String token) {
    public ResponseEntity<ServiceResult> getRole(@PathVariable("id") long id) {
        //checker.verifyToken(token);

        ServiceResult res = service.findById(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //---------------Get All roles
    @RequestMapping(value = "/role/", method = RequestMethod.GET)
    //public ResponseEntity<ServiceResult> getAllRoles(@RequestParam("token") String token) {
    public ResponseEntity<ServiceResult> getAllRoles() {
        //checker.verifyToken(token);

        ServiceResult res = service.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //-------------Create role ------------------------------
    @RequestMapping(value = "/role/", method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> createRole(@RequestBody Role role) { //, UriComponentsBuilder ucBuilder) {
        ServiceResult res  = service.createRole(role);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    //-----------------Update role ---------------------------
    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ServiceResult> updateRole(@PathVariable("id") long id, @RequestBody Role role) {
        role.setId(id);
        ServiceResult res = service.updateRole(role);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //----------------Delete role -------------------------------
    @RequestMapping(value = "role/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteRole(@PathVariable("id") long id) {
        ServiceResult res = service.deleteRole(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = "role/{id}/auth", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getRoleAuth(@PathVariable("id") long id) {
        ServiceResult res = service.getRoleAuth(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
