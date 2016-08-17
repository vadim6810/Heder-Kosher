package com.tel_ran.hederkosher.model.dao;

/**
 * Created by Ruslan on 12.08.2016.
 */
public class PersonDAOFactory {
    public static PersonDAOFactory instance = new PersonDAOFactory();
    public PersonDao1 factory;

    private PersonDAOFactory(){}

    public static PersonDAOFactory getInstance(){
        return PersonDAOFactory.instance;
    }
    public PersonDao1 getPersonDAO(){
//        if (factory== null) factory= new PersonDaoImpl1();
//        return factory;
return null;
    }





}
