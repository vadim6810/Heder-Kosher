/**
 * Created by Ruslan on 30.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.entity.Room;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomDao {
        boolean addRoom(Room obj);

        @Transactional
        boolean updateRoom(Room obj);

        boolean deleteRoom(long id);
        boolean deleteAllRooms();
        Room getById(long id) throws TemplateNotFoundException;
        List<Room>  getByName(String name);
        List<Room> getAllRooms();
        List<Room> getAllRoomsActives();
}
