/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.IContactDao;
import com.tel_ran.hederkosher.model.common.entity.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContactDaoImpl implements IContactDao {

    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;

    public ContactDaoImpl() {
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
        if ((contact==null) || (em.find(Contact.class,contact.getId())==null))
            return false;

        em.persist(contact);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteContact(long id)  {
        Contact contact =em.find(Contact.class,id);
        if (contact==null)
            return false;
        em.remove(contact);
        return true;
    }

    @Override
    public Contact getById(long id) throws TemplateNotFoundException {
        Contact contact = em.find(Contact.class,id);
        if (contact==null)
            throw new TemplateNotFoundException("Contact",id);
        return contact;
    }

    @Override
    public List<Contact> getByEmail(String email) {
        List<Contact> contact=null;
        if (email!=null)
            try{
                contact = (List<Contact>) em.createQuery("SELECT p FROM Contact p WHERE email = :email")
                        .setParameter("email", email);
            } catch (Exception e){
            }
        return contact;
    }

    @Override
    public List<Contact> getByTelephone(String telephone) {
        List<Contact> contact=null;
        if (telephone!=null)
            try{
                contact = (List<Contact>) em.createQuery("SELECT p FROM Contact p WHERE telephone = :telephone")
                        .setParameter("telephone", telephone);
            } catch (Exception e){
            }
        return contact;
    }

    @Override
    public List<Contact> getAllContacts(){
        List<Contact> contact=null;
        try{
            contact = (List<Contact>) em.createQuery("SELECT p FROM Contact p");
        } catch (Exception e){
        }
        return contact;
    }

    @Override
    public List<Contact> getContactsByPerson(long personId) {
        List<Contact> contact=null;
        try{
            contact = (List<Contact>) em.createQuery("SELECT c FROM Contact c join c.person p WHERE p.id = :personId")
                    .setParameter("personId", personId);
        } catch (Exception e){
        }
        return contact;
    }

}

