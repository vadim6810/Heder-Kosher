/**
 * Created by Ruslan on 16.08.2016.
 */
package com.tel_ran.hederkosher.test;

import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.service.PersonService1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringHibernateSessionFactoryAnnotation {

    public static void main(String[] args) {
        System.out.println("************** BEGINNING PROGRAM **************");

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        PersonService1 personService = (PersonService1) context.getBean("personService");

        Person person = new Person();
        person.setFistName("Alba");
        person.setFistName("Иванов");
        personService.addPerson(person);
        System.out.println("Person : " + person + " added successfully");

        //List<Person> persons = personService.fetchAllPersons();
        //System.out.println("The list of all persons = " + persons);

        System.out.println("************** ENDING PROGRAM *****************");
    }
}
