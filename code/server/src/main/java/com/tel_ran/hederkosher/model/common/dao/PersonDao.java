/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    public boolean add(Person obj) throws SQLException;
    public boolean delete(Person obj) throws SQLException;
    public Person getById(long id) throws SQLException;
    public List<Person>  gets() throws SQLException;
}


