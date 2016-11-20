package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.RoomDao;
import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.IRoomRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.*;

@Service("roomCRUDService")
public class RoomCRUDServiceImpl implements IRoomRESTService {

    @Autowired
    private RoomDao roomDao;

    private ServiceResult result;

    @Override
    public ServiceResult findRoomByID(long id) {
        Room room=null;
        try {
            room= roomDao.getById(id);
        } catch (TemplateNotFoundException e) {
            result = getResultObject(Type.NOT_FOUND);
            result.setData(id);
            result.setDescription(e.getMessage());
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(room);
        return result;
    }

    @Override
    public ServiceResult getByName(String name) {
        result = getResultObject(Type.OK);
        result.setData(roomDao.getByName(name));
        return result;
    }

    @Override
    public ServiceResult getAllRooms() {
        result = getResultObject(Type.OK);
        result.setData(roomDao.getAllRooms());
        return result;
    }

    @Override
    public ServiceResult getAllRoomsActives() {
        result = getResultObject(Type.OK);
        result.setData(roomDao.getAllRoomsActives());
        return result;
    }


    @Override
    public ServiceResult createRoom(Room room) {
        if (roomDao.addRoom(room)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(room);
        return result;
    }

    @Override
    public ServiceResult updateRoom(Room room) {
        if (roomDao.updateRoom(room)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.UPDATING_ERROR);
        }
        result.setData(room);
        return result;
    }

    @Override
    public ServiceResult deleteRoom(long id) {
        if (roomDao.deleteRoom(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(id);
        return result;
    }

}
