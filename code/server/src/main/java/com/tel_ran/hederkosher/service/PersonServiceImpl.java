/**
 * Created by Ruslan on 15.08.2016.
 */
package com.tel_ran.hederkosher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tel_ran.hederkosher.model.Person;
import com.tel_ran.hederkosher.model.dao.PersonDao;

@Transactional
@Service("personService")
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonDao dao;

    public void savePerson(Person person) {
        dao.savePerson(person);
    }

    public List<Person> findAllPersons() {
        return dao.findAllPersons();
    }

//    public void deletePersonById(int IdPeson) {
//        dao.deletePersonBySsn(person);
//    }
    public void deletePerson(Person person) {
        dao.deletePerson(person);
    }

    public Person findBySsn(String ssn) {
        return dao.findBySsn(ssn);
    }

    public void updatePerson(Person person){
        dao.updatePerson(person);
    }
}