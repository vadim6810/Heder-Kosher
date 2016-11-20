package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.model.common.dao.ProgramDao;
import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.ProgramCRUDService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.Type;
import static com.tel_ran.hederkosher.rest.ServiceResultFactory.getResultObject;

@Service
public class ProgramCRUDServiceImpl implements ProgramCRUDService {

    //@Autowired
    private ProgramDao programDao;

    public ProgramCRUDServiceImpl(ProgramDao aProgramDao) {
        this.programDao = aProgramDao;
    }

    @Override
    public ServiceResult findProgamByID(long id) {
        final Program program = programDao.getProgramById(id);
        final ServiceResult result;
        if (program == null) {
            result = getResultObject(Type.NOT_FOUND);
            result.setData(id);
            result.setDescription("program with id = " + id + " not found");
            return result;
        }
        result = getResultObject(Type.OK);
        result.setData(program);
        return result;
    }

    @Override
    public ServiceResult findCreatedPrograms(User user) {
        return null; //TODO
    }

    @Override
    public ServiceResult findAssignedPrograms(User user) {
        return null; //TODO
    }

    @Override
    public ServiceResult findAllPrograms() {
        final ServiceResult result = getResultObject(Type.OK);
        result.setData(programDao.getAllPrograms());
        return result;
    }

    @Override
    @Transactional
    public ServiceResult createProgram(Program program) {
        final ServiceResult result;
        if (programDao.addProgram(program)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(program);
        return result;
    }

    @Override
    @Transactional
    public ServiceResult updateProgram(Program program) {
        return null; //TODO
    }

    @Override
    @Transactional
    public ServiceResult deleteProgram(long id) {
        final ServiceResult result;
        if (programDao.deleteProgram(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(id);
        return result;
    }

}
