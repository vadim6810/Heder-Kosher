package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.StateMessage;

import java.util.List;

/**
 * Created by Ruslan on 18/11/16.
 */
public interface IStateMessageDao {
    StateMessage getByCode(String code);
    List<StateMessage> getAll();
}
