/**
 * Created by Ruslan on 30.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.PersonRole;

import java.util.List;

public interface PersonRoleDao {
        boolean addPersonRole(PersonRole obj);
        boolean updatePersonRole(PersonRole obj);
        boolean deletePersonRole(PersonRole obj);
        PersonRole getById(long id);
        PersonRole getByName(String name);
        List<PersonRole> getAllPersonRoles();
}
