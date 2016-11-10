/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.PersonRoleDao;
import com.tel_ran.hederkosher.model.common.entity.PersonRole;
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

//@Service("personRoleDAOService")
public class PersonRoleDaoImpl implements PersonRoleDao {

    @Autowired
    private HibUtil hibernateUtil;
    public void setHibernateUtil(HibUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public boolean addPersonRole(PersonRole personRole) { //throws SQLException
        if (personRole == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
            session.save(personRole);
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean updatePersonRole(PersonRole personRole) {
        if (personRole == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
//            session.saveOrUpdate(person);
            session.update(personRole);
            session.getTransaction().commit();
        } catch (HibernateException e) {
    //            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deletePersonRole(PersonRole personRole)  { //throws SQLException
        if (personRole == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
            session.delete(personRole);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public PersonRole getById(long id) { //throws SQLException
        PersonRole result = null;
        try (Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            result = (PersonRole) session.get(PersonRole.class,id);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PersonRole getByName(String name) {
        PersonRole result = null;
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            Query query = session.createQuery("from person_role where name = :paramName");
            query.setParameter("paramName", name);
            result = (PersonRole)query.list();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<PersonRole> getAllPersonRoles(){
        List<PersonRole> result = null;
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            result = (List<PersonRole>)session.createQuery("FROM person_role").list();

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }


}

