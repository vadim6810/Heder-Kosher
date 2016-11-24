package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.RoomDao;
import com.tel_ran.hederkosher.model.common.dao.ProgramDao;
import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.model.security.dao.UserDAO;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.api.entities.ProgramData;
import com.tel_ran.hederkosher.rest.common.service.ProgramCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.Type;
import static com.tel_ran.hederkosher.rest.ServiceResultFactory.getResultObject;
import static com.tel_ran.hederkosher.service.Loggers.restLogger;

@Service
public class ProgramCRUDServiceImpl implements ProgramCRUDService {

    //@Autowired
    private ProgramDao programDao;

    //@Autowired
    private UserDAO userDAO;

    //@Autowired
    private RoomDao roomDao;


    public ProgramCRUDServiceImpl(ProgramDao aProgramDao, UserDAO aUserDao, RoomDao aRoomDao) {
        this.programDao = aProgramDao;
        this.userDAO = aUserDao;
        this.roomDao = aRoomDao;
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
    public ServiceResult createProgram(ProgramData programData) {
        ServiceResult result = getResultObject(Type.OK);
        try {
            final String sDateCreate = programData.getDateCreate();
            final String sDateClose = programData.getDateClose();

            final LocalDateTime dateCreate;
            final LocalDateTime dateClose;
            try {
                dateCreate = (sDateCreate == null) ? LocalDateTime.now() : LocalDateTime.parse(sDateCreate);
                dateClose = (sDateClose == null) ? null : LocalDateTime.parse(sDateClose);
            } catch (Exception e) {
                throw new IllegalArgumentException("Wrong date-time format");
            }

            final Long creatorId = programData.getCreatorId();
            if (creatorId == null) {
                throw new IllegalArgumentException("Creator Id field required");
            }
            final User creator = userDAO.findByID(creatorId);
            if (creator == null) {
                throw new IllegalArgumentException("Wrong creator id = " + creatorId);
            }

            final Long roomId = programData.getRoomId();
            if (roomId == null) {
                throw new IllegalArgumentException("Room Id field required");
            }
            Room room;
            try {
                room = roomDao.getById(roomId);
            } catch (TemplateNotFoundException e) {
                throw new IllegalArgumentException("Wrong room id = " + roomId);
            }

            final Program program = new Program(
                    programData.getName(),
                    programData.getDescription(),
                    dateCreate,
                    dateClose,
                    programData.isTemplate(),
                    creator,
                    room
            );

            if (!programDao.addProgram(program)) {
                throw new IllegalArgumentException("Program has not created!");
            }
            result.setData(program);
        } catch (IllegalArgumentException e) {
            restLogger.error("Wrong create program request", e.getMessage());
            result = getResultObject(Type.CREATING_ERROR);
            result.setData(e.getMessage());
        } catch (Exception e) {
            restLogger.error("Internal Error", e);
            result = getResultObject(Type.SERVER_ERROR);
            result.setData("Contact the service support");
        }
        return result;
    }
    /*public ServiceResult createProgram(Program program) {
        final ServiceResult result;
        if (programDao.addProgram(program)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(program);
        return result;
    }*/

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
