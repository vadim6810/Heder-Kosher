package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Office;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.OfficeRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.tel_ran.hederkosher.api.ConstantsApplication.*;

@RestController
public class OfficeRESTController {

    @Autowired
    private OfficeRESTService OfficeRESTService;

    //------------------Get all Offices ------------------------
    @RequestMapping(value = URI_OFFICES, method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getAllOffices() {
        ServiceResult res = OfficeRESTService.getAllOffices();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Create Office --------------------------
    @RequestMapping(value = URI_OFFICES, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createOffice(@RequestBody Office office, UriComponentsBuilder ucBuilder) {
        ServiceResult res = OfficeRESTService.createOffice(office);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Delete all Offices --------------------------
    @RequestMapping(value = URI_OFFICES , method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAllOffices() {
        ServiceResult res = OfficeRESTService.deleteAllOffices();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    //------------------Get Office by name ----------------------- +
    @RequestMapping(value = URI_OFFICES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "name")
    public ResponseEntity<ServiceResult> getByName(@RequestParam String name) {
        ServiceResult res = OfficeRESTService.getByName(name);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    //------------------Get Office by ID-----------------------
    @RequestMapping(value = URI_OFFICES + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getOffice(@PathVariable("id") long id) {
        ServiceResult res = OfficeRESTService.findOfficeByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Update Office --------------------------
    @RequestMapping(value = URI_OFFICES + "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> updateOffice(@PathVariable("id") long id, @RequestBody Office office, UriComponentsBuilder ucBuilder) {
        office.setId(id); //нехорошо, нужно через сервис!!!!
        ServiceResult res = OfficeRESTService.updateOffice(office);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  Office --------------------------
    @RequestMapping(value = URI_OFFICES + "/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteOffice(@PathVariable("id") long id) {
        ServiceResult res = OfficeRESTService.deleteOffice(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
