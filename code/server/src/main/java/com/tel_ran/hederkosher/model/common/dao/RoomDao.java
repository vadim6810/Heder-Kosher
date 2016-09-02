/**
 * Created by Ruslan on 30.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.Room;

import java.util.List;

public interface RoomDao {
        boolean addRoom(Room obj);
        boolean updateRoom(Room obj);
        boolean deleteRoom(Room obj);
        Room getById(long id);
        Room getByName(String name);
        List<Room> getAllRooms();
}
