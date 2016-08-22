package com.tel_ran.hederkosher.model.security.dao.implementation;

import com.tel_ran.hederkosher.model.security.dao.AuthorityDAO;
import com.tel_ran.hederkosher.model.security.entity.Authority;
import com.tel_ran.hederkosher.service.HibUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Igor on 22.08.2016.
 */
@Service("authorityDAOService")
public class AuthorityDAOImpl implements AuthorityDAO {
    @Autowired
    private HibUtil hibernateUtil;

    @Override
    public Authority findById(long id) {
        Authority result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = session.get(Authority.class, id);
        }
        return result;
    }

    @Override
    public List<Authority> getAllActions() {
        List<Authority> result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = (List<Authority>)session.createQuery("FROM Authority").list();
        }
        return result;
    }
}
