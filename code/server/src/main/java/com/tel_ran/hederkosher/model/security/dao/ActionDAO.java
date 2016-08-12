package com.tel_ran.hederkosher.model.security.dao;

import com.tel_ran.hederkosher.model.security.Action;

import java.util.List;

/**
 * Created by Igor on 07.08.2016.
 */
public interface ActionDAO {
    Action findById(long id);
    List<Action> getAllActions();
}
