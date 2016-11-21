package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Contact;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.ContactRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.tel_ran.hederkosher.api.ConstantsApplication.*;

@RestController
public class ContactRESTController {

//    private static final String URI_CONTACTS = "/contacts";


    @Autowired
    private ContactRESTService contactRESTService;

    //------------------Get all contacts  ------------------------
    @RequestMapping(value = URI_CONTACTS, method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getAllContacts() {
        ServiceResult res = contactRESTService.getAllContacts();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete all contacts  --------------------------
    @RequestMapping(value = URI_CONTACTS, method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAllContacts() {
        ServiceResult res = contactRESTService.deleteAllContacts();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //------------------Get contacts by Type -----------------------
    @RequestMapping(value = URI_CONTACTS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "type")
    public ResponseEntity<ServiceResult> getContactsByType(@RequestParam String type) {
        ServiceResult res = contactRESTService.getContactsByType(type);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    //------------------Get contact by ID----------------------- +
    @RequestMapping(value = URI_CONTACTS + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getContact(@PathVariable("id") long id) {
        ServiceResult res = contactRESTService.findContactByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Update contact by ID -------------------------- +
    @RequestMapping(value = URI_CONTACTS + "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> updateContact(@PathVariable("id") long id, @RequestBody Contact contact, UriComponentsBuilder ucBuilder) {
        contact.setId(id); //нехорошо, нужно через сервис!!!!
        ServiceResult res = contactRESTService.updateContact(contact);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  contact by ID -------------------------- +
    @RequestMapping(value = URI_CONTACTS + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteContact(@PathVariable("id") long id) {
        ServiceResult res = contactRESTService.deleteContact(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }




    //------------------ Create contact by Person  -------------------------- +
    @RequestMapping(value = URI_PERSONS+"/{id}"+ URI_CONTACTS, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createContact(@PathVariable("id") long idPerson,@RequestBody Contact contact, UriComponentsBuilder ucBuilder) {
        ServiceResult res = contactRESTService.createContact(idPerson, contact);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Get contacts by Person -----------------------
    @RequestMapping(value = URI_PERSONS+"/{id}"+ URI_CONTACTS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getContactsByPerson(@PathVariable("id") long idPerson) {
        ServiceResult res = contactRESTService.getContactsByPerson(idPerson);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  contacts by Person --------------------------
    @RequestMapping(value = URI_PERSONS+"/{id}"+ URI_CONTACTS, method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteContactsByPerson(@PathVariable("id") long id) {
        ServiceResult res = contactRESTService.deleteContactsByPerson(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
