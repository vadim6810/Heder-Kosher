package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.api.entities.ProgramData;
import com.tel_ran.hederkosher.rest.common.service.ProgramCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.*;
import static com.tel_ran.hederkosher.service.Loggers.restLogger;

@RestController
public class ProgramRESTController extends Controller {

    private static final String URI_PROGRAMS = "/programs";

    @Autowired
    private ProgramCRUDService programCRUDService;

    //------------------Get all programs------------------------
    @RequestMapping(value = {URI_PROGRAMS, URI_PROGRAMS + "/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> listAllPrograms(Principal principal) {
        if (principal != null) {
            System.out.println(principal.getName()); //TODO
        }
        ServiceResult res = programCRUDService.findAllPrograms();
        return ResponseEntity.ok(res);
        //return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //------------------Get program by ID-----------------------
    @RequestMapping(value = URI_PROGRAMS + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getProgram(@PathVariable("id") long id) {
        ServiceResult res = programCRUDService.findProgamByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //------------------Create program--------------------------
    @RequestMapping(value = URI_PROGRAMS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createProgram(
            @RequestBody @Valid ProgramData programData,
            BindingResult bindingResult) {

        System.out.println(">>>> We are here starting!");

        if (bindingResult.hasErrors()) {
            System.out.println(">>>> Oops! Invalid Program");
            throw new InvalidRequestException("Oops! Invalid Program Data", bindingResult);
        }

        final ServiceResult res = programCRUDService.createProgram(programData);
        return ResponseEntity
                .status(res.isSuccessful() ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR)
                .body(res);
    }
    /*public ResponseEntity<ServiceResult> createProgram(@RequestBody Program program) {
        ServiceResult res = programCRUDService.createProgram(program);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }*/
    /*public ResponseEntity<ServiceResult> createProgram(@RequestBody ProgramData programData) {
        final ServiceResult res = programCRUDService.createProgram(programData);
        final HttpStatus httpStatus = res.isSuccessful() ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(res, httpStatus);
    }*/



    //------------------Update program--------------------------
//    @RequestMapping(value = URI_PROGRAMS + "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ServiceResult> updateProgram(@PathVariable("id") long id, @RequestBody Program program) {
//        program.setId(id);
//        ServiceResult res = programCRUDService.updateProgram(program);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }


    //------------------Delete program--------------------------
    @RequestMapping(value = URI_PROGRAMS + "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> deleteProgram(@PathVariable("id") long id) {
        ServiceResult res = programCRUDService.deleteProgram(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
