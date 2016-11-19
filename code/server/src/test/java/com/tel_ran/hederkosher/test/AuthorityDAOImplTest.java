package com.tel_ran.hederkosher.test;

import com.tel_ran.hederkosher.model.security.dao.AuthorityDAO;
import com.tel_ran.hederkosher.model.security.entity.Authority;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 07.08.2016.
 */

public class AuthorityDAOImplTest  implements AuthorityDAO {

    private static List<Authority> authorities;
    static {
        authorities = fillActions();
    }

    private static List<Authority> fillActions() {
        List<Authority> res = new ArrayList<>();
        res.add(new Authority(1, "LIST_USERS", ""));
        res.add(new Authority(2, "CREATE_USER", ""));
        res.add(new Authority(3, "UPDATE_USER", ""));
        res.add(new Authority(4, "DELETE_USER", ""));

        res.add(new Authority(5, "LIST_ROLES", ""));
        res.add(new Authority(6, "CREATE_ROLE", ""));
        res.add(new Authority(7, "UPDATE_ROLE", ""));
        res.add(new Authority(8, "DELETE_ROLE", ""));

        res.add(new Authority(9, "LIST_PERSON", ""));
        res.add(new Authority(10, "CREATE_PERSON", ""));
        res.add(new Authority(11, "UPDATE_PERSON", ""));
        res.add(new Authority(12, "DELETE_PERSON", ""));

        res.add(new Authority(13, "LIST_ROOM", ""));
        res.add(new Authority(14, "CREATE_ROOM", ""));
        res.add(new Authority(15, "UPDATE_ROOM", ""));
        res.add(new Authority(16, "DELETE_ROOM", ""));

        res.add(new Authority(17, "LIST_PROGRAM", ""));
        res.add(new Authority(18, "CREATE_PROGRAM", ""));
        res.add(new Authority(19, "UPDATE_PROGRAM", ""));
        res.add(new Authority(20, "DELETE_PROGRAM", ""));

        res.add(new Authority(21, "LIST_STATE", ""));
        res.add(new Authority(22, "CREATE_STATE", ""));
        res.add(new Authority(23, "UPDATE_STATE", ""));
        res.add(new Authority(24, "DELETE_STATE", ""));

        res.add(new Authority(25, "LIST_TASK", ""));
        res.add(new Authority(26, "CREATE_TASK", ""));
        res.add(new Authority(27, "UPDATE_TASK", ""));
        res.add(new Authority(28, "DELETE_TASK", ""));

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
