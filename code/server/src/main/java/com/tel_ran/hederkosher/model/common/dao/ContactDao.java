/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.entity.Contact;

import java.util.List;

//import java.sql.SQLException;

public interface ContactDao {
    boolean addContact(Contact obj);
    boolean updateContact(Contact obj);
    boolean deleteContact(long id);
    boolean deleteAllContacts();
    boolean deleteContactsByPerson(long personId);

    Contact getById(long id) throws TemplateNotFoundException;

    List<Contact>  getContactsByType(String type);
    List<Contact>  getContactsByPerson(long personId);
    List<Contact>  getAllContacts();
}

