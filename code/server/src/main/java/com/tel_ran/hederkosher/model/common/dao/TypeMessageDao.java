package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.TypeMessage;

import java.util.List;

/**
 * Created by Ruslan on 18/11/16.
 */
public interface TypeMessageDao {
    TypeMessage getByCode(String code);
    List<TypeMessage> getAll();
}
