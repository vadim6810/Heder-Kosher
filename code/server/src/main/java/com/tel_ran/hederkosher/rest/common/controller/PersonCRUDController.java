package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.PersonCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class PersonCRUDController {

    private static final String URI_PERSONS = "/persons";

    @Autowired
    private PersonCRUDService personCRUDService;

    //------------------Get all persons------------------------ +
    @RequestMapping(value = {URI_PERSONS, URI_PERSONS + "/"}, method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> listAllPersons() {
        ServiceResult res = personCRUDService.getAllPersons();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get person by ID----------------------- +
    @RequestMapping(value = URI_PERSONS + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getPerson(@PathVariable("id") long id) {
        ServiceResult res = personCRUDService.findPersonByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get person by FIO----------------------- -
//    @RequestMapping(value = URI_PERSONS + "/{firstName},{secondName},{lastName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ServiceResult> getPersonByFio(@PathVariable("firstName") String firstName,
//                                                        @PathVariable("secondName") String secondName,
//                                                        @PathVariable("lastName") String lastName) {
//        ServiceResult res = personCRUDService.getPersonsByFio(firstName,secondName,lastName);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }
    @RequestMapping(value = URI_PERSONS + "/fio", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getPersonByFio(String firstName,String secondName,String lastName) {
        ServiceResult res = personCRUDService.getPersonsByFio(firstName,secondName,lastName);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get person by Passport----------------------- +
    @RequestMapping(value = URI_PERSONS + "/passport/{passport}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getByPassport(@PathVariable("passport") String passport) {
        ServiceResult res = personCRUDService.getByPassport(passport);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get person by Email----------------------- +
    @RequestMapping(value = URI_PERSONS + "/email/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getByEmail(@PathVariable("email") String email) {
        ServiceResult res = personCRUDService.getByEmail(email);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get person by Telephone----------------------- +
    @RequestMapping(value = URI_PERSONS + "/telephone/{telephone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getByTelephone(@PathVariable("telephone") String telephone) {
        ServiceResult res = personCRUDService.getByTelephone(telephone);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //------------------Create person--------------------------
    @RequestMapping(value = URI_PERSONS, method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
        ServiceResult res = personCRUDService.createPerson(person);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Update person--------------------------
    @RequestMapping(value = URI_PERSONS + "/{id}", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        person.setId(id);
        ServiceResult res = personCRUDService.updatePerson(person);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete person--------------------------
    @RequestMapping(value = URI_PERSONS + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deletePerson(@PathVariable("id") long id) {
        ServiceResult res = personCRUDService.deletePerson(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
