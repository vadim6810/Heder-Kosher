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

@Service("taskCRUDService")
public class TaskCRUDServiceImpl implements TaskCRUDService {

    @Autowired
    private TaskDao taskDao;

    private ServiceResult result;

    @Override
    public ServiceResult findTaskByID(long id) {
        Task task = taskDao.getTaskById(id);
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
    public ServiceResult findTasksByProgram(Program program) {
        result = ServiceResultFactory.OK;
        result.setData(taskDao.getTasksByProgram(program));
        return result;
    }

    @Override
    @Transactional
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
    @Transactional
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
    @Transactional
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
