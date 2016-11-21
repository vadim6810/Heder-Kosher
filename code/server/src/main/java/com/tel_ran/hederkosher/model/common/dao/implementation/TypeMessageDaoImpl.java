package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.TypeMessageDao;
import com.tel_ran.hederkosher.model.common.entity.MessageType;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class TypeMessageDaoImpl implements TypeMessageDao {

    @Override
    public MessageType getByCode(String code) {
        MessageType result = null;
        if (code == null){
            return null;
        }
        try {
            result = MessageType.valueOf(code);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<MessageType> getAll() {
        return Arrays.asList(MessageType.values());
    }
}
