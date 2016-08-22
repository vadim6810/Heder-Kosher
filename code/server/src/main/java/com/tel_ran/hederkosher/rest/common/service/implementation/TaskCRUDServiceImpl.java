package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.model.common.dao.TaskDao;
import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.common.entity.Task;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.TaskCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Egor on 22.08.2016.
 */
@Service("taskCRUDService")
@Transactional
public class TaskCRUDServiceImpl implements TaskCRUDService {

    @Autowired
    private TaskDao taskDao;

    private ServiceResult result;

    @Override
    public ServiceResult findByID(long id) {
        Task task = taskDao.getById(id);
        if (task == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(id);
            result.setDescription("task with id = " + id + " not found");
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(task);
        return result;
    }

    @Override
    public ServiceResult findAllTasks() {
        result = ServiceResultFactory.OK;
        result.setData(taskDao.getAllTasks());
        return result;
    }

    @Override
    public ServiceResult findByProgram(Program program) {
        result = ServiceResultFactory.OK;
        result.setData(taskDao.getProgramTasks(program));
        return result;
    }

    @Override
    public ServiceResult createTask(Task task) {
        if (taskDao.addTask(task)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.CREATING_ERROR;
        }
        result.setData(task);
        return result;
    }

    @Override
    public ServiceResult updateTask(Task task) {
//        State currentState = stateDao.getById(state.getId());
//        if (currentState == null) {
//            result = ServiceResultFactory.NOT_FOUND;
//            result.setData(state);
//            return result;
//        }
//
//        currentState.setCode(state.getCode());
//        currentState.setName(state.getName());

        //if (stateDao.updateState(currentState)) {
        //    result = ServiceResultFactory.OK;
        //} else {
            result = ServiceResultFactory.UPDATING_ERROR;
        //}
        //result.setData(currentState);
        return result;
    }

    @Override
    public ServiceResult deleteTask(long id) {
        if (taskDao.deleteTask(id)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.DELETING_ERROR;
        }
        result.setData(id);
        return result;
    }

}
