/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    boolean add(Person obj) throws SQLException;
    boolean delete(Person obj) throws SQLException;
    Person getById(long id) throws SQLException;
    List<Person>  gets() throws SQLException;
}


