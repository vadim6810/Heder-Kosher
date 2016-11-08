package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.State;

import java.util.List;

public interface StateDao {
    State getStateByCode(String code);
    List<State> getAllStates();
}
