package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.IStateMessageDao;
import com.tel_ran.hederkosher.model.common.entity.StateMessage;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class StateMessageDaoImpl implements IStateMessageDao {

    @Override
    public StateMessage getByCode(String code) {
        StateMessage result = null;
        if (code == null){
            return null;
        }
        try {
            result = StateMessage.valueOf(code);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<StateMessage> getAll() {
        return Arrays.asList(StateMessage.values());
    }
}
