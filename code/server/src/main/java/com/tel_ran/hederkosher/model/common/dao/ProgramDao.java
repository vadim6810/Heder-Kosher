package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.security.entity.User;

import java.util.List;

public interface ProgramDao {
    boolean addProgram(Program program);
    boolean updateProgram(Program program);
    boolean deleteProgram(long id);

    Program getProgramById(long id);
    List<Program> getAllPrograms();
    List<Program> getCreatedPrograms(long userId);
    List<Program> getAssignedPrograms(long userId);
}
