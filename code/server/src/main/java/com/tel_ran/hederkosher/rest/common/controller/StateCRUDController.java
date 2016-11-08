package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.StateCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StateCRUDController {

    private static final String URI_STATES = "/states";

    @Autowired
    private StateCRUDService stateCRUDService;

    //------------------Get all states------------------------
    @RequestMapping(value = {URI_STATES, URI_STATES + "/"}, method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getAllStates() {
        ServiceResult res = stateCRUDService.findAllStates();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //------------------Get state by code---------------------
    @RequestMapping(value = URI_STATES + "/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getState(@PathVariable("code") String code) {
        ServiceResult res = stateCRUDService.findStateByCode(code);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
