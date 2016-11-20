package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.StateUserDao;
import com.tel_ran.hederkosher.model.common.entity.StateUser;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class StateUserDaoImpl implements StateUserDao {

    @Override
    public StateUser getByCode(String code) {
        StateUser result = null;
        if (code == null){
            return null;
        }
        try {
            result = StateUser.valueOf(code);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<StateUser> getAll() {
        return Arrays.asList(StateUser.values());
    }
}
