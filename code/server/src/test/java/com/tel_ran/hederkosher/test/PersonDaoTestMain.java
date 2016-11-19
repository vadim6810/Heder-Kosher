/**
 * Created by Ruslan on 08.08.2016.
 */
package com.tel_ran.hederkosher.test;


import com.tel_ran.hederkosher.model.common.dao.IPersonDao;
import com.tel_ran.hederkosher.model.common.entity.Person;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;
//import java.sql.SQLException;


public class PersonDaoTestMain {

    public static void main (String[] args) {
//        Logger logger = Loggers.daoLogger;
//        logger.info("Start ");

            try(AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:beans.xml")) {

//            System.out.println(Arrays.deepToString(ctx.getBeanDefinitionNames()));
//                IPersonDao personDao = (IPersonDao) ctx.getBean("personDaoImpl");
                IPersonDao personDao = ctx.getBean(IPersonDao.class);

                Person person = new Person("12312312312","Sidorov", "Ivan", "Petrovich", new Date(), null);
                boolean res= personDao.addPerson(person);
                System.out.println("res " + res);

//            System.out.println(personDao);

//
//
//            boolean res= personDao.addPerson(person);
//
                }
    }

//        logger.info("End ");
//        List<Person> persons = session.IPersonDao.gets();

//        for (Person person  :persons) {
//            System.out.println(person.getFistName());
//        }


}
