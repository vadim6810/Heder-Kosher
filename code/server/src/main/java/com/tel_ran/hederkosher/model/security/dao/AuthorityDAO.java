package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.entity.Authority;

import java.util.List;

/**
 * Created by Igor on 07.08.2016.
 */
public interface AuthorityDAO {
    Authority findById(long id);
    List<Authority> getAllActions();
}
