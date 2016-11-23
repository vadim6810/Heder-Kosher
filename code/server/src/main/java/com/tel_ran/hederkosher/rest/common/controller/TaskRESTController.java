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
public class TaskRESTController {

    private static final String URI_TASKS = "/tasks";
    @Autowired
    private TaskCRUDService taskCRUDService;

    //------------------Get all tasks------------------------
    @RequestMapping(value = {URI_TASKS, URI_TASKS + "/"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> listAllTasks() {
        ServiceResult res = taskCRUDService.findAllTasks();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //------------------Get task by ID-----------------------
    @RequestMapping(value = URI_TASKS + "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> getTask(@PathVariable("id") long id) {
        ServiceResult res = taskCRUDService.findTaskByID(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    //------------------Create task--------------------------
    @RequestMapping(value = URI_TASKS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> createTask(@RequestBody Task task) {
        ServiceResult res = taskCRUDService.createTask(task);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


    //------------------Update task--------------------------
//    @RequestMapping(value = URI_TASKS + "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ServiceResult> updateTask(@PathVariable("id") long id, @RequestBody Task task) {
//        task.setId(id);
//        ServiceResult res = taskCRUDService.updateTask(task);
//        return new ResponseEntity<>(res, HttpStatus.OK);
//    }


    //------------------Delete task--------------------------
    @RequestMapping(value = URI_TASKS + "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResult> deleteTask(@PathVariable("id") long id) {
        ServiceResult res = taskCRUDService.deleteTask(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
