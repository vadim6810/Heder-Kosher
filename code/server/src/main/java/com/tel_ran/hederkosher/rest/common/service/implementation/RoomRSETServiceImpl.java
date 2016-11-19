package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.IRoomDao;
import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.IRoomRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roomCRUDService")
public class RoomRSETServiceImpl implements IRoomRESTService {

    @Autowired
    private IRoomDao roomDao;

    private ServiceResult result;

    @Override
    public ServiceResult findRoomByID(long id) {
        Room room=null;
        try {
            room= roomDao.getById(id);
        } catch (TemplateNotFoundException e) {
            result = ServiceResultFactory.NOT_FOUND;
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
        result = ServiceResultFactory.OK;
        result.setData(roomDao.getByName(name));
        return result;
    }

    @Override
    public ServiceResult getAllRooms() {
        result = ServiceResultFactory.OK;
        result.setData(roomDao.getAllRooms());
        return result;
    }

    @Override
    public ServiceResult getAllRoomsActives() {
        result = ServiceResultFactory.OK;
        result.setData(roomDao.getAllRoomsActives());
        return result;
    }


    @Override
    public ServiceResult createRoom(Room room) {
        if (roomDao.addRoom(room)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.CREATING_ERROR;
        }
        result.setData(room);
        return result;
    }

    @Override
    public ServiceResult updateRoom(Room room) {
        if (roomDao.updateRoom(room)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.UPDATING_ERROR;
        }
        result.setData(room);
        return result;
    }

    @Override
    public ServiceResult deleteRoom(long id) {
        if (roomDao.deleteRoom(id)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.DELETING_ERROR;
        }
        result.setData(id);
        return result;
    }

}
