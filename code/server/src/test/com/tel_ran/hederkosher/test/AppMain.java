/**
 * Created by Ruslan on 18.08.2016.
 */
package com.tel_ran.hederkosher.test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

//import org.joda.time.LocalDate;
import com.tel_ran.hederkosher.model.security.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

//import com.tel_ran.hederkosher.configuration.AppConfig;
import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.service.PersonService;

public class AppMain {

    public static void main(String args[]) {
        //AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
        context.scan("com.tel_ran.hederkosher");
        context.refresh();

        PersonService service = (PersonService) context.getBean("personService");

        /*
         * Create Person
         */
        Person person1 = new Person();
        person1.setFistName("Иван");
        person1.setSecondname("Иванович");
        person1.setLastname("Иванов");
        person1.setBirthday(new Date(Calendar.DATE));
        //person1.setJoiningDate(new LocalDate(2010, 10, 10));
        //person1.setSecondname().setSalary(new BigDecimal(10000));
        person1.setPassportNo("PassportNo 1");
        person1.setUser(new User(1,"User1","User1", new Date(Calendar.DATE)));

        /*
         * Create Employee2
         */
        Person person2 = new Person();
        person1.setFistName("Петр");
        person1.setSecondname("Петрович");
        person1.setLastname("Петров");
        person1.setBirthday(new Date(Calendar.DATE));
        //person1.setJoiningDate(new LocalDate(2010, 10, 10));
        //person1.setSecondname().setSalary(new BigDecimal(10000));
        person1.setPassportNo("PassportNo 2");
        person1.setUser(new User(2,"User2","User2", new Date(Calendar.DATE)));

        /*
         * Persist both Employees
         */
        service.savePerson(person1);
        service.savePerson(person2);

        /*
         * Get all employees list from database
         */
        List<Person> persons = service.findAllPersons();
        for (Person emp : persons) {
            System.out.println(emp);
        }

        /*
         * delete an person
         */
        //service.deletePersonBySsn("ssn00000002");

        /*
         * update an employee
         */

        Person person = service.findBySsn("ssn00000001");
        person.setFistName("Сидор");
        service.updatePerson(person);

        /*
         * Get all employees list from database
         */
        List<Person> personList = service.findAllPersons();
        for (Person emp : personList) {
            System.out.println(emp);
        }

        context.close();
    }
}