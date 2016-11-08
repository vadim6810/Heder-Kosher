package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.entity.State;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

import com.tel_ran.hederkosher.model.common.dao.StateDao;

@Repository
public class StateDaoImpl implements StateDao {

    @Override
    public State getStateByCode(String code) {
        State result = null;
        if (code == null){
            return null;
        }
        try {
            result = State.valueOf(code);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<State> getAllStates() {
        return Arrays.asList(State.values());
    }

}
