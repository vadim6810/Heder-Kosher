package com.tel_ran.hederkosher.rest.common.service;

import com.tel_ran.hederkosher.model.common.entity.Address;
import com.tel_ran.hederkosher.rest.ServiceResult;

public interface AddressRESTService {
    //CRUD ALL
    ServiceResult getAllAddresses();
    ServiceResult getByNames(String country, String city, String street, String building, String apartment, String postalCode);
    ServiceResult getByAnyName(String name);
    ServiceResult deleteAllAddresses();

    //CRUD ID
    ServiceResult createAddress(Address address);
    ServiceResult findAddressByID(long id);
    ServiceResult updateAddress(Address address);
    ServiceResult deleteAddress(long id);


    //CRUD for PERSON
    ServiceResult createAddressByPerson(long idPerson,Address address);
//    ServiceResult setAddressToPerson(long idPerson,long id);
    ServiceResult getAddressesByPerson(long idPerson);
    ServiceResult deleteAddressesByPerson(long idPerson);

    //CRUD for ROOM
    ServiceResult createAddressByRoom(long idRoom,Address address);
//    ServiceResult setAddressToRoom(long idRoom,long id);
    ServiceResult getAddressesByRoom(long idRoom);
    ServiceResult deleteAddressesByRoom(long idRoom);


    //CRUD for GYM
    ServiceResult createAddressByGym(long idGym,Address address);
//    ServiceResult setAddressToGym(long idGym,long id);
    ServiceResult getAddressesByGym(long idGym);
    ServiceResult deleteAddressesByGym(long idGym);

}
