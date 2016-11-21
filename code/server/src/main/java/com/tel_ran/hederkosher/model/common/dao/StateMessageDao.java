package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.MessageState;

import java.util.List;

/**
 * Created by Ruslan on 18/11/16.
 */
public interface StateMessageDao {
    MessageState getByCode(String code);
    List<MessageState> getAll();
}
