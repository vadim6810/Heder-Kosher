/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.PersonDao;
import com.tel_ran.hederkosher.model.common.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

//    @PersistenceContext(name = "HederKosherSpringHibernate",type = PersistenceContextType.EXTENDED)
    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;

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
    public boolean deletePerson(long id)  {
        Person person =em.find(Person.class,id);
        if (person==null)
            return false;
        em.remove(person);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteAllPersons()  {
        try{
            List<Person> persons = (List<Person>) em.createQuery("SELECT p FROM Person p")
                    .getResultList();
            for (Person person : persons) {
                em.remove(person);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Person getById(long id) throws TemplateNotFoundException{
        Person person = em.find(Person.class,id);
        if (person==null)
            throw new TemplateNotFoundException("Person",id);
        return person;
    }

    @Override
    public List<Person> getByPassport(String passport) {
        List<Person> person=null;
        if (passport!=null)
            try{
//                person=AnyJpqlQueryOne(String.format("SELECT p FROM Person p WHERE p.passportNo = '%s'", passport));
                person = (List<Person>) em.createQuery("SELECT p FROM Person p WHERE passportNo = :passportNo")
                        .setParameter("passportNo", passport)
                        .getResultList();
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
                        .setParameter("lastName", lastName)
                        .getResultList();
            } catch (Exception e){
            }
        return persons;
    }

    @Override
    public List<Person> getByEmail(String email) {
        List<Person> person=null;
        if (email!=null)
            try{
                person = (List<Person>) em.createQuery("SELECT DISTINCT p FROM Person p JOIN p.contacts c WHERE c.email = :email")
                        .setParameter("email", email)
                        .getResultList();
            } catch (Exception e){
            }
        return person;
    }

    @Override
    public List<Person> getByTelephone(String telephone) {
        List<Person> person=null;
        if (telephone!=null)
            try{
                person = (List<Person>) em.createQuery("SELECT DISTINCT p FROM Person p JOIN p.contacts c WHERE c.telephone = :telephone")
                        .setParameter("telephone", telephone)
                        .getResultList();
            } catch (Exception e){
            }
        return person;
    }

    @Override
    public List<Person> getAllPersons(){
        List<Person> person=null;
            try{
                person = (List<Person>) em.createQuery("SELECT p FROM Person p")
                        .getResultList();
            } catch (Exception e){
            }
        return person;
    }

}

