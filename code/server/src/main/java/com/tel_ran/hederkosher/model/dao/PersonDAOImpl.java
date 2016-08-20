/**
 * Created by Ruslan on 12.08.2016.
 */

package com.tel_ran.hederkosher.model.dao;

import java.util.List;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.tel_ran.hederkosher.model.Person;

@Repository("personDao")
public class PersonDaoImpl extends AbstractDao implements PersonDao{

    public void savePerson(Person person) {
        persist(person);
    }

    @SuppressWarnings("unchecked")
    public List<Person> findAllPersons() {
        Criteria criteria = getSession().createCriteria(Person.class);
        return (List<Person>) criteria.list();
    }

//    public void deletePersonBySsn(String ssn) {
//        Query query = getSession().createSQLQuery("delete from Person where ssn = :ssn");
//        query.setString("ssn", ssn);
//        query.executeUpdate();
//    }
    public void deletePerson(Person person) {
        getSession().delete(person);
    }


    public Person findBySsn(String ssn){
        Criteria criteria = getSession().createCriteria(Person.class);
        criteria.add(Restrictions.eq("ssn",ssn));
        return (Person) criteria.uniqueResult();
    }

    public void updatePerson(Person person){
        getSession().update(person);
    }

    public Collection loadProductsByCategory(String fistName) {
        return this.getSession()
                .createQuery("from Person person where person.fistName=?")
                .setParameter(0, fistName)
                .list();
    }

}