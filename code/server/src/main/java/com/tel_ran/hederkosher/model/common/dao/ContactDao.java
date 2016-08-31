/**
 * Created by Ruslan on 12.08.2016.
 */
package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.Contact;
import com.tel_ran.hederkosher.model.common.entity.Person;

import java.util.List;
import java.util.function.Predicate;

//import java.sql.SQLException;

public interface ContactDao {
    boolean addContact(Contact obj);
    boolean updateContact(Contact obj);
    boolean deleteContact(Contact obj);
    Contact getById(long id);
    Contact getByEmail(String email);
    Contact getByTelephone(String telephone);
    List<Contact>  getAllContacts();
    List<Contact>  getContacts(Predicate predicate);
    List<Contact>  getContactsByPerson(Person person);

}

