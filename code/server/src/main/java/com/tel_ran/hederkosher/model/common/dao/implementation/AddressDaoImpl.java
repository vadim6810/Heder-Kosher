/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.IAddressDao;
import com.tel_ran.hederkosher.model.common.entity.Address;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AddressDaoImpl implements IAddressDao {

    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;
//    @Autowired
//
//    @Autowired
//    EntityManagerFactory emf;
//
//    EntityManager em = emf.createEntityManager();



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

        em.persist(address);
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
    public Address getById(long id) throws TemplateNotFoundException {
        Address address = em.find(Address.class,id);
        if (address==null)
            throw new TemplateNotFoundException("Address",id);
        return address;
    }

    @Override
    public List<Address> getByName(String name) {
        List<Address> address=null;

        if (name!=null)
            try{
                address = (List<Address>) em.createQuery("SELECT p FROM Address p WHERE name = :name")
                        .setParameter("name", name);
            } catch (Exception e){
            }

        return address;
    }

    @Override
    public List<Address> getAllAddresses(){
        List<Address> address=null;

        try{
            address = (List<Address>) em.createQuery("SELECT p FROM Address p");
        } catch (Exception e){
        }

        return address;
    }



}

