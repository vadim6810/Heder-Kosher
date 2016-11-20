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
    Contact getById(long id) throws TemplateNotFoundException;
    List<Contact>  getByEmail(String email);
    List<Contact>  getByTelephone(String telephone);
    List<Contact>  getAllContacts();
    List<Contact>  getContactsByPerson(long personId);

}

