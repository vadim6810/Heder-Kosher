/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.RoomDao;
import com.tel_ran.hederkosher.model.common.entity.Contact;
import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.service.HibUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

//import java.sql.SQLException;

//@Service("roomDAOService")
public class RoomDaoImpl implements RoomDao {

    @Autowired
    private HibUtil hibernateUtil;
    public void setHibernateUtil(HibUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public boolean addRoom(Room room) { //throws SQLException
        if (room == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
            session.save(room);
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean updateRoom(Room room) {
        if (room == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
//            session.saveOrUpdate(person);
            session.update(room);
            session.getTransaction().commit();
        } catch (HibernateException e) {
    //            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteRoom(Room room)  { //throws SQLException
        if (room == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
            session.delete(room);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Room getById(long id) { //throws SQLException
        Room result = null;
        try (Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            result = (Room) session.get(Room.class,id);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Room getByName(String name) {
        Room result = null;
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            Query query = session.createQuery("from room where name = :paramName");
            query.setParameter("paramName", name);
            result = (Room)query.list();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Room> getAllRooms(){
        List<Room> result = null;
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            result = (List<Room>)session.createQuery("FROM room").list();

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }


}

