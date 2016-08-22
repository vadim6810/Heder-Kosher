package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.TaskDao;
import com.tel_ran.hederkosher.model.common.entity.Program;
import com.tel_ran.hederkosher.model.common.entity.Task;
import com.tel_ran.hederkosher.service.HibUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Egor on 22.08.2016.
 */
@Service("taskDAOService")
public class TaskDaoImpl implements TaskDao {

    @Autowired
    private HibUtil hibernateUtil;

    public void setHibernateUtil(HibUtil hibernateUtil) {
        this.hibernateUtil = hibernateUtil;
    }

    @Override
    public boolean addTask(Task task) {
        if (task == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean updateTask(Task task) {
        if (task == null){
            //throw new NullPointerException();
            return false;
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.saveOrUpdate(task);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteTask(long id) {
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            Task task = session.get(Task.class,id);
            if (task == null){
                //throw new NullPointerException();
                return false;
            }
            session.beginTransaction();
            session.delete(task);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public Task getById(long id) {
        Task result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = session.get(Task.class,id);
        }
        return result;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = (List<Task>)session.createQuery("FROM Task").list();
        }
        return result;
    }

    @Override
    public List<Task> getProgramTasks(Program program) {
        List<Task> result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = (List<Task>)session.createQuery("FROM Task t WHERE t.program = :program")
                    .setParameter("program",program)
                    .list();
        }
        return result;
    }
}
