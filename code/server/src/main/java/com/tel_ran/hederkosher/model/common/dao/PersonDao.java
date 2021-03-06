/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.entity.Address;
import com.tel_ran.hederkosher.model.common.entity.Person;

import java.util.List;

public interface PersonDao {
    boolean addPerson(Person obj);
    boolean updatePerson(Person obj);
    boolean deletePerson(long id);
    Person getById(long id) throws TemplateNotFoundException;
    List<Person> getByPassport(String passport);
    List<Person> getByEmail(String email);
    List<Person> getByTelephone(String telephone);
    List<Person>  getPersonsByFio(String fistName,String secondName,String lastName);

    List<Person>  getAllPersons();
    boolean deleteAllPersons();
//    List<Person>  getPersonsByRoom(long idRoom);


    boolean addAddressByPerson(long personId, Address address);

}

