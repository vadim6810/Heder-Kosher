package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.rest.ServiceResult;

public interface ProgramCRUDService {
    ServiceResult findProgamByID(long id);
    ServiceResult findCreatedPrograms(User user);
    ServiceResult findAssignedPrograms(User user);
    ServiceResult findAllPrograms();

    ServiceResult createProgram(Program program);
    ServiceResult updateProgram(Program program);
    ServiceResult deleteProgram(long id);

}
