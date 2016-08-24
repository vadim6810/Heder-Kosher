/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.model.common.dao.PersonDao;
import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.service.HibUtil;
//import com.tel_ran.hederkosher.service.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

@Service("personDAOService")
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private HibUtil hibernateUtil;
    public void setHibernateUtil(HibUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public boolean addPerson(Person person) { //throws SQLException
        if (person == null){
            //throw new NullPointerException();
            return false;
        }
        try {
            Session session= hibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean updatePerson(Person person) {
        if (person == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
//            session.saveOrUpdate(person);
            session.update(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
    //            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deletePerson(Person person)  { //throws SQLException
        if (person == null){
            //throw new NullPointerException();
            return false;
        }
        try {
            Session session= hibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Person getById(long id) { //throws SQLException
        Person result = null;
        try {
            Session session= hibernateUtil.getSessionFactory().openSession();
            result = (Person) session.get(Person.class,id);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Person getByPassport(String passport) {
        Person result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = session.byNaturalId(Person.class)
                    .using("passportNo",passport)
                    .load();
        }
        return result;
    }

    @Override
    public Person getByEmail(String email) {
        Person result = null;
        try {
            Session session= hibernateUtil.getSessionFactory().openSession();
            Query query = session.createQuery("from person p where id= (select max(person_id) from person_contact where email = :paramEmail)");
            query.setParameter("paramEmail", email);
            result = (Person)query.list();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }



    @Override
    public Person getByTelephone(String telephone) {
        return null;
    }

    @Override
    public List<Person> getAllPersons(){
        List<Person> result = null;
        try {
            Session session= hibernateUtil.getSessionFactory().openSession();
            result = (List<Person>)session.createQuery("FROM person order by FIST_NAME").list();

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Person> getPersonsByFio(String fistName, String secondName, String lastName) {
        List<Person> result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = (List<Person>)session.byNaturalId(Person.class)
                    .using("passportNo",fistName)
                    .using("secondName",secondName)
                    .using("lastName",lastName)
                    .load();
        }
        return result;
    }

    @Override
    public List<Person> getPersonsByRoom(Room room) {
//    List<Book> book=(List<Book>)session.createCriteria(Book.class).createAlias("student", "st").add(Restrictions.eq("st.name", "Maxim")).list();
//        List<Book> book = (List<Book>)session.createSQLQuery("select ID, DESCRIPTION, NAME from book order by NAME")
//                .addScalar("id",Hibernate.LONG).addScalar("name").addScalar("description")
//                .setResultTransformer(Transformers.aliasToBean(Book.class)).list();

        return null;
    }

    @Override
    public List<Person> getPersons(Predicate predicate) {
        return null;
    }

//    Session session = HibernateSessionFactory.getSessionFactory().openSession();
//
//    Transaction tx = session.beginTransaction();
//
//    Query query = session.createQuery("update ContactEntity set firstName = :nameParam, lastName = :lastNameParam" +
//            ", birthDate = :birthDateParam"+
//            " where firstName = :nameCode");
//
//        query.setParameter("nameCode", "Nick");
//        query.setParameter("nameParam", "NickChangedName1");
//        query.setParameter("lastNameParam", "LastNameChanged1" );
//        query.setParameter("birthDateParam", new Date());
//
//    int result = query.executeUpdate();
//
//tx.commit();
//session.close();


//    var blogs = s.CreateCriteria<Blog>()
//            .Add(Restrictions.Eq("Title","Ayende @ Rahien"))
//            .Add(Restrictions.Eq("Subtitle", "Send me a patch for that"))
//            .List<Blog>();


    }

