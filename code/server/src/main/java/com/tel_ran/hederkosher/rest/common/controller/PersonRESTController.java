package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.PersonRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.tel_ran.hederkosher.api.ConstantsApplication.*;

@RestController
public class PersonRESTController {

//    private static final String URI_PERSONS = "/persons";

    @Autowired
    private PersonRESTService personRESTService;


    //------------------Get all persons------------------------ +
//    @RequestMapping(value = {URI_PERSONS, URI_PERSONS+"/"}, method = RequestMethod.GET)
    @RequestMapping(value = URI_PERSONS, method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getAllPersons() {
        ServiceResult res = personRESTService.getAllPersons();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Create person--------------------------
    @RequestMapping(value = URI_PERSONS, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createPerson(@RequestBody Person person, UriComponentsBuilder ucBuilder) {
        ServiceResult res = personRESTService.createPerson(person);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Delete person--------------------------
    @RequestMapping(value = URI_PERSONS, method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAllPersons() {
        ServiceResult res = personRESTService.deleteAllPersons();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    //------------------Get person by ID----------------------- +
    @RequestMapping(value = URI_PERSONS + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getPerson(@PathVariable("id") long id) {
        ServiceResult res = personRESTService.findPersonByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Update person--------------------------
    @RequestMapping(value = URI_PERSONS + "/{id}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> updatePerson(@PathVariable("id") long id, @RequestBody Person person) {
        person.setId(id); //нехорошо, нужно через сервис!!!!
        ServiceResult res = personRESTService.updatePerson(person);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete person--------------------------
    @RequestMapping(value = URI_PERSONS + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deletePerson(@PathVariable("id") long id) {
        ServiceResult res = personRESTService.deletePerson(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }




    //------------------Get person by FIO----------------------- +
    @RequestMapping(value = URI_PERSONS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "firstName,secondName,lastName")
    public ResponseEntity<ServiceResult> getPersonByFio(@RequestParam String firstName,@RequestParam String secondName,@RequestParam String lastName) {
        ServiceResult res = personRESTService.getPersonsByFio(firstName,secondName,lastName);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get person by Passport----------------------- +
    @RequestMapping(value = URI_PERSONS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "passport")
    public ResponseEntity<ServiceResult> getByPassport(@RequestParam String passport) {
        ServiceResult res = personRESTService.getByPassport(passport);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get person by Email----------------------- +
    @RequestMapping(value = URI_PERSONS , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "email")
    public ResponseEntity<ServiceResult> getByEmail(@RequestParam String email) {
        ServiceResult res = personRESTService.getByEmail(email);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get person by Telephone----------------------- +
    @RequestMapping(value = URI_PERSONS , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "telephone")
    public ResponseEntity<ServiceResult> getByTelephone(@RequestParam String telephone) {
        ServiceResult res = personRESTService.getByTelephone(telephone);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


}
