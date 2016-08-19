package com.tel_ran.hederkosher.controller;

import com.tel_ran.hederkosher.model.State;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.StateCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class StateCRUDController {

    @Autowired
    StateCRUDService stateCRUDService;

    //------------------Get all states------------------------
    @RequestMapping(value = "/state/", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> listAllStates() {
        ServiceResult res = stateCRUDService.findAllStates();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //-------------------------get one state -----------------
    @RequestMapping(value = "/state/{id}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getUser(@PathVariable("id") long id) {
        ServiceResult res = stateCRUDService.findByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //-------------Create state ------------------------------
    @RequestMapping(value = "/state/", method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> createState(@RequestBody State state, UriComponentsBuilder ucBuilder) {
        ServiceResult res  = stateCRUDService.createState(state);
        //HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        //return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    //-----------------Update state ---------------------------
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<ServiceResult> updateUser(@PathVariable("id") long id, @RequestBody User user) {
//        user.setId(id);
//        ServiceResult res = stateCRUDService.updateUser(user);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }


    //----------------Delete state -------------------------------
    @RequestMapping(value = "state/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteState(@PathVariable("id") long id) {
        ServiceResult res = stateCRUDService.deleteState(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
