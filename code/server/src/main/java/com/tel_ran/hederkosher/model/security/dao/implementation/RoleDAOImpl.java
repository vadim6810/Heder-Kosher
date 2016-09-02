package com.tel_ran.hederkosher.model.security.dao.implementation;

import com.tel_ran.hederkosher.model.security.dao.RoleDAO;
import com.tel_ran.hederkosher.model.security.entity.Role;
import com.tel_ran.hederkosher.service.HibUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Igor on 22.08.2016.
 */
@Service("roleDAOService")
public class RoleDAOImpl implements RoleDAO {

    @Autowired
    private HibUtil hibernateUtil;

    @Override
    public Role findById(long id) {
        Role role = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            role = session.byId(Role.class).load(id);
            int count = role.getAuthorities().size();
        }
        return role;
    }

    @Override
    public Role findByName(String name) {
        Role result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = session.byNaturalId(Role.class)
                    .using("name",name)
                    .load();
        }
        return result;
    }

    @Override
    public List<Role> getAll() {
        List<Role> result = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            result = (List<Role>)session.createQuery("FROM Role").list();
        }
        return result;
    }

    @Override
    public boolean createRole(Role role) {
        if (role == null) return false;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean updateRole(Role role) {
        if (role == null) return false;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.update(role);
            session.getTransaction().commit();
            return true;
        }
    }

    @Override
    public boolean deleteRole(long id) {
        Role role = this.findById(id);
        if (role == null) return false;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            session.delete(role);
            session.getTransaction().commit();
            return true;
        }
    }
}
