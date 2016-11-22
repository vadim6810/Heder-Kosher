package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Gym;
import com.tel_ran.hederkosher.rest.ServiceResult;

public interface GymRESTService {
    ServiceResult createGym(Gym gym);
    ServiceResult updateGym(Gym gym);
    ServiceResult deleteGym(long id);
    ServiceResult deleteAllGyms();

    ServiceResult findGymByID(long id);

    ServiceResult getByName(String name);
    ServiceResult getAllGyms();

}
