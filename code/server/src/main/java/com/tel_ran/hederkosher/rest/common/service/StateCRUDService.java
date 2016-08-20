package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.State;
import com.tel_ran.hederkosher.rest.ServiceResult;

/**
 * Created by Egor on 19.08.2016.
 */

public interface StateCRUDService {
    ServiceResult findByID(long id);
    ServiceResult findByCode(String code);

    ServiceResult findAllStates();

    ServiceResult createState(State state);
    ServiceResult updateState(State state);
    ServiceResult deleteState(long id);

}
