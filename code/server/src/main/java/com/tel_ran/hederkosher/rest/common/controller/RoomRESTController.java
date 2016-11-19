package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.IRoomRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class RoomRESTController {

    private static final String URI_ROOMS = "/rooms";

    @Autowired
    private IRoomRESTService roomRESTService;

    //------------------Get all rooms------------------------ +
    @RequestMapping(value = {URI_ROOMS, URI_ROOMS + "/" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getAllRooms() {
        ServiceResult res = roomRESTService.getAllRoomsActives();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
//    //------------------Get all rooms activity ------------------------ +
//    @RequestMapping(value = {URI_ROOMS, URI_ROOMS + "/"}, method = RequestMethod.GET)
//    public ResponseEntity<ServiceResult> getAllRoomsActives() {
//        ServiceResult res = roomRESTService.getAllRoomsActives();
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }


    //------------------Get room by ID----------------------- +
    @RequestMapping(value = URI_ROOMS + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getRoom(@PathVariable("id") long id) {
        ServiceResult res = roomRESTService.findRoomByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //------------------Get room by name ----------------------- +
    @RequestMapping(value = URI_ROOMS + "/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getByName(@PathVariable("name") String name) {
        ServiceResult res = roomRESTService.getByName(name);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //------------------Create room --------------------------
    @RequestMapping(value = URI_ROOMS, method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createRoom(@RequestBody Room room, UriComponentsBuilder ucBuilder) {
        ServiceResult res = roomRESTService.createRoom(room);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
   }
    //------------------Update room --------------------------
    @RequestMapping(value = URI_ROOMS + "/{id}", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> updateRoom(@PathVariable("id") long id, @RequestBody Room room) {
        room.setId(id); //нужно через сервис!!!!
        ServiceResult res = roomRESTService.updateRoom(room);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete room --------------------------
    @RequestMapping(value = URI_ROOMS + "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteRoom(@PathVariable("id") long id) {
        ServiceResult res = roomRESTService.deleteRoom(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
