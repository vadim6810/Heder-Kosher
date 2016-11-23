package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.api.entities.ProgramData;

public interface ProgramCRUDService {
    ServiceResult findProgamByID(long id);
    ServiceResult findCreatedPrograms(User user);
    ServiceResult findAssignedPrograms(User user);
    ServiceResult findAllPrograms();

    //ServiceResult createProgram(Program program);
    ServiceResult createProgram(ProgramData programData);
    ServiceResult updateProgram(Program program);
    ServiceResult deleteProgram(long id);

}
