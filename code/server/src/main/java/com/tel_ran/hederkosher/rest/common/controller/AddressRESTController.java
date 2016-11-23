package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Address;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.AddressRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.tel_ran.hederkosher.api.ConstantsApplication.*;

@RestController
public class AddressRESTController {

    @Autowired
    private AddressRESTService addressRESTService;

    //------------------Get all addresses ------------------------+
    @RequestMapping(value = URI_ADDRESSES, method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getAllAddresses() {
        ServiceResult res = addressRESTService.getAllAddresses();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Create address --------------------------+
    @RequestMapping(value = URI_ADDRESSES, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createAddress(@RequestBody Address address, UriComponentsBuilder ucBuilder) {
        ServiceResult res = addressRESTService.createAddress(address);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Delete all addresses --------------------------
    @RequestMapping(value = URI_ADDRESSES , method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAllAddresses() {
        ServiceResult res = addressRESTService.deleteAllAddresses();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    //------------------Get addresses by any name -----------------------+
    @RequestMapping(value = URI_ADDRESSES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "name")
    public ResponseEntity<ServiceResult> getByAnyName(@RequestParam String name) {
        ServiceResult res = addressRESTService.getByAnyName(name);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get addresses by names -----------------------
    @RequestMapping(value = URI_ADDRESSES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "country, city, street,building,apartment, postalCode")
    public ResponseEntity<ServiceResult> getByNames(@RequestParam String country, @RequestParam String city,
                                                      @RequestParam String street, @RequestParam String building,
                                                      @RequestParam String apartment, @RequestParam String postalCode) {
        ServiceResult res = addressRESTService.getByNames(country, city, street,building,apartment, postalCode);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }




    //------------------Get address by ID-----------------------+
    @RequestMapping(value = URI_ADDRESSES + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> findAddressByID(@PathVariable("id") long id) {
        ServiceResult res = addressRESTService.findAddressByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Update address --------------------------+
    @RequestMapping(value = URI_ADDRESSES + "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> updateAddress(@PathVariable("id") long id, @RequestBody Address address, UriComponentsBuilder ucBuilder) {
        address.setId(id); //нехорошо, нужно через сервис!!!!
        ServiceResult res = addressRESTService.updateAddress(address);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  address  --------------------------+
    @RequestMapping(value = URI_ADDRESSES + "/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAddress(@PathVariable("id") long id) {
        ServiceResult res = addressRESTService.deleteAddress(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }




    //------------------ Create address by Person  -------------------------- +
    @RequestMapping(value = URI_PERSONS+"/{id}"+ URI_ADDRESSES, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createAddressByPerson(@PathVariable("id") long idPerson,@RequestBody Address address, UriComponentsBuilder ucBuilder) {
        ServiceResult res = addressRESTService.createAddressByPerson(idPerson,address);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Get addresses by Person -----------------------
    @RequestMapping(value = URI_PERSONS+"/{id}"+ URI_ADDRESSES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getAddressesByPerson(@PathVariable("id") long idPerson) {
        ServiceResult res = addressRESTService.getAddressesByPerson(idPerson);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  addresses by Person --------------------------
    @RequestMapping(value = URI_PERSONS+"/{id}"+ URI_ADDRESSES, method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAddressesByPerson(@PathVariable("id") long idPerson) {
        ServiceResult res = addressRESTService.deleteAddressesByPerson(idPerson);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //------------------ Create address by Room  -------------------------- +
    @RequestMapping(value = URI_ROOMS+"/{id}"+ URI_ADDRESSES, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createAddressByRoom(@PathVariable("id") long idRoom,@RequestBody Address address, UriComponentsBuilder ucBuilder) {
        ServiceResult res = addressRESTService.createAddressByRoom(idRoom, address);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Get addresses by Room -----------------------
    @RequestMapping(value = URI_ROOMS+"/{id}"+ URI_ADDRESSES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getAddressesByRoom(@PathVariable("id") long idRoom) {
        ServiceResult res = addressRESTService.getAddressesByRoom(idRoom);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  addresses by Room --------------------------
    @RequestMapping(value = URI_ROOMS+"/{id}"+ URI_ADDRESSES, method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAddressesByRoom(@PathVariable("id") long idRoom) {
        ServiceResult res = addressRESTService.deleteAddressesByRoom(idRoom);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //------------------ Create address by Gym  -------------------------- +
    @RequestMapping(value = URI_GYMS+"/{id}"+ URI_ADDRESSES, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createAddressByGym(@PathVariable("id") long idGym,@RequestBody Address address, UriComponentsBuilder ucBuilder) {
        ServiceResult res = addressRESTService.createAddressByGym(idGym, address);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Get addresses by Gym -----------------------
    @RequestMapping(value = URI_GYMS+"/{id}"+ URI_ADDRESSES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getAddressesByGym(@PathVariable("id") long idGym) {
        ServiceResult res = addressRESTService.getAddressesByGym(idGym);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  addresses by Gym --------------------------
    @RequestMapping(value = URI_GYMS+"/{id}"+ URI_ADDRESSES, method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAddressesByGym(@PathVariable("id") long idGym) {
        ServiceResult res = addressRESTService.deleteAddressesByGym(idGym);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }








}
