package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Message;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.MessageRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import static com.tel_ran.hederkosher.api.ConstantsApplication.*;

@RestController
public class MessagesRESTController {

    @Autowired
    private MessageRESTService messageRESTService;

    //------------------Get all messagees ------------------------
    @RequestMapping(value = URI_MESSAGES, method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getAllMessages() {
        ServiceResult res = messageRESTService.getAllMessages();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Create message --------------------------
    @RequestMapping(value = URI_MESSAGES, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createMessage(@RequestBody Message message, UriComponentsBuilder ucBuilder) {
        ServiceResult res = messageRESTService.createMessage(message);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Delete all messages --------------------------
    @RequestMapping(value = URI_MESSAGES , method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteAllMessages() {
        ServiceResult res = messageRESTService.deleteAllMessages();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }



    //------------------Get messagees by like name -----------------------
    @RequestMapping(value = URI_MESSAGES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "name")
    public ResponseEntity<ServiceResult> getMessagesByLikeName(@RequestParam String name) {
        ServiceResult res = messageRESTService.getMessagesByLikeName(name);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get messagees by state -----------------------
    @RequestMapping(value = URI_MESSAGES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "state")
    public ResponseEntity<ServiceResult> getMessagesByState(@RequestParam String state) {
        ServiceResult res = messageRESTService.getMessagesByState(state);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Get messagees by state -----------------------
    @RequestMapping(value = URI_MESSAGES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
            ,params = "type")
    public ResponseEntity<ServiceResult> getMessagesByType(@RequestParam String type) {
        ServiceResult res = messageRESTService.getMessagesByType(type);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }





    //------------------Get message by ID-----------------------
    @RequestMapping(value = URI_MESSAGES + "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> findMessageByID(@PathVariable("id") long id) {
        ServiceResult res = messageRESTService.findMessageByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Update message --------------------------
    @RequestMapping(value = URI_MESSAGES + "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> updateMessage(@PathVariable("id") long id, @RequestBody Message message, UriComponentsBuilder ucBuilder) {
        message.setId(id); //нехорошо, нужно через сервис!!!!
        ServiceResult res = messageRESTService.updateMessage(message);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  message  --------------------------
    @RequestMapping(value = URI_MESSAGES + "/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteMessage(@PathVariable("id") long id) {
        ServiceResult res = messageRESTService.deleteMessage(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }




    //------------------ Create message by PROGRAM  --------------------------
    @RequestMapping(value = URI_PROGRAMS+"/{id}"+ URI_MESSAGES, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createMessageByProgram(@PathVariable("id") long idProgram,@RequestBody Message message, UriComponentsBuilder ucBuilder) {
        ServiceResult res = messageRESTService.createMessageByProgram(idProgram,message);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Get messages by PROGRAM -----------------------
    @RequestMapping(value = URI_PROGRAMS+"/{id}"+ URI_MESSAGES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getMessagesByProgram(@PathVariable("id") long idProgram) {
        ServiceResult res = messageRESTService.getMessagesByProgram(idProgram);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  messages by PROGRAM --------------------------
    @RequestMapping(value = URI_PROGRAMS+"/{id}"+ URI_MESSAGES, method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteMessagesByProgram(@PathVariable("id") long idProgram) {
        ServiceResult res = messageRESTService.deleteMessagesByProgram(idProgram);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    //------------------ Create message by TASK  --------------------------
    @RequestMapping(value = URI_TASKS+"/{id}"+ URI_MESSAGES, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createMessageByTask(@PathVariable("id") long idTask,@RequestBody Message message, UriComponentsBuilder ucBuilder) {
        ServiceResult res = messageRESTService.createMessageByTask(idTask, message);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Get messages by TASK -----------------------
    @RequestMapping(value = URI_TASKS+"/{id}"+ URI_MESSAGES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getMessagesByTask(@PathVariable("id") long idTask) {
        ServiceResult res = messageRESTService.getMessagesByTask(idTask);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  messages by TASK --------------------------
    @RequestMapping(value = URI_TASKS+"/{id}"+ URI_MESSAGES, method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteMessagesByTask(@PathVariable("id") long idTask) {
        ServiceResult res = messageRESTService.deleteMessagesByTask(idTask);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //------------------ Create message by USER_FROM  --------------------------
    @RequestMapping(value = URI_USERS+"/{id}"+ URI_MESSAGES, method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createMessageByUser(@PathVariable("id") long idUser,@RequestBody Message message, UriComponentsBuilder ucBuilder) {
        ServiceResult res = messageRESTService.createMessageByUser(idUser, message);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    //------------------Get messages by USER_FROM -----------------------
    @RequestMapping(value = URI_USERS+"/{id}"+ URI_MESSAGES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getMessagesByUserFrom(@PathVariable("id") long idUser) {
        ServiceResult res = messageRESTService.getMessagesByUserFrom(idUser);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //------------------Delete  messages by USER_FROM --------------------------
    @RequestMapping(value = URI_USERS+"/{id}"+ URI_MESSAGES, method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteMessagesByUserFrom(@PathVariable("id") long idUser) {
        ServiceResult res = messageRESTService.deleteMessagesByUserFrom(idUser);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
