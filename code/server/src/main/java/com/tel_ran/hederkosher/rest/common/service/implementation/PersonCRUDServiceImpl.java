package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.PersonNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.PersonDao;
import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.PersonCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personCRUDService")
public class PersonCRUDServiceImpl implements PersonCRUDService {

    @Autowired
    private PersonDao personDao;

    private ServiceResult result;

    @Override
    public ServiceResult findPersonByID(long id) {
        Person person=null;
        try {
            person= personDao.getById(id);
        } catch (PersonNotFoundException e) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(id);
            result.setDescription(e.getMessage());
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(person);
        return result;
    }

    @Override
    public ServiceResult getByPassport(String passport) {
        result = ServiceResultFactory.OK;
        result.setData(personDao.getByPassport(passport));
        return result;
    }

    @Override
    public ServiceResult getPersonsByFio(String fistName, String secondName, String lastName) {
        result = ServiceResultFactory.OK;
        result.setData(personDao.getPersonsByFio(fistName,secondName,lastName));
        return result;
    }

    @Override
    public ServiceResult getByEmail(String email) {
        result = ServiceResultFactory.OK;
        result.setData(personDao.getByEmail(email));
        return result;
    }

    @Override
    public ServiceResult getByTelephone(String telephone) {
        result = ServiceResultFactory.OK;
        result.setData(personDao.getByTelephone(telephone));
        return result;
    }

    @Override
    public ServiceResult getAllPersons() {
        result = ServiceResultFactory.OK;
        result.setData(personDao.getAllPersons());
        return result;
    }

    @Override
    public ServiceResult createPerson(Person person) {
        if (personDao.addPerson(person)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.CREATING_ERROR;
        }
        result.setData(person);
        return result;
    }

    @Override
    public ServiceResult updatePerson(Person person) {
        if (personDao.updatePerson(person)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.UPDATING_ERROR;
        }
        result.setData(person);
        return result;
    }

    @Override
    public ServiceResult deletePerson(long id) {
        if (personDao.deletePerson(id)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.DELETING_ERROR;
        }
        result.setData(id);
        return result;
    }

}
