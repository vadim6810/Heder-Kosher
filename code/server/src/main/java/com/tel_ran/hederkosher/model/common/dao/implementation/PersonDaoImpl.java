/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.PersonDao;
import com.tel_ran.hederkosher.model.common.entity.Person;
import com.tel_ran.hederkosher.model.common.entity.Room;
import com.tel_ran.hederkosher.service.HibUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Persistence;
import java.util.List;
import java.util.function.Predicate;

//import java.sql.SQLException;

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
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
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
        try(Session session = hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
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
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
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
        try (Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()

            System.out.println("active : "+session.getTransaction().isActive());
            System.out.println("open : "+session.isOpen());
            System.out.println("connected : "+session.isConnected());

            result = (Person) session.get(Person.class,id);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Person getByPassport(String passport) {
        List<Person> results;
        Person result=null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()

//            results = (List<Person>)session.createQuery("FROM person").list();

//            results = (List<Person>)session.byNaturalId(Person.class)
//                    .using("passportNo",passport)
//                    .load();


//            results = (List<Person>)session.load().list();
//            for (Person person: results){
//                if (person.getPassportNo()==passport) return person;
//            }
            //results = (List<Person>)session.createQuery("FROM person").list();

//            String hql = "select person FROM person WHERE PASSPORT_NO = :pPassportNo";
//            Query query = session.createQuery(hql);
//            query.setFirstResult(1);
//            query.setMaxResults(1);
//            query.setParameter("pPassportNo", passport);
//            results = (List <Person>)query.list();


            result = session.byNaturalId(Person.class)
                    .using("passportNo",passport)
                    .load();

//            session.beginTransaction();
//            Query query = session.createQuery("select * from person where PASSPORT_NO = :pPassportNo");
//            query.setFirstResult(1);
//            query.setMaxResults(1);
//            query.setParameter("pPassportNo", passport.trim());
//            results = (List <Person>)query.list();
//            session.getTransaction().commit();
//            if (results.size()>0) result=results.get(0);
        }
        return result;
    }

    @Override
    public List<Person> getPersonsByFio(String fistName, String secondName, String lastName) {
        List<Person> result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
//            List<Person> results = (List<Person>)session.byNaturalId(Person.class)
//                    .using("passportNo","")
//                    .load();
//            for (Person person: results){
//                if (person.getFistName().equals(fistName)
//                        &&person.getSecondname().equals(secondName)
//                        &&person.getLastname().equals(lastName)) result.add(person) ;
//            }

            String hql = "FROM person WHERE FIRST_NAME = :pFIRST_NAME";
            Query query = session.createQuery(hql);
            query.setParameter("pFIRST_NAME", fistName);
            result = (List <Person>)query.list();


        }

        return result;
    }


    @Override
    public Person getByEmail(String email) {
        Person result = null;
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            Query query = session.createQuery("from person where id= (select max(person_id) from person_contact where email = :paramEmail)");
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
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            result = (List<Person>)session.createQuery("FROM person").list();

        } catch (Exception e) {
//            e.printStackTrace();
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

