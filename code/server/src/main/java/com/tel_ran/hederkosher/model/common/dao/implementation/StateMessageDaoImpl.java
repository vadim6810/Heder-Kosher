package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.StateMessageDao;
import com.tel_ran.hederkosher.model.common.entity.MessageState;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class StateMessageDaoImpl implements StateMessageDao {

    @Override
    public MessageState getByCode(String code) {
        MessageState result = null;
        if (code == null){
            return null;
        }
        try {
            result = MessageState.valueOf(code);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<MessageState> getAll() {
        return Arrays.asList(MessageState.values());
    }
}
