package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.model.common.entity.State;
import com.tel_ran.hederkosher.model.common.dao.StateDao;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.StateCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stateCRUDService")
public class StateCRUDServiceImpl implements StateCRUDService {

    @Autowired
    private StateDao stateDao;

    @Override
    public ServiceResult findStateByCode(String code) {
        final State state = stateDao.getStateByCode(code);
        ServiceResult result;
        if (state == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(code);
            result.setDescription("state with code = '" + code + "' not found");
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(state);
        return result;
    }

    @Override
    public ServiceResult findAllStates() {
        final ServiceResult result = ServiceResultFactory.OK;
        result.setData(stateDao.getAllStates());
        return result;
    }

}
