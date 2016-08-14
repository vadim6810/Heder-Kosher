package com.tel_ran.hederkosher.model.dao;

import com.tel_ran.hederkosher.model.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ruslan on 12.08.2016.
 */
public interface PersonDAO {
    public void add(Person obj) throws SQLException;
    public void delete(Person obj) throws SQLException;
    public Person get(int id) throws SQLException;
    public List<Person>  gets() throws SQLException;
}
