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
        if ((person==null) || (em.find(Person.class,person.getIdPerson())!=null))
            return false;
        em.persist(person);
        return true;
    }

    @Override
    @Transactional
    public boolean updatePerson(Person person) {
        if ((person==null) || (em.find(Person.class,person.getIdPerson())==null))
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
        return AnyJpqlQueryOne(String.format("SELECT p FROM PERSON p WHERE p.passport = %s", passport));
    }

    @Override
    public List<Person> getPersonsByFio(String fistName, String secondName, String lastName) {
        return  AnyJpqlQuery(String.format("SELECT p FROM PERSON p " +
                " WHERE p.fistName = %s" +
                " AND p.secondName = %s" +
                " AND p.lastName = %s", fistName, secondName, lastName));
    }

    @Override
    public Person getByEmail(String email) {
        return AnyJpqlQueryOne(String.format("SELECT p FROM person p JOIN contact c WHERE c.email = %s", email));
    }

    @Override
    public Person getByTelephone(String telephone) {
        return AnyJpqlQueryOne(String.format("SELECT p FROM person p JOIN contact c WHERE c.telephone = %s", telephone));
    }

    @Override
    public List<Person> getAllPersons(){
        return  AnyJpqlQuery("SELECT p FROM PERSON p ");
    }

    @Override
    public List<Person> getPersons(String jpql) {
        return  AnyJpqlQuery(jpql);


//    @Override
//    public List<Person> getPersonsByRoom(Room room) {
//        return AnyJpqlQueryOne(String.format("SELECT p FROM person p JOIN contact c WHERE c.email = %s", email));
//    }
//    @Override
//    public List<Person> getPersons(Predicate predicate) {
//        return  AnyJpqlQuery(String.format("SELECT p FROM PERSON p "));
//    }

}


}

