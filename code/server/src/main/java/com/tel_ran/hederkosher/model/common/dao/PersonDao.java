/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.exception.PersonNotFoundException;
import com.tel_ran.hederkosher.model.common.entity.Person;

import java.util.List;

//import java.sql.SQLException;

public interface PersonDao {
    boolean addPerson(Person obj);
    boolean updatePerson(Person obj);
    boolean deletePerson(long id);
    Person getById(long id) throws PersonNotFoundException;
    Person getByPassport(String passport);
    Person getByEmail(String email);
    Person getByTelephone(String telephone);
    List<Person>  getAllPersons();
    List<Person>  getPersonsByFio(String fistName,String secondName,String lastName);
    List<Person>  getPersons(String jpql);
//    List<Person>  getPersonsByRoom(Room room);
//    List<Person> getPersons(Predicate predicate);
}

