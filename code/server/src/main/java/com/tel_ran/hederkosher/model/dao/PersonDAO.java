/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.dao;

import com.tel_ran.hederkosher.model.Person;
import java.util.List;

public interface PersonDao {
    void savePerson(Person person);

    List<Person> findAllPersons();

    void deletePerson(Person person);
//    void deletePersonBySsn(String ssn);

    Person findBySsn(String ssn);

    void updatePerson(Person person);

}
