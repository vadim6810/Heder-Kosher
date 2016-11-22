/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.GymDao;
import com.tel_ran.hederkosher.model.common.entity.Address;
import com.tel_ran.hederkosher.model.common.entity.Gym;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Repository
public class GymDaoImpl implements GymDao {

    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;

    public GymDaoImpl() {
    }

    @Override
    @Transactional
    public boolean addGym(Gym gym) {
        if ((gym==null) || (em.find(Gym.class,gym.getId())!=null))
            return false;
        em.persist(gym);
        return true;
    }

    @Override
    @Transactional
    public boolean updateGym(Gym gym) {
        if ((gym==null) || (em.find(Gym.class,gym.getId())==null))
            return false;

        em.merge(gym);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteGym(long id)  {
        Gym gym =em.find(Gym.class,id);
        if (gym==null)
            return false;
        em.remove(gym);
        return true;
    }

    @Override
    public Gym getById(long id) throws TemplateNotFoundException {
        Gym gym = em.find(Gym.class,id);
        if (gym==null)
            throw new TemplateNotFoundException("Gym",id);
        return gym;
    }

    @Override
    public List<Gym> getByName(String name) {
        List<Gym> gyms=null;

        if (name!=null)
            try{
                gyms = (List<Gym>) em.createQuery("SELECT p FROM Gym p WHERE name = :name")
                        .setParameter("name", name)
                        .getResultList();
            } catch (Exception e){
            }

        return gyms;
    }

    @Override
    public List<Gym> getAllGyms(){
        List<Gym> gyms=null;

        try{
            gyms = (List<Gym>) em.createQuery("SELECT p FROM Gym p")
                    .getResultList();
        } catch (Exception e){
        }

        return gyms;
    }

    @Override
    @Transactional
    public boolean deleteAllGyms()  {
        try{
            List<Gym> gyms = (List<Gym>) em.createQuery("SELECT p FROM Gym p")
                    .getResultList();
            for (Gym gym: gyms) {
                em.remove(gym);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }


    @Transactional
    @Override
    public boolean addAddressByGym(long gymId, Address address) {
        Gym gym;

        try {
            gym = getById(gymId);
        } catch (Exception e){
            return false;
        }
        if (gym==null) return false;
        em.refresh(gym);
        gym.setAddress(address);
        em.merge(gym);
        return true;
    }
}

