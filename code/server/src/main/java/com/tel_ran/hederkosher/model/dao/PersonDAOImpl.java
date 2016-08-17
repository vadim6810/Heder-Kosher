/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.dao;

import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.service.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Person obj) {
        if (null != obj) {
        sessionFactory.getCurrentSession().save(obj);
    }

    @Override
    public void delete(Person obj) {
         if (null != obj) {
            sessionFactory.getCurrentSession().delete(obj);
    }

    @Override
    public void delete(int obj) {
        Person person = get(obj);
        if (null != person) {
            sessionFactory.getCurrentSession().delete(person);
        }
    }

    @Override
    public Person get(int id) {
        return (Person) sessionFactory.getCurrentSession().load(Person.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> gets() {
                return sessionFactory.getCurrentSession().createQuery("from Person")
                        .list();
            }
}
