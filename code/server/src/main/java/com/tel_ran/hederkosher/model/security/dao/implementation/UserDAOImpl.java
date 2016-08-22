package com.tel_ran.hederkosher.model.security.dao.implementation;

import com.tel_ran.hederkosher.model.security.dao.UserDAO;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.service.HibUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Igor on 20.08.2016.
 */
@Service("userDAOService")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private HibUtil hibernateUtil;

    @Override
    public boolean createUser(User user) {
        if (user == null) return false;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean updateUser(User user) {
        if (user == null) return false;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteUser(long id) {
        User user = this.findByID(id);
        if (user == null) return false;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public User findByID(long id) {
        User result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = session.get(User.class, id);
        }
        return result;
    }

    @Override
    public User findByMail(String mail) {
        User result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = session.byNaturalId(User.class)
                    .using("email",mail)
                    .load();
        }
        return result;
    }

    @Override
    public List<User> findAllUser() {
        List<User> result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = (List<User>)session.createQuery("FROM User").list();
        }
        return result;
    }
}
