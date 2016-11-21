package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.rest.ServiceResult;

public interface RoomRESTService {
    ServiceResult createRoom(Room person);
    ServiceResult updateRoom(Room person);
    ServiceResult deleteRoom(long id);
    ServiceResult deleteAllRooms();

    ServiceResult findRoomByID(long id);

    ServiceResult getByName(String name);
    ServiceResult getAllRooms();
    ServiceResult getAllRoomsActives();

}
