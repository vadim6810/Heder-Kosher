package com.tel_ran.hederkosher.rest.common.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class RootController extends Controller{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> getIndexPage() {
        String res = "Hello!!";
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
