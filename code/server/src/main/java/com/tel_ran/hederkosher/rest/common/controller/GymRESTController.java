package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Gym;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.GymRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.tel_ran.hederkosher.api.ConstantsApplication.URI_GYMS;

@RestController
public class GymRESTController {

//    private static final String URI_ROOMS = "/rooms";

    @Autowired
    private GymRESTService gymRESTService;

    //------------------Get all gyms ------------------------ +
    @RequestMapping(value = URI_GYMS, method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getAllGyms() {
        ServiceResult res = gymRESTService.getAllGyms();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Create gym -------------------------- +
    @RequestMapping(value = URI_GYMS, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createGym(@RequestBody Gym gym, UriComponentsBuilder ucBuilder) {
        ServiceResult res = gymRESTService.createGym(gym);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Delete all gyms -------------------------- +
    @RequestMapping(value = URI_GYMS , method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAllGyms() {
        ServiceResult res = gymRESTService.deleteAllGyms();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    //------------------Get gym by name ----------------------- +
    @RequestMapping(value = URI_GYMS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "name")
    public ResponseEntity<ServiceResult> getByName(@RequestParam String name) {
        ServiceResult res = gymRESTService.getByName(name);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }




    //------------------Get gym by ID----------------------- +
    @RequestMapping(value = URI_GYMS + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getGym(@PathVariable("id") long id) {
        ServiceResult res = gymRESTService.findGymByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Update gym -------------------------- +
    @RequestMapping(value = URI_GYMS + "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> updateGym(@PathVariable("id") long id, @RequestBody Gym gym, UriComponentsBuilder ucBuilder) {
        gym.setId(id); //нехорошо, нужно через сервис!!!!
        ServiceResult res = gymRESTService.updateGym(gym);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  gym -------------------------- +
    @RequestMapping(value = URI_GYMS + "/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteGym(@PathVariable("id") long id) {
        ServiceResult res = gymRESTService.deleteGym(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
