package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Contact;
import com.tel_ran.hederkosher.rest.ServiceResult;

public interface ContactRESTService {
    ServiceResult findContactByID(long id);

    ServiceResult createContact(long idPerson, Contact contact);
    ServiceResult updateContact(Contact contact);
    ServiceResult deleteContact(long id);

    ServiceResult deleteAllContacts();
    ServiceResult getAllContacts();

    ServiceResult deleteContactsByPerson(long idPerson);
    ServiceResult getContactsByPerson(long id);

    ServiceResult getContactsByType(String type);

}
