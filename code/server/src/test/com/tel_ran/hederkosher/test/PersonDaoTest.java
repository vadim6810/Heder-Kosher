/**
 * Created by Ruslan on 08.08.2016.
 */
package com.tel_ran.hederkosher.test;

import com.tel_ran.hederkosher.model.dao.PersonDao1;
import com.tel_ran.hederkosher.model.dao.PersonDAOFactory;
import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.service.HibernateUtil;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;

public class PersonDaoTest {

    public static void main (String[] args) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        PersonDAOFactory factory= PersonDAOFactory.getInstance();
        PersonDao1 personDAO= factory.getPersonDAO();

        List<Person> persons = personDAO.gets();

        for (Person person  :persons) {
            System.out.println(person.getFistName());
        }

    }

}
