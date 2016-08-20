/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.model.common.dao.PersonDao;
import com.tel_ran.hederkosher.service.HibUtil;
//import com.tel_ran.hederkosher.service.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service("personDao")
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private HibUtil hibernateUtil;

    public void setHibernateUtil(HibUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public boolean add(Person person) throws SQLException {
        if (person == null){
            //throw new NullPointerException();
            return false;
        }
        try {
            Session session= hibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Person person) throws SQLException {
        if (person == null){
            //throw new NullPointerException();
            return false;
        }
        try {
            Session session= hibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Person getById(long id) throws SQLException {
        Person result = null;
        try {
            Session session= hibernateUtil.getSessionFactory().openSession();
            result = (Person) session.get(Person.class,id);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Person> gets() throws SQLException {
        List<Person> result = null;
        try {
            Session session= hibernateUtil.getSessionFactory().openSession();
            result = (List<Person>)session.createQuery("FROM Person").list();

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }
}

