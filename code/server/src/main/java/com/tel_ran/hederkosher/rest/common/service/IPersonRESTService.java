package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.rest.ServiceResult;

public interface IPersonRESTService {
    ServiceResult findPersonByID(long id);

    ServiceResult getByPassport(String passport);
    ServiceResult getPersonsByFio(String fistName,String secondName,String lastName);
    ServiceResult getByEmail(String email);
    ServiceResult getByTelephone(String telephone);
    ServiceResult getAllPersons();
//    ServiceResult getByRoom(long idRoom);

    ServiceResult createPerson(Person person);
    ServiceResult updatePerson(Person person);
    ServiceResult deletePerson(long id);
}
