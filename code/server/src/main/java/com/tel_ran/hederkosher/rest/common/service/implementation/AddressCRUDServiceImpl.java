package com.tel_ran.hederkosher.rest.common.service.implementation;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.dao.AddressDao;
import com.tel_ran.hederkosher.model.common.dao.GymDao;
import com.tel_ran.hederkosher.model.common.dao.PersonDao;
import com.tel_ran.hederkosher.model.common.dao.RoomDao;
import com.tel_ran.hederkosher.model.common.entity.Address;
import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.ServiceResultFactory;
import com.tel_ran.hederkosher.rest.common.service.AddressRESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.tel_ran.hederkosher.rest.ServiceResultFactory.Type;
import static com.tel_ran.hederkosher.rest.ServiceResultFactory.getResultObject;

@Service("addressCRUDService")
public class AddressCRUDServiceImpl implements AddressRESTService {

    @Autowired
    private AddressDao addressDao;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private RoomDao roomDao;
    @Autowired
    private GymDao gymDao;

    private ServiceResult result;

    //CRUD ALL
    @Override
    public ServiceResult getAllAddresses() {
        result = getResultObject(Type.OK);
        result.setData(addressDao.getAllAddresses());
        return result;
    }
    @Override
    public ServiceResult getByNames(String country, String city, String street, String building, String apartment, String postalCode) {
        result = getResultObject(Type.OK);
        result.setData(addressDao.getByNames(country, city, street,building,apartment, postalCode));
        return result;
    }
    @Override
    public ServiceResult getByAnyName(String name) {
        result = getResultObject(Type.OK);
        result.setData(addressDao.getByAnyName(name));
        return result;
    }
    @Override
    public ServiceResult deleteAllAddresses() {
        if (addressDao.deleteAllAddresses()) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
//        result.setData();
        return result;
    }

    //CRUD ID
    @Override
    public ServiceResult createAddress(Address address) {
        if (addressDao.addAddress(address)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(address);
        return result;
    }
    @Override
    public ServiceResult findAddressByID(long id) {
        Address address=null;
        try {
            address= addressDao.getById(id);
        } catch (TemplateNotFoundException e) {
            result = getResultObject(Type.NOT_FOUND);
            result.setData(id);
            result.setDescription(e.getMessage());
            return result;
        }
        result = ServiceResultFactory.OK;
        result.setData(address);
        return result;
    }
    @Override
    public ServiceResult updateAddress(Address address) {
        if (addressDao.updateAddress(address)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.UPDATING_ERROR);
        }
        result.setData(address);
        return result;
    }
    @Override
    public ServiceResult deleteAddress(long id) {
        if (addressDao.deleteAddress(id)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(id);
        return result;
    }



    //CRUD for PERSON
    @Override
    public ServiceResult createAddressByPerson(long idPerson, Address address) {
        if (addressDao.addAddress(address) && personDao.addAddressByPerson(idPerson,address)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(address);
        return result;
    }
    @Override
    public ServiceResult getAddressesByPerson(long idPerson) {
        result = getResultObject(Type.OK);
        result.setData(addressDao.getAddressesByPerson(idPerson));
        return result;
    }
    @Override
    public ServiceResult deleteAddressesByPerson(long idPerson) {
        if (addressDao.deleteAddressesByPerson(idPerson)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(idPerson);
        return result;
    }
//    @Override
//    public ServiceResult setAddressToPerson(long idPerson, long id) {
//        return null;
//    }


    //CRUD for ROOM
    @Override
    public ServiceResult createAddressByRoom(long idRoom, Address address) {
        if (addressDao.addAddress(address) && roomDao.addAddressByRoom(idRoom,address)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(address);
        return result;
    }
    @Override
    public ServiceResult getAddressesByRoom(long idRoom) {
        result = getResultObject(Type.OK);
        result.setData(addressDao.getAddressesByRoom(idRoom));
        return result;
    }
    @Override
    public ServiceResult deleteAddressesByRoom(long idRoom) {
        if (addressDao.deleteAddressesByRoom(idRoom)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(idRoom);
        return result;
    }
//    @Override
//    public ServiceResult setAddressToRoom(long idRoom, long id) {
//        return null;
//    }


    //CRUD for GYM
    @Override
    public ServiceResult createAddressByGym(long idGym, Address address) {
        if (addressDao.addAddress(address) && gymDao.addAddressByGym(idGym,address)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.CREATING_ERROR);
        }
        result.setData(address);
        return result;
    }
    @Override
    public ServiceResult getAddressesByGym(long idGym) {
        result = getResultObject(Type.OK);
        result.setData(addressDao.getAddressesByGym(idGym));
        return result;
    }
    @Override
    public ServiceResult deleteAddressesByGym(long idGym) {
        if (addressDao.deleteAddressesByGym(idGym)) {
            result = getResultObject(Type.OK);
        } else {
            result = getResultObject(Type.DELETING_ERROR);
        }
        result.setData(idGym);
        return result;

    }

//    @Override
//    public ServiceResult setAddressToGym(long idGym, long id) {
//        return null;
//    }

}
