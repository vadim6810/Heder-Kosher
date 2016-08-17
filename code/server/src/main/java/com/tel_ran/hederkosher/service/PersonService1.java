/**
 * Created by Ruslan on 15.08.2016.
 */
package com.tel_ran.hederkosher.service;

import java.util.List;

import com.tel_ran.hederkosher.model.dao.PersonDao1;
import org.apache.commons.logging.impl.Log4JLogger;
import com.tel_ran.hederkosher.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Service for processing Persons
 *
 */
@Service("personService")
@Transactional
public class PersonService1 {

    @Autowired
    private PersonDao1 personDao;

    public void addPerson(Person person) {
        personDao.add(person);
    }

    public List<Person> listPerson() {

        return personDao.gets();
    }

    public void removePerson(Person person) {
        personDao.delete(person);
    }
    public void removePerson(int  personId) {
        personDao.delete(personDao.get(personId));
    }

}