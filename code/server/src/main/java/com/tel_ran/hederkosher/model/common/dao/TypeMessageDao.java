package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.MessageType;

import java.util.List;

/**
 * Created by Ruslan on 18/11/16.
 */
public interface TypeMessageDao {
    MessageType getByCode(String code);
    List<MessageType> getAll();
}
