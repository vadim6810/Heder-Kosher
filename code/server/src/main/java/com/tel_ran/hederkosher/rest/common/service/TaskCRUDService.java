package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.common.entity.Task;
import com.tel_ran.hederkosher.rest.ServiceResult;

/**
 * Created by Egor on 22.08.2016.
 */

public interface TaskCRUDService {
    ServiceResult findByID(long id);

    ServiceResult findByProgram(Program program);

    ServiceResult findAllTasks();

    ServiceResult createTask(Task task);
    ServiceResult updateTask(Task task);
    ServiceResult deleteTask(long id);

}
