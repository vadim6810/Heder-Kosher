package com.tel_ran.hederkosher.model.security.dao.implementation;

import com.tel_ran.hederkosher.model.security.dao.UserDAO;
import com.tel_ran.hederkosher.model.security.entity.User;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;


@Service("userDAOService")
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findByID(long id) {
        User user = null;
        try {
            user = (User) em.createQuery("SELECT u FROM User u WHERE u.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        return user;
    }

    @Override
    public User findByMail(String mail) {
        User user = null;
        try {
            user = (User) em.createQuery("SELECT u FROM User u WHERE u.email = :email")
                    .setParameter("email", mail)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        return user;
    }

    @Override
    public List<User> findAllUser() {
        return (List<User>) em.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public boolean createUser(User user) {
        if (user == null) {
            return false;
        }
        em.persist(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        if (user == null) {
            return false;
        }
        final User oldUser = em.find(User.class, user.getId());
        if (oldUser == null) {
            return false;
        }
        final User newUser = em.merge(user);
        return true;
    }

    @Override
    public boolean deleteUser(long id) {
        final User user = em.find(User.class, id);
        if (user == null) {
            return false;
        }
        em.remove(user);
        return true;
    }

}
