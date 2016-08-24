/**
 * Created by Ruslan on 08.08.2016.
 */
package com.tel_ran.hederkosher.test;


import com.tel_ran.hederkosher.model.common.dao.implementation.*;
import com.tel_ran.hederkosher.model.common.dao.*;
import com.tel_ran.hederkosher.model.common.entity.*;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.service.HibUtil;
import com.tel_ran.hederkosher.service.HibUtilImpl;
import com.tel_ran.hederkosher.service.Loggers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
//import java.sql.SQLException;


public class PersonDaoTest {

    public static void main (String[] args) {
        Logger logger = Loggers.hiberLogger;
        logger.info("Start ");

        PersonDaoImpl personDao =new PersonDaoImpl() ;
        Person person ;

        person = new Person("12312312312","Sidorov", "Ivan", "Petrovich", new Date(), new User());

        boolean res= personDao.addPerson(person);


//        System.out.println(person.toString());

//        person.setFistName("Ivanov");
//        person.setBirthday(new Date());
//        person.setPassportNo("232313213");


        logger.info("End ");
//        List<Person> persons = session.PersonDao.gets();

//        for (Person person  :persons) {
//            System.out.println(person.getFistName());
//        }

    }

}
