/**
 * Created by Ruslan on 30.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.exception.TemplateNotFoundException;
import com.tel_ran.hederkosher.model.common.entity.Address;

import java.util.List;

public interface AddressDao {
        boolean addAddress(Address obj);
        boolean updateAddress(Address obj);
        boolean deleteAddress(long id);
        boolean deleteAllAddresses();

        Address getById(long id) throws TemplateNotFoundException;

        List<Address> getByNames(String country, String city, String street, String building, String apartment, String postalCode);
        List<Address> getByAnyName(String name);
        List<Address> getAllAddresses();

        List<Address> getAddressesByPerson(long personId);
        boolean deleteAddressesByPerson(long personId);

        List<Address> getAddressesByRoom(long roomId);
        boolean deleteAddressesByRoom(long roomId);

        List<Address> getAddressesByGym(long gymId);
        boolean deleteAddressesByGym(long gymId);
}
