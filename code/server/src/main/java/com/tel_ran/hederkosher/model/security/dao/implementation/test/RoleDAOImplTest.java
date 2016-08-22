package com.tel_ran.hederkosher.model.security.dao.implementation.test;

import com.tel_ran.hederkosher.model.security.dao.AuthorityDAO;
import com.tel_ran.hederkosher.model.security.dao.RoleDAO;
import com.tel_ran.hederkosher.model.security.entity.Authority;
import com.tel_ran.hederkosher.model.security.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Igor on 07.08.2016.
 */

public class RoleDAOImplTest implements RoleDAO {
    private static final AtomicLong COUNTER = new AtomicLong();
    private static List<Role> roles;

    @Autowired
    private AuthorityDAO authorityDAO;

    @PostConstruct
    private void createAuthoritiesList() {
        roles = createTestRoles();
    }

    private List<Role> createTestRoles() {
        List<Role> res = new ArrayList<>();

        res.add(new Role(0, "ADMIN", "Application Administrator"));
        res.add(new Role(1, "MANAGER", "Manager of gym"));
        res.add(new Role(2, "TRAINER", "Trainer in gym"));
        res.add(new Role(3, "CLIENT", "Simple user"));

        createAdminRole(res.get(0));

        createManagerRole(res.get(1));
        createTrainerRole(res.get(2));
        createClientRole(res.get(3));

        return res;
    }

    private void createClientRole(Role role) {
        Authority authority = authorityDAO.findById(13);
        role.addAuthority(authority);

        authority = authorityDAO.findById(17);
        role.addAuthority(authority);

        authority = authorityDAO.findById(21);
        role.addAuthority(authority);

        authority = authorityDAO.findById(25);
        role.addAuthority(authority);

        authority = authorityDAO.findById(27);
        role.addAuthority(authority);
    }

    private void createTrainerRole(Role role) {
        createClientRole(role);

        Authority authority = authorityDAO.findById(9);
        role.addAuthority(authority);

        authority = authorityDAO.findById(18);
        role.addAuthority(authority);

        authority = authorityDAO.findById(19);
        role.addAuthority(authority);

        authority = authorityDAO.findById(20);
        role.addAuthority(authority);

        authority = authorityDAO.findById(26);
        role.addAuthority(authority);

        authority = authorityDAO.findById(27);
        role.addAuthority(authority);

        authority = authorityDAO.findById(28);
        role.addAuthority(authority);
    }

    private void createManagerRole(Role role) {
        createTrainerRole(role);

        Authority authority = authorityDAO.findById(15);
        role.addAuthority(authority);

        authority = authorityDAO.findById(15);
        role.addAuthority(authority);
    }

    private void createAdminRole(Role role) {
        for(Iterator<Authority> it = authorityDAO.getAllActions().iterator(); it.hasNext();) {
            role.addAuthority(it.next());
        }
    }

    @Override
    public Role findById(long id) {
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getId() == id)
                return roles.get(i);
        }
        return null;
    }

    @Override
    public Role findByName(String name) {
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getName().equals(name))
                return roles.get(i);
        }
        return null;
    }

    @Override
    public List<Role> getAll() {
        return roles;
    }

    public boolean isRoleExist(Role role) {
        return roles.contains(role);
    }

    @Override
    public boolean createRole(Role role) {
        role.setId(COUNTER.addAndGet(1));
        roles.add(role);
        return true;
    }

    @Override
    public boolean updateRole(Role role) {
        int index = roles.indexOf(role);
        roles.set(index, role);
        return true;
    }

    @Override
    public boolean deleteRole(long id) {
        for (Iterator<Role> it = roles.iterator(); it.hasNext(); ) {
            Role role = it.next();
            if (role.getId() == id) {
                it.remove();
                return true;
            }
        }
        return false;
    }
}
