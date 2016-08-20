/**
 * Created by Ruslan on 15.08.2016.
 */
package com.tel_ran.hederkosher.service;

import java.util.List;

import com.tel_ran.hederkosher.model.Person;

public interface PersonService {

    void savePerson(Person person);

    List<Person> findAllPersons();

//    void deletePersonBySsn(String ssn);
    void deletePerson(Person person);

    Person findBySsn(String ssn);

    void updatePerson(Person person);
}