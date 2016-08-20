package com.tel_ran.hederkosher.rest.common.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

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
