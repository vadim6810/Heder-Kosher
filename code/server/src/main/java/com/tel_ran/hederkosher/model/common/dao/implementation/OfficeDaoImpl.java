/**
 * Created by Ruslan on 31.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.OfficeDao;
import com.tel_ran.hederkosher.model.common.entity.Office;
import com.tel_ran.hederkosher.service.HibUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//import java.sql.SQLException;

//@Service("officeDAOService")
public class OfficeDaoImpl implements OfficeDao {

    @Autowired
    private HibUtil hibernateUtil;
    public void setHibernateUtil(HibUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public boolean addOffice(Office office) { //throws SQLException
        if (office == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
            session.save(office);
            session.getTransaction().commit();
        } catch (HibernateException e) {
//            e.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean updateOffice(Office office) {
        if (office == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
//            session.saveOrUpdate(person);
            session.update(office);
            session.getTransaction().commit();
        } catch (HibernateException e) {
    //            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteOffice(Office office)  { //throws SQLException
        if (office == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            session.beginTransaction();
            session.delete(office);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Office getById(long id) { //throws SQLException
        Office result = null;
        try (Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            result = (Office) session.get(Office.class,id);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Office getByName(String name) {
        Office result = null;
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            Query query = session.createQuery("from Office where name = :paramName");
            query.setParameter("paramName", name);
            result = (Office)query.list();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Office> getAllOffices(){
        List<Office> result = null;
        try(Session session= hibernateUtil.getSessionFactory().openSession()){ //.getSessionFactory()
            result = (List<Office>)session.createQuery("FROM Office").list();

        } catch (Exception e) {
//            e.printStackTrace();
        }
        return result;
    }


}

