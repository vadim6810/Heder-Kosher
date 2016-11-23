package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.OfficeDao;
import com.tel_ran.hederkosher.model.common.entity.Office;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.OfficeRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.Type;
import static com.tel_ran.hederkosher.rest.ServiceResultFactory.getResultObject;

@Service("officeCRUDService")
public class OfficeCRUDServiceImpl implements OfficeRESTService {

    @Autowired
    private OfficeDao officeDao;

    private ServiceResult result;

    @Override
    public ServiceResult findOfficeByID(long id) {
        Office office=null;
        try {
            office= officeDao.getById(id);
        } catch (TemplateNotFoundException e) {
            result = getResultObject(Type.NOT_FOUND);
            result.setData(id);
            result.setDescription(e.getMessage());
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(office);
        return result;
    }

    @Override
    public ServiceResult getByName(String name) {
        result = getResultObject(Type.OK);
        result.setData(officeDao.getByName(name));
        return result;
    }

    @Override
    public ServiceResult getAllOffices() {
        result = getResultObject(Type.OK);
        result.setData(officeDao.getAllOfficesActives());
        return result;
    }


    @Override
    public ServiceResult createOffice(Office office) {
        if (officeDao.addOffice(office)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(office);
        return result;
    }

    @Override
    public ServiceResult updateOffice(Office office) {
        if (officeDao.updateOffice(office)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.UPDATING_ERROR);
        }
        result.setData(office);
        return result;
    }

    @Override
    public ServiceResult deleteOffice(long id) {
       if (officeDao.deleteOffice(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(id);
        return result;
    }

    @Override
    public ServiceResult deleteAllOffices() {
        if (officeDao.deleteAllOffices()) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
//        result.setData();
        return result;
    }

}
