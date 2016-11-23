/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.AddressDao;
import com.tel_ran.hederkosher.model.common.entity.*;
import com.tel_ran.hederkosher.model.security.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AddressDaoImpl implements AddressDao {

    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;

    public AddressDaoImpl() {
    }

    @Override
    @Transactional
    public boolean addAddress(Address address) {
        if ((address==null) || (em.find(Address.class,address.getId())!=null))
            return false;
         em.persist(address);
        return true;
    }

    @Override
    @Transactional
    public boolean updateAddress(Address address) {
        if ((address==null) || (em.find(Address.class,address.getId())==null))
            return false;

        em.merge(address);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteAddress(long id)  {
        Address address =em.find(Address.class,id);
            if (address==null)
                return false;
            em.remove(address);
            return true;
        }

    @Override
    public boolean deleteAllAddresses() {
        try{
            List<Address> addresses = (List<Address>) em.createQuery("SELECT p FROM Address p")
                    .getResultList();
            for (Address address: addresses) {
                em.remove(address);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Address getById(long id) throws TemplateNotFoundException {
        Address address = em.find(Address.class,id);
        if (address==null)
            throw new TemplateNotFoundException("Address",id);
        return address;
    }

    @Override
    public List<Address> getByNames(String country, String city, String street, String building, String apartment, String postalCode) {
        List<Address> addresses=null;

        Map<String,String> names = new HashMap<>();
        if (country!=null) names.put("country",country);
        if (city!=null) names.put("city",city);
        if (street!=null) names.put("street",street);
        if (building!=null) names.put("building",building);
        if (apartment!=null) names.put("apartment",apartment);
        if (postalCode!=null) names.put("postalCode",postalCode);

        if (!names.isEmpty()) {
            try{
                StringBuilder stringWhere= new StringBuilder("SELECT p FROM Address p WHERE true ");
                for (String key : names.keySet()) {
                    stringWhere.append(" and ").append(key).append("= :").append(key);
                }
                Query query = em.createQuery(stringWhere.toString());
                for (Map.Entry<String, String> entry : names.entrySet()) {
                    query.setParameter(entry.getKey(),entry.getValue());
                }

                addresses = (List<Address>) query.getResultList();
            } catch (Exception e){
            }
        }
        return addresses;
    }

    @Override
    public List<Address> getByAnyName(String name) {
        List<Address> address=null;

        if (name!=null)
            try{
                address = (List<Address>) em.createQuery(
                        " SELECT p FROM Address p WHERE country like :name or city like :name or street like :name or building like :name or  apartment like :name or postalCode like :name")
                        .setParameter("name", "%"+name+"%")
                        .getResultList();
            } catch (Exception e){
            }

        return address;
    }

    @Override
    public List<Address> getAllAddresses(){
        List<Address> address=null;

        try{
            address = (List<Address>) em.createQuery("SELECT p FROM Address p")
                    .getResultList();
        } catch (Exception e){
        }

        return address;
    }

    @Override
    public List<Address> getAddressesByPerson(long personId) {
        List<Address> addresses=null;
        try{
            addresses = (List<Address>) em.createQuery("SELECT a FROM Person p join p.address a WHERE p.id = :personId")
                    .setParameter("personId", personId)
                    .getResultList();
        } catch (Exception e){
        }
        return addresses;
    }
    @Override
    @Transactional
    public boolean deleteAddressesByPerson(long personId) {
        Person person = em.find(Person.class,personId);
        if (person==null) return false;
        em.refresh(person);
        person.setAddress(null);
//        List<Address> addresses = getAddressesByPerson(personId);
//        if (addresses == null) return false;
//        try{
//            for (Address address : addresses) {
//                em.remove(address);
//            }
//        } catch (Exception e){
//            return false;
//        }

        return true;
    }


    @Override
    public List<Address> getAddressesByRoom(long roomId) {
        List<Address> addresses=null;
        try{
            addresses = (List<Address>) em.createQuery("SELECT a FROM Room r join r.address a WHERE r.id = :roomId")
                    .setParameter("roomId", roomId)
                    .getResultList();
        } catch (Exception e){
        }
        return addresses;
    }
    @Transactional
    @Override
    public boolean deleteAddressesByRoom(long roomId) {
        Room room = em.find(Room.class,roomId);
        if (room==null) return false;
        em.refresh(room);
        room.setAddress(null);
//        List<Address> addresses = getAddressesByRoom(roomId);
//        if (addresses == null) return false;
//        try{
//            for (Address address : addresses) {
//                em.remove(address);
//            }
//        } catch (Exception e){
//            return false;
//        }
        return true;
    }

    @Override
    public List<Address> getAddressesByGym(long gymId) {
        List<Address> addresses=null;
        try{
            addresses = (List<Address>) em.createQuery("SELECT g.address FROM Gym g WHERE g.id = :gymId")
                    .setParameter("gymId", gymId)
                    .getResultList();
        } catch (Exception e){
        }
        return addresses;
    }
    @Transactional
    @Override
    public boolean deleteAddressesByGym(long gymId) {
        Gym gym = em.find(Gym.class,gymId);
        if (gym==null) return false;
        em.refresh(gym);
        gym.setAddress(null);
//        List<Address> addresses = getAddressesByGym(gymId);
//        if (addresses == null) return false;
//        try{
//            for (Address address : addresses) {
//                em.remove(address);
//            }
//        } catch (Exception e){
//            return false;
//        }
        return true;
    }


}

