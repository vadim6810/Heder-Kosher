package com.tel_ran.hederkosher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Igor on 05.08.2016.
 */

@RestController
public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> getIndexPage() {
        String res = "Hello!!";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
