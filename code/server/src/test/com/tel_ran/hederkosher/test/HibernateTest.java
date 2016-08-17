package com.tel_ran.hederkosher.test;

/**
 * Created by user on 17.08.2016.
 */
import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.model.dao.PersonDao1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateTest {

    public static void main( String[] args )
    {
        SessionFactory sessionFactory;
        sessionFactory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Person person = new Person();
//        person.setIdPerson(new int(1));
        person.setFistName("Hello world task");
        person.setSecondname("Hello world task description");
        session.save(person);
        tx.commit();
        session.close();
    }
}