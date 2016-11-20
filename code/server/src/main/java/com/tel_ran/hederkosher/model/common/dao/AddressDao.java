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
        Address getById(long id) throws TemplateNotFoundException;
        List<Address> getByName(String name);
        List<Address> getAllAddresses();
}
