package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.StateUser;

import java.util.List;

/**
 * Created by Ruslan on 18/11/16.
 */
public interface IStateUserDao {
    StateUser getByCode(String code);
    List<StateUser> getAll();
}
