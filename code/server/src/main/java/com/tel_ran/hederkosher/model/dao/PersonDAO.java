package com.tel_ran.hederkosher.model.dao;

import com.tel_ran.hederkosher.model.Person;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ruslan on 12.08.2016.
 */
public interface PersonDAO {
    public void add(Person obj);
    public void delete(Person obj);
    public void delete(int id);
    public Person get(int id) ;
    public List<Person>  gets() ;
}
