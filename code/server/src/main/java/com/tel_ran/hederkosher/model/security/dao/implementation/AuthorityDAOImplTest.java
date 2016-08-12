package com.tel_ran.hederkosher.model.security.dao.implementation;

import com.tel_ran.hederkosher.model.security.Authority;
import com.tel_ran.hederkosher.model.security.dao.AuthorityDAO;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Igor on 07.08.2016.
 */

@Service("authorityDAOService")
public class AuthorityDAOImplTest implements AuthorityDAO {
    private static List<Authority> authorities;
    static {
        authorities = fillActions();
    }

    private static List<Authority> fillActions() {
        List<Authority> res = new ArrayList<>();
        res.add(new Authority(1, "LIST USERS", ""));
        res.add(new Authority(2, "CREATE USER", ""));
        res.add(new Authority(3, "UPDATE USER", ""));
        res.add(new Authority(4, "DELETE USER", ""));

        res.add(new Authority(5, "LIST ROLES", ""));
        res.add(new Authority(6, "CREATE ROLE", ""));
        res.add(new Authority(7, "UPDATE ROLE", ""));
        res.add(new Authority(8, "DELETE ROLE", ""));

        res.add(new Authority(9, "LIST PERSON", ""));
        res.add(new Authority(10, "CREATE PERSON", ""));
        res.add(new Authority(11, "UPDATE PERSON", ""));
        res.add(new Authority(12, "DELETE PERSON", ""));

        res.add(new Authority(13, "LIST ROOM", ""));
        res.add(new Authority(14, "CREATE ROOM", ""));
        res.add(new Authority(15, "UPDATE ROOM", ""));
        res.add(new Authority(16, "DELETE ROOM", ""));

        res.add(new Authority(17, "LIST PROGRAM", ""));
        res.add(new Authority(18, "CREATE PROGRAM", ""));
        res.add(new Authority(19, "UPDATE PROGRAM", ""));
        res.add(new Authority(20, "DELETE PROGRAM", ""));

        res.add(new Authority(21, "LIST STATE", ""));
        res.add(new Authority(22, "CREATE STATE", ""));
        res.add(new Authority(23, "UPDATE STATE", ""));
        res.add(new Authority(24, "DELETE STATE", ""));

        res.add(new Authority(25, "LIST TASK", ""));
        res.add(new Authority(26, "CREATE TASK", ""));
        res.add(new Authority(27, "UPDATE TASK", ""));
        res.add(new Authority(28, "DELETE TASK", ""));

        return res;
    }

    @Override
    public Authority findById(long id) {
        for (Iterator<Authority> it = authorities.iterator(); it.hasNext(); ) {
            Authority authority = it.next();
            if (authority.getId() == id) {
                return authority;
            }
        }
        return null;
    }

    @Override
    public List<Authority> getAllActions() {
        return authorities;
    }
}
