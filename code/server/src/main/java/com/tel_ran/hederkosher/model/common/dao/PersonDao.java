/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.model.common.entity.Room;

//import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

public interface PersonDao {
    boolean addPerson(Person obj);
    boolean updatePerson(Person obj);
    boolean deletePerson(Person obj);
    Person getById(long id);
    Person getByPassport(String passport);
    Person getByEmail(String email);
    Person getByTelephone(String telephone);
    List<Person>  getAllPersons();
    List<Person>  getPersonsByFio(String fistName,String secondName,String lastName);
    List<Person>  getPersonsByRoom(Room room);
    List<Person>  getPersons(Predicate predicate);
}

