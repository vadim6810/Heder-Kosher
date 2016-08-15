package com.tel_ran.hederkosher.model.dao;

/**
 * Created by Ruslan on 12.08.2016.
 */
public class PersonDAOFactory {
    public static PersonDAOFactory instance = new PersonDAOFactory();
    public PersonDAO factory;

    private PersonDAOFactory(){}

    public static PersonDAOFactory getInstance(){
        return PersonDAOFactory.instance;
    }
    public PersonDAO getPersonDAO(){
        if (factory== null) factory= new PersonDAOImpl();
        return factory;
    }





}
