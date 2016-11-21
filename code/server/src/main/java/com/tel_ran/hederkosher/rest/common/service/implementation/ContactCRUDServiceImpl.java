package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.ContactDao;
import com.tel_ran.hederkosher.model.common.dao.PersonDao;
import com.tel_ran.hederkosher.model.common.entity.Contact;
import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.ContactRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.Type;
import static com.tel_ran.hederkosher.rest.ServiceResultFactory.getResultObject;

@Service("contactCRUDService")
public class ContactCRUDServiceImpl implements ContactRESTService{

    @Autowired
    private ContactDao contactDao;

    @Autowired
    private PersonDao personDao;

    private ServiceResult result;

    @Override
    public ServiceResult findContactByID(long id) {
        Contact contact=null;
        try {
            contact= contactDao.getById(id);
        } catch (TemplateNotFoundException e) {
            result = getResultObject(Type.NOT_FOUND);
            result.setData(id);
            result.setDescription(e.getMessage());
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(contact);
        return result;
    }

    @Override
    public ServiceResult updateContact(Contact contact) {
        if (contactDao.updateContact(contact)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.UPDATING_ERROR);
        }
        result.setData(contact);
        return result;
    }

    @Override
    public ServiceResult deleteContact(long id) {
        if (contactDao.deleteContact(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(id);
        return result;
    }

    @Override
    public ServiceResult deleteAllContacts() {
        if (contactDao.deleteAllContacts()) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
//        result.setData();
        return result;
    }

    @Override
    public ServiceResult createContact(long idPerson, Contact contact) {
        Person person = null;
        try {
            if (contact==null || ((person=personDao.getById(idPerson))==null))
                result = getResultObject(Type.CREATING_ERROR);
            else {
                contact.setPerson(person);
                if (contactDao.addContact(contact)) {
                    result = getResultObject(Type.OK);
                } else {
                    result = getResultObject(Type.CREATING_ERROR);
                }
            }
        } catch (TemplateNotFoundException e) {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(contact);
        return result;
    }
    @Override
    public ServiceResult getAllContacts() {
        result = getResultObject(Type.OK);
        result.setData(contactDao.getAllContacts());
        return result;
    }

    @Override
    public ServiceResult deleteContactsByPerson(long id) {
        if (contactDao.deleteContactsByPerson(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
//        result.setData();
        return result;
    }

    @Override
    public ServiceResult getContactsByPerson(long id) {
        result = getResultObject(Type.OK);
        result.setData(contactDao.getContactsByPerson(id));
        return result;
    }

    @Override
    public ServiceResult getContactsByType(String type) {
        result = getResultObject(Type.OK);
        result.setData(contactDao.getContactsByType(type));
        return result;
    }


}
