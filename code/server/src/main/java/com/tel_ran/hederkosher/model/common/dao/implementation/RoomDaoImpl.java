/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.RoomDao;
import com.tel_ran.hederkosher.model.common.entity.Room;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoomDaoImpl implements RoomDao {

    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;

    public RoomDaoImpl() {
    }

    @Override
    @Transactional
    public boolean addRoom(Room room) {
        if ((room==null) || (em.find(Room.class,room.getId())!=null))
            return false;
        em.persist(room);
        return true;
    }

    @Override
    @Transactional
    public boolean updateRoom(Room room) {
//        Room roomCurrent=null;
//        if ((room==null) || ((roomCurrent=em.find(Room.class,room.getId()))==null))
        if ((room==null) || (em.find(Room.class,room.getId())==null))
            return false;

        em.merge(room);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteRoom(long id)  {
        Room room =em.find(Room.class,id);
            if (room==null)
                return false;
            em.remove(room);
            return true;
        }

    @Override
    public Room getById(long id) throws TemplateNotFoundException {
        Room room = em.find(Room.class,id);
        if (room==null)
            throw new TemplateNotFoundException("Room",id);
        return room;
    }

    @Override
    public List<Room> getByName(String name) {
        List<Room> rooms=null;

        if (name!=null)
            try{
                rooms = (List<Room>) em.createQuery("SELECT p FROM Room p WHERE name = :name")
                        .setParameter("name", name)
                        .getResultList();
            } catch (Exception e){
            }
        return rooms;
    }

    @Override
    public List<Room> getAllRooms(){
        List<Room> rooms=null;

        try{
            rooms = (List<Room>) em.createQuery("SELECT p FROM Room p")
                    .getResultList();
        } catch (Exception e){
        }

        return rooms;
    }

    @Override
    public List<Room> getAllRoomsActives() {
        List<Room> rooms=null;

        try{
            rooms = (List<Room>) em.createQuery("SELECT p FROM Room p where isEnable = true ")
                    .getResultList();
        } catch (Exception e){
        }

        return rooms;
    }

    @Override
    @Transactional
    public boolean deleteAllRooms()  {
        try{
            List<Room> rooms = (List<Room>) em.createQuery("SELECT p FROM Room p")
                    .getResultList();
            for (Room room: rooms) {
                em.remove(room);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }


}

