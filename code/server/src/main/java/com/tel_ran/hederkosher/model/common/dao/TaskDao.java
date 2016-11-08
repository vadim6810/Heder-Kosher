package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.common.entity.Task;

import java.util.List;

public interface TaskDao {
    boolean addTask(Task task);
    boolean updateTask(Task task);
    boolean deleteTask(long id);

    Task getTaskById(long id);
    List<Task> getAllTasks();
    List<Task> getTasksByProgram(Program program);
}
