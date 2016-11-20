package com.tel_ran.hederkosher.model.common.dao.implementation;

import com.tel_ran.hederkosher.model.common.dao.TypeMessageDao;
import com.tel_ran.hederkosher.model.common.entity.TypeMessage;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class TypeMessageDaoImpl implements TypeMessageDao {

    @Override
    public TypeMessage getByCode(String code) {
        TypeMessage result = null;
        if (code == null){
            return null;
        }
        try {
            result = TypeMessage.valueOf(code);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<TypeMessage> getAll() {
        return Arrays.asList(TypeMessage.values());
    }
}
