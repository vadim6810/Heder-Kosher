package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.ProgramCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ProgramCRUDController {

    private static final String URI_PROGRAMS = "/programs";

    @Autowired
    private ProgramCRUDService programCRUDService;

    //------------------Get all programs------------------------
    @RequestMapping(value = {URI_PROGRAMS, URI_PROGRAMS + "/"}, method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> listAllPrograms() {
        ServiceResult res = programCRUDService.findAllPrograms();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //------------------Get program by ID-----------------------
    @RequestMapping(value = URI_PROGRAMS + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getProgram(@PathVariable("id") long id) {
        ServiceResult res = programCRUDService.findProgamByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //------------------Create program--------------------------
    @RequestMapping(value = URI_PROGRAMS, method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> createProgram(@RequestBody Program program, UriComponentsBuilder ucBuilder) {
        ServiceResult res = programCRUDService.createProgram(program);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    //------------------Update program--------------------------
//    @RequestMapping(value = URI_PROGRAMS + "/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<ServiceResult> updateProgram(@PathVariable("id") long id, @RequestBody Program program) {
//        program.setId(id);
//        ServiceResult res = programCRUDService.updateProgram(program);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }


    //------------------Delete program--------------------------
    @RequestMapping(value = URI_PROGRAMS + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteProgram(@PathVariable("id") long id) {
        ServiceResult res = programCRUDService.deleteProgram(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
