package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.model.common.dao.TaskDao;
import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.common.entity.Task;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.TaskCRUDService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.*;

@Service
public class TaskCRUDServiceImpl implements TaskCRUDService {

    //@Autowired
    private TaskDao taskDao;

    public TaskCRUDServiceImpl(TaskDao aTaskDao) {
        this.taskDao = aTaskDao;
    }

    @Override
    public ServiceResult findTaskByID(long id) {
        final Task task = taskDao.getTaskById(id);
        final ServiceResult result;
        if (task == null) {
            result = getResultObject(Type.NOT_FOUND);
            result.setData(id);
            result.setDescription("task with id = " + id + " not found");
            return result;
        }
        result = getResultObject(Type.OK);
        result.setData(task);
        return result;
    }

    @Override
    public ServiceResult findAllTasks() {
        final ServiceResult result = getResultObject(Type.OK); //ServiceResultFactory.OK;
        result.setData(taskDao.getAllTasks());
        return result;
    }

    @Override
    public ServiceResult findTasksByProgram(Program program) {
        final ServiceResult result = getResultObject(Type.OK);
        result.setData(taskDao.getTasksByProgram(program));
        return result;
    }

    @Override
    @Transactional
    public ServiceResult createTask(Task task) {
        final ServiceResult result;
        if (taskDao.addTask(task)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(task);
        return result;
    }

    @Override
    @Transactional
    public ServiceResult updateTask(Task task) {
//        ProgramState currentState = stateDao.getById(state.getId());
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
        final ServiceResult result = getResultObject(Type.UPDATING_ERROR);
        //}
        //result.setData(currentState);
        return result;
    }

    @Override
    @Transactional
    public ServiceResult deleteTask(long id) {
        final ServiceResult result;
        if (taskDao.deleteTask(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(id);
        return result;
    }

}
