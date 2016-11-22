/**
 * Created by Ruslan on 30.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.entity.Address;
import com.tel_ran.hederkosher.model.common.entity.Gym;

import java.util.List;

public interface GymDao {
        boolean addGym(Gym obj);
        boolean updateGym(Gym obj);
        boolean deleteGym(long id);
        boolean deleteAllGyms();

        Gym getById(long id) throws TemplateNotFoundException;
        List<Gym> getByName(String name);
        List<Gym> getAllGyms();

        boolean addAddressByGym(long gymId, Address address);
}
