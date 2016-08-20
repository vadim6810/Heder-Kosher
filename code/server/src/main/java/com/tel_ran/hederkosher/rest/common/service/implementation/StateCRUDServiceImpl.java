package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.model.common.entity.State;
import com.tel_ran.hederkosher.model.common.dao.StateDao;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.StateCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Egor on 19.08.2016.
 */
@Service("stateCRUDService")
@Transactional
public class StateCRUDServiceImpl implements StateCRUDService {

    @Autowired
    private StateDao stateDao;

    private ServiceResult result;

    @Override
    public ServiceResult findByID(long id) {
        State state = stateDao.getById(id);
        if (state == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(id);
            result.setDescription("state with id = " + id + " not found");
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(state);
        return result;
    }

    @Override
    public ServiceResult findByCode(String code) {
        State state = stateDao.getByCode(code);
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
        result = ServiceResultFactory.OK;
        result.setData(stateDao.getAllStates());
        return result;
    }

    @Override
    public ServiceResult createState(State state) {
//        if (stateDao.isUserExist(state)) {
//            result = ServiceResultFactory.ENTITY_CONFLICT;
//        } else {
            if (stateDao.add(state)) {
                result = ServiceResultFactory.OK;
            } else {
                result = ServiceResultFactory.CREATING_ERROR;
            }
//        }
        result.setData(state);
        return result;
    }

    @Override
    public ServiceResult updateState(State state) {
//        State currentState = stateDao.getById(state.getId());
//        if (currentState == null) {
//            result = ServiceResultFactory.NOT_FOUND;
//            result.setData(state);
//            return result;
//        }
//
//        currentState.setCode(state.getCode());
//        currentState.setName(state.getName());

        //if (stateDao.updateState(currentState)) {
        //    result = ServiceResultFactory.OK;
        //} else {
            result = ServiceResultFactory.UPDATING_ERROR;
        //}
        //result.setData(currentState);
        return result;
    }

    @Override
    public ServiceResult deleteState(long id) {
        State currentState = stateDao.getById(id);
        if (currentState == null) {
            result = ServiceResultFactory.NOT_FOUND;
            result.setData(id);
            return result;
        }

        if (stateDao.delete(currentState)) {
            result = ServiceResultFactory.OK;
        } else {
            result = ServiceResultFactory.DELETING_ERROR;
        }
        result.setData(id);
        return result;
    }

}
