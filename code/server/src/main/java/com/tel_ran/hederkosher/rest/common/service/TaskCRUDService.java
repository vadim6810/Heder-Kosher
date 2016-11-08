package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.common.entity.Task;
import com.tel_ran.hederkosher.rest.ServiceResult;

public interface TaskCRUDService {
    ServiceResult findTaskByID(long id);

    ServiceResult findTasksByProgram(Program program);

    ServiceResult findAllTasks();

    ServiceResult createTask(Task task);
    ServiceResult updateTask(Task task);
    ServiceResult deleteTask(long id);

}
