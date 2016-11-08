package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.rest.ServiceResult;

public interface StateCRUDService {
    ServiceResult findStateByCode(String code);
    ServiceResult findAllStates();
}
