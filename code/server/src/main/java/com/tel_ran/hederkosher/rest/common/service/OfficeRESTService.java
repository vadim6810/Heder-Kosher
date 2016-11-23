package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Office;
import com.tel_ran.hederkosher.rest.ServiceResult;

public interface OfficeRESTService {
    ServiceResult createOffice(Office office);
    ServiceResult updateOffice(Office office);
    ServiceResult deleteOffice(long id);
    ServiceResult deleteAllOffices();

    ServiceResult findOfficeByID(long id);

    ServiceResult getByName(String name);
    ServiceResult getAllOffices();

}
