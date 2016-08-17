/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.dao;

import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.service.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDaoImpl1 implements PersonDao1 {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(Person obj) {
        if (null != obj) {
            sessionFactory.getCurrentSession().delete(obj);
        }
    }

    @Override
    public Person get ( int id){
        return (Person) sessionFactory.getCurrentSession().load(Person.class, id);
    }

    @Override
    public List<Person> gets () {
        return sessionFactory.getCurrentSession().createQuery("from Person")
                .list();
    }


    @Override
    @SuppressWarnings("unchecked")
    public void add (Person obj){
        if (null != obj) {
            sessionFactory.getCurrentSession().save(obj);
        }
    }
}