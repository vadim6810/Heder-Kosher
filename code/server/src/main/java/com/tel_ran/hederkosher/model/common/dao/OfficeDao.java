/**
 * Created by Ruslan on 30.08.2016.
 */

package com.tel_ran.hederkosher.model.common.dao;

import com.tel_ran.hederkosher.model.common.entity.Office;

import java.util.List;

public interface OfficeDao {
        boolean addOffice(Office obj);
        boolean updateOffice(Office obj);
        boolean deleteOffice(Office obj);
        Office getById(long id);
        Office getByName(String name);
        List<Office> getAllOffices();
}
