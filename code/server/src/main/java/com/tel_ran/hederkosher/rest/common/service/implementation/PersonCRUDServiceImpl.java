package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.PersonDao;
import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.common.service.PersonRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.Type;
import static com.tel_ran.hederkosher.rest.ServiceResultFactory.getResultObject;

@Service("personCRUDService")
public class PersonCRUDServiceImpl implements PersonRESTService {

    @Autowired
    private PersonDao personDao;

    private ServiceResult result;

    @Override
    public ServiceResult findPersonByID(long id) {
        Person person=null;
        try {
            person= personDao.getById(id);
        } catch (TemplateNotFoundException e) {
            result = getResultObject(Type.NOT_FOUND);
            result.setData(id);
            result.setDescription(e.getMessage());
            return result;
        }
        result = getResultObject(Type.OK);//        result = ServiceResultFactory.OK;
        result.setData(person);
        return result;
    }

    @Override
    public ServiceResult getByPassport(String passport) {
        result = getResultObject(Type.OK);
        result.setData(personDao.getByPassport(passport));
        return result;
    }

    @Override
    public ServiceResult getPersonsByFio(String fistName, String secondName, String lastName) {
        result = getResultObject(Type.OK);
        result.setData(personDao.getPersonsByFio(fistName,secondName,lastName));
        return result;
    }

    @Override
    public ServiceResult getByEmail(String email) {
        result = getResultObject(Type.OK);
        result.setData(personDao.getByEmail(email));
        return result;
    }

    @Override
    public ServiceResult getByTelephone(String telephone) {
        result = getResultObject(Type.OK);
        result.setData(personDao.getByTelephone(telephone));
        return result;
    }

    @Override
    public ServiceResult getAllPersons() {
        result = getResultObject(Type.OK);
        result.setData(personDao.getAllPersons());
        return result;
    }

//    @Override
//    public ServiceResult getByRoom(long idRoom) {
//        result = ServiceResultFactory.OK;
//        result.setData(personDao.getPersonsByRoom(idRoom));
//        return result;
//    }

    @Override
    public ServiceResult createPerson(Person person) {
        if (personDao.addPerson(person)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(person);
        return result;
    }

    @Override
    public ServiceResult updatePerson(Person person) {
        if (personDao.updatePerson(person)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.UPDATING_ERROR);
        }
        result.setData(person);
        return result;
    }

    @Override
    public ServiceResult deletePerson(long id) {
        if (personDao.deletePerson(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(id);
        return result;
    }

    @Override
    public ServiceResult deleteAllPersons() {
        if (personDao.deleteAllPersons()) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
//        result.setData();
        return result;
    }

}
