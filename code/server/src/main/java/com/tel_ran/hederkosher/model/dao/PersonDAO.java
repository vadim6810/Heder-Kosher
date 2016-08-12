package com.tel_ran.hederkosher.model.dao;

import com.tel_ran.hederkosher.model.entity.PersonEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Ruslan on 12.08.2016.
 */
public interface PersonDAO {
    public void add(PersonEntity obj) throws SQLException;
    public void delete(PersonEntity obj) throws SQLException;
    public PersonEntity get(int id) throws SQLException;
    public List<PersonEntity>  gets() throws SQLException;
}
