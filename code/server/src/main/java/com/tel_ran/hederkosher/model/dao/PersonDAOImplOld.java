package com.tel_ran.hederkosher.model.dao;

import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.service.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ruslan on 12.08.2016.
 */
public class PersonDAOImpl implements PersonDAO {

    @Override
    public void add(Person obj) throws SQLException {
        Session session =null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if ((session!=null) && (session.isOpen()))     session.close();
        }
    }

    @Override
    public void delete(Person obj) throws SQLException {
        Session session =null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if ((session!=null) && (session.isOpen()))     session.close();
        }

    }

    @Override
    public Person get(int id) throws SQLException {
        Person result = null;
        Session session =null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            result = (Person) session.get(Person.class,id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session!=null) && (session.isOpen()))     session.close();
        }
        return result;
    }

    @Override
    public List<Person> gets() throws SQLException {
        List<Person> list = null;

        Session session =null;
        try {
            session= HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Person.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session!=null) && (session.isOpen()))     session.close();
        }
        return list;
    }
}
