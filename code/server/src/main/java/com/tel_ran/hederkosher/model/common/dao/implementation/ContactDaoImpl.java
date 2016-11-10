/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.ContactDao;
import com.tel_ran.hederkosher.model.common.entity.Contact;
import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.service.HibUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

//import java.sql.SQLException;

//@Service("contactDAOService")
public class ContactDaoImpl implements ContactDao {

    @Autowired
    PersonDaoImpl personDao;
    @Autowired
    private HibUtil hibernateUtil;
    public void setHibernateUtil(HibUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public boolean addContact(Contact contact) { //throws SQLException
        if (contact == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
            session.save(contact);
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean updateContact(Contact contact) {
        if (contact == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
//            session.saveOrUpdate(person);
            session.update(contact);
            session.getTransaction().commit();
        } catch (HibernateException e) {
    //            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteContact(Contact contact)  { //throws SQLException
        if (contact == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
            session.delete(contact);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Contact getById(long id) { //throws SQLException
        Contact result = null;
        try (Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()

            System.out.println("active : "+session.getTransaction().isActive());
            System.out.println("open : "+session.isOpen());
            System.out.println("connected : "+session.isConnected());

            result = (Contact) session.get(Contact.class,id);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Contact getByEmail(String email) {
        Contact result = null;
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            Query query = session.createQuery("from contact where email= :paramEmail");
            query.setParameter("paramEmail", email);
            result = (Contact)query.list();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Contact getByTelephone(String telephone) {
        return null;
    }

    @Override
    public List<Contact> getContactsByPerson(Person person) {
//    List<Book> book=(List<Book>)session.createCriteria(Book.class).createAlias("student", "st").add(Restrictions.eq("st.name", "Maxim")).list();
//        List<Book> book = (List<Book>)session.createSQLQuery("select ID, DESCRIPTION, NAME from book order by NAME")
//                .addScalar("id",Hibernate.LONG).addScalar("name").addScalar("description")
//                .setResultTransformer(Transformers.aliasToBean(Book.class)).list();

        return null;
    }

    @Override
    public List<Contact> getAllContacts(){
        List<Contact> result = null;
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            result = (List<Contact>)session.createQuery("FROM contact").list();

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }



    @Override
    public List<Contact> getContacts(Predicate predicate) {
        return null;
    }


}

