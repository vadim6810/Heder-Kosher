package com.tel_ran.hederkosher.model.dao;

import com.tel_ran.hederkosher.model.State;
import com.tel_ran.hederkosher.service.HibUtil;
//import com.tel_ran.hederkosher.service.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 19.08.2016.
 */
@Service("stateDAOService")
public class StateDaoImpl implements StateDao{

    @Autowired
    private HibUtil hibernateUtil;

    public void setHibernateUtil(HibUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public boolean add(State state) {
        if (state == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(state);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean delete(State state) {
        if (state == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(state);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public State getById(long id) {
        State result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = session.get(State.class,id);
        }
        return result;
    }

    @Override
    public State getByCode(String code) {
        State result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = session.byNaturalId(State.class)
                    .using("code",code)
                    .load();
        }
        return result;
    }

    @Override
    public List<State> getAllStates() {
        List<State> result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = (List<State>)session.createQuery("FROM State").list();
        }
        return result;
    }
}
