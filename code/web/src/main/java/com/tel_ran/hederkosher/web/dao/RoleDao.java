package com.tel_ran.hederkosher.web.dao;

import com.tel_ran.hederkosher.web.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ruslan on 10/02/17.
 */
public interface RoleDao extends JpaRepository<Role,Long> {
}
