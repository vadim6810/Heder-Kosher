package com.tel_ran.hederkosher.rest.common.controller;

import com.tel_ran.hederkosher.model.common.entity.Task;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.TaskCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class TaskCRUDController {

    @Autowired
    private TaskCRUDService taskCRUDService;

    //------------------Get all tasks------------------------
    @RequestMapping(value = "/task/", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> listAllStates() {
        ServiceResult res = taskCRUDService.findAllTasks();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //-------------------------get one task -----------------
    @RequestMapping(value = "/task/{id}",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getUser(@PathVariable("id") long id) {
        ServiceResult res = taskCRUDService.findByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //-------------Create task ------------------------------
    @RequestMapping(value = "/task/", method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> createTask(@RequestBody Task task, UriComponentsBuilder ucBuilder) {
        ServiceResult res  = taskCRUDService.createTask(task);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    //-----------------Update task ---------------------------
//    @RequestMapping(value = "/task/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<ServiceResult> updateTask(@PathVariable("id") long id, @RequestBody Task task) {
//        task.setId(id);
//        ServiceResult res = taskCRUDService.updateTask(task);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }


    //----------------Delete task -------------------------------
    @RequestMapping(value = "task/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteTask(@PathVariable("id") long id) {
        ServiceResult res = taskCRUDService.deleteTask(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
