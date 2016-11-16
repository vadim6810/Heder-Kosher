/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.PersonNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.PersonDao;
import com.tel_ran.hederkosher.model.common.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import org.hibernate.query.Query;
//import java.sql.SQLException;

//@Service
//@Qualifier (value= "personDAOService")
//@Service(value= "personDAOService")
//@Repository(value = "personDAOService")
@Repository
public class PersonDaoImpl extends AnyJpqlDao<Person> implements PersonDao {

//    @PersistenceContext(name = "HederKosherSpringHibernate",type = PersistenceContextType.EXTENDED)
//    EntityManager em;


    public PersonDaoImpl() {
    }

    @Override
    @Transactional
    public boolean addPerson(Person person) {
        if ((person==null) || (em.find(Person.class,person.getId())!=null))
            return false;
        em.persist(person);
        return true;
    }

    @Override
    @Transactional
    public boolean updatePerson(Person person) {
        if ((person==null) || (em.find(Person.class,person.getId())==null))
            return false;

        em.persist(person);
        return true;
    }

    @Override
    @Transactional
    public boolean deletePerson(long id)  { //throws SQLException
        Person person =em.find(Person.class,id);
        if (person==null)
            return false;
        em.remove(person);
        return true;
    }

    @Override
    public Person getById(long id) throws PersonNotFoundException {
        Person person = em.find(Person.class,id);
        if (person==null)
            throw new PersonNotFoundException(id);
        return person;
    }

    @Override
    public Person getByPassport(String passport) {
        Person person=null;

        if (passport!=null)
            try{
//                person=AnyJpqlQueryOne(String.format("SELECT p FROM Person p WHERE p.passportNo = '%s'", passport));
                person = (Person) em.createQuery("SELECT p FROM Person p WHERE passportNo = :passportNo")
                        .setParameter("passportNo", passport)
                        .getSingleResult();
            } catch (Exception e){
            }

        return person;
    }

    @Override
    public List<Person> getPersonsByFio(String fistName, String secondName, String lastName) {
        List<Person> persons=null;

        if (fistName!=null && secondName!=null && lastName!=null)
            try{
                persons = (List<Person>) em.createQuery("SELECT p FROM Person p " +
                        " WHERE fistName = :fistName AND secondName = :secondName AND lastName = :lastName")
                        .setParameter("fistName", fistName)
                        .setParameter("secondName", secondName)
                        .setParameter("lastName", lastName);
            } catch (Exception e){
            }

        return persons;
    }

    @Override
    public Person getByEmail(String email) {
        Person person=null;

        if (email!=null)
            try{
                person = (Person) em.createQuery("SELECT DISTINCT p FROM Person p JOIN p.contacts c WHERE c.email = :email")
                        .setParameter("email", email)
                        .getSingleResult();
            } catch (Exception e){
            }

        return person;
    }

    @Override
    public Person getByTelephone(String telephone) {
        Person person=null;

        if (telephone!=null)
            try{
                person = (Person) em.createQuery("SELECT DISTINCT p FROM Person p JOIN p.contacts c WHERE c.telephone = :telephone")
                        .setParameter("telephone", telephone)
                        .getSingleResult();
            } catch (Exception e){
            }

        return person;
    }

    @Override
    public List<Person> getAllPersons(){
        return  AnyJpqlQuery("SELECT p FROM Person p ");
    }

    @Override
    public List<Person> getPersons(String jpql) {
        return  AnyJpqlQuery(jpql);
    }

    //    @Override
    //    public List<Person> getPersons(Predicate predicate) {
    //        return  AnyJpqlQuery(String.format("SELECT p FROM PERSON p "));
    //    }

    @Override
    public List<Person> getPersonsByRoom(long idRoom) {
        List<Person> persons=null;

        try{
            persons = (List<Person>) em.createQuery("SELECT DISTINCT p FROM Person p " +
                    " Join p.user u1 " +
                    ", UserGrantedAuthority a " +
                    " Join a.user u2 " +
                    " Join a.room r " +
                    " WHERE u1.id=u2.id and r.id = :idRoom")
                    .setParameter("idRoom", idRoom);
        } catch (Exception e){
        }
        return persons;
    }

}

