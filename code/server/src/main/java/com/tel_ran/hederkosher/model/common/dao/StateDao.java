package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.State;

import java.util.List;

public interface StateDao {
    boolean add(State state);
    boolean delete(State state);
    State getById(long id);
    State getByCode(String code);
    List<State> getAllStates();
}
