package com.tel_ran.hederkosher.model.security.dao.implementation;

import com.tel_ran.hederkosher.model.security.dao.TokenDAO;
import com.tel_ran.hederkosher.model.security.entity.Token;
import com.tel_ran.hederkosher.model.security.entity.User;
import com.tel_ran.hederkosher.service.HibUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Igor on 22.08.2016.
 */
@Service("tokenDAOService")
public class TokenDAOImpl implements TokenDAO {
    @Autowired
    private HibUtil hibernateUtil;

    @Override
    public User getUser(String token) throws UsernameNotFoundException {
        if (token == null || "".equals(token)) return null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            User user = (User) session.
                    createQuery("Select t.User from Token t where t.token = :stToken")
                    .setParameter("stToken", token)
                    .getSingleResult();
            return user;
        }
    }

    @Override
    public Token createToken(User user) {
        if (user == null) return null;
        Token token = new Token();
        token.setUser(user);
        token.setTsCreate(new Date());
        String tokenString = user.toString() + token.getTsCreate().toString();
        token.setToken(DigestUtils.md5DigestAsHex(tokenString.getBytes()));
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            this.deleteToken(user);
            session.save(token);
            session.getTransaction().commit();
            return token;
        }
    }

    @Override
    public void deleteToken(User user) {
        if (user == null) return;

        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            List<Token> tokens = (List<Token>) session.
                    createQuery("from Token t where t.user = :user")
                    .setParameter("user", user)
                    .getResultList();
            session.beginTransaction();
            for (Token token : tokens) {
                session.delete(token);
            }
            session.getTransaction().commit();
            return;
        }
    }

    @Override
    public void deleteToken(String stToken) {
        if (stToken == null || "".equals(stToken)) return;
        try(Session session = hibernateUtil.getSessionFactory().openSession()) {
            String queryString = "from Token t where t.token = :token_string";
            Query query = session.createQuery(queryString);
            query.setParameter("token_string", stToken);
            Token token = (Token) query.getSingleResult();
            session.beginTransaction();
            session.delete(token);
            session.getTransaction().commit();
        }
    }
}
