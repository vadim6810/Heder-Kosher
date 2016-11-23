/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.OfficeDao;
import com.tel_ran.hederkosher.model.common.entity.Office;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class OfficeDaoImpl implements OfficeDao {

    @PersistenceContext(name = "HKSpringHibernate")    //@PersistenceContext
    EntityManager em;

    public OfficeDaoImpl() {
    }

    @Override
    @Transactional
    public boolean addOffice(Office office) {
        if ((office==null) || (em.find(Office.class,office.getId())!=null))
            return false;
        em.persist(office);
        return true;
    }

    @Override
    @Transactional
    public boolean updateOffice(Office office) {
        if ((office==null) || (em.find(Office.class,office.getId())==null))
            return false;

        em.merge(office);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteOffice(long id)  {
        Office office =em.find(Office.class,id);
        if (office==null)
            return false;
        em.remove(office);
        return true;
    }

    @Override
    public Office getById(long id) throws TemplateNotFoundException {
        Office office = em.find(Office.class,id);
        if (office==null)
            throw new TemplateNotFoundException("Office",id);
        return office;
    }

    @Override
    public List<Office> getByName(String name) {
        List<Office> office=null;

        if (name!=null)
            try{
                office = (List<Office>) em.createQuery("SELECT p FROM Office p WHERE name = :name")
                        .setParameter("name", name)
                        .getResultList();
            } catch (Exception e){
            }

        return office;
    }

    @Override
    public List<Office> getAllOffices(){
        List<Office> office=null;

        try{
            office = (List<Office>) em.createQuery("SELECT p FROM Office p")
                    .getResultList();
        } catch (Exception e){
        }

        return office;
    }

    @Override
    public List<Office> getAllOfficesActives() {
        List<Office> office=null;

        try{
            office = (List<Office>) em.createQuery("SELECT p FROM Office p where enable is true ")
                    .getResultList();
        } catch (Exception e){
        }

        return office;
    }

    @Override
    @Transactional
    public boolean deleteAllOffices()  {
        try{
            List<Office> offices = (List<Office>) em.createQuery("SELECT p FROM Office p")
                    .getResultList();
            for (Office office: offices) {
                em.remove(office);
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }


}

