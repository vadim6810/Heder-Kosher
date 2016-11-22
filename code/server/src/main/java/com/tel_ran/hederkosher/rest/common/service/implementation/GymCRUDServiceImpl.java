package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.GymDao;
import com.tel_ran.hederkosher.model.common.entity.Gym;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.GymRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.Type;
import static com.tel_ran.hederkosher.rest.ServiceResultFactory.getResultObject;

@Service("gymCRUDService")
public class GymCRUDServiceImpl implements GymRESTService {

    @Autowired
    private GymDao gymDao;

    private ServiceResult result;

    @Override
    public ServiceResult findGymByID(long id) {
        Gym gym=null;
        try {
            gym= gymDao.getById(id);
        } catch (TemplateNotFoundException e) {
            result = getResultObject(Type.NOT_FOUND);
            result.setData(id);
            result.setDescription(e.getMessage());
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(gym);
        return result;
    }

    @Override
    public ServiceResult getByName(String name) {
        result = getResultObject(Type.OK);
        result.setData(gymDao.getByName(name));
        return result;
    }

    @Override
    public ServiceResult getAllGyms() {
        result = getResultObject(Type.OK);
        result.setData(gymDao.getAllGyms());
        return result;
    }


    @Override
    public ServiceResult createGym(Gym gym) {
        if (gymDao.addGym(gym)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(gym);
        return result;
    }

    @Override
    public ServiceResult updateGym(Gym gym) {
        if (gymDao.updateGym(gym)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.UPDATING_ERROR);
        }
        result.setData(gym);
        return result;
    }

    @Override
    public ServiceResult deleteGym(long id) {
// delete address ??????
       if (gymDao.deleteGym(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(id);
        return result;
    }

    @Override
    public ServiceResult deleteAllGyms() {
        if (gymDao.deleteAllGyms()) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
//        result.setData();
        return result;
    }

}
