/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.ContactDao;
import com.tel_ran.hederkosher.model.common.entity.Contact;
import com.tel_ran.hederkosher.model.common.entity.ContactType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {

    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;

    public ContactDaoImpl() {
    }

    @Override
    public Contact getById(long id) throws TemplateNotFoundException {
        Contact contact = em.find(Contact.class,id);
        if (contact==null)
            throw new TemplateNotFoundException("Contact",id);
        return contact;
    }

    @Override
    @Transactional
    public boolean addContact(Contact contact) {
        if ((contact==null) || (em.find(Contact.class,contact.getId())!=null))
            return false;
        em.persist(contact);
        return true;
    }

    @Override
    @Transactional
    public boolean updateContact(Contact contact) {
        Contact contactCurrent= null;
        if ((contact==null) || ((contactCurrent=em.find(Contact.class,contact.getId()))==null))
            return false;
        em.refresh(contactCurrent);
        contact.setPerson(contactCurrent.getPerson());
        em.merge(contact);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteContact(long id) {
        Contact contact =null; //em.find(Contact.class,id);
        try {
            contact = getById(id);
            em.remove(contact);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<Contact> getAllContacts(){
        List<Contact> contacts=null;
        try{
            contacts = (List<Contact>) em.createQuery("SELECT p FROM Contact p")
                    .getResultList();
        } catch (Exception e){
        }
        return contacts;
    }
    @Override
    @Transactional
    public boolean deleteAllContacts(){
        List<Contact> contacts = getAllContacts();
        if (contacts == null) return false;
        try{
            for (Contact contact : contacts) {
                em.remove(contact);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }


    @Override
    public List<Contact> getContactsByPerson(long personId) {
        List<Contact> contacts=null;
        try{
            contacts = (List<Contact>) em.createQuery("SELECT c FROM Contact c join c.person p WHERE p.id = :personId")
                    .setParameter("personId", personId)
                    .getResultList();
        } catch (Exception e){
        }
        return contacts;
    }
    @Override
    @Transactional
    public boolean deleteContactsByPerson(long personId) {
        List<Contact> contacts = getContactsByPerson(personId);
        if (contacts == null) return false;
        try{
            for (Contact contact : contacts) {
                em.remove(contact);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }


    @Override
    public List<Contact> getContactsByType(String type) {
        List<Contact> contacts=null;
        if (type!=null && ContactType.valueOf(type)!=null)
            try{
                contacts = (List<Contact>) em.createQuery("SELECT p FROM Contact p WHERE type = :type")
                        .setParameter("type", type)
                        .getResultList();
            } catch (Exception e){
            }
        return contacts;
    }

}

