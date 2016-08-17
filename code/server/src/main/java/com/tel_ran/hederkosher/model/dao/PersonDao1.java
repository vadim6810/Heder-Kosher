/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.dao;

import com.tel_ran.hederkosher.model.Person;

import java.util.List;

public interface PersonDao1 {
    public void add(Person obj);
    public void delete(Person obj);
    public Person get(int id) ;
    public List<Person> gets() ;
}

