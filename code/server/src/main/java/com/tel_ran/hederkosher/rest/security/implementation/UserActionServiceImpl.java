package com.tel_ran.hederkosher.rest.security.implementation;

import com.tel_ran.hederkosher.rest.ServiceResult;
import com.tel_ran.hederkosher.rest.security.UserActionsService;
import org.springframework.stereotype.Service;

/**
 * Created by Igor on 05.08.2016.
 */

@Service("userActionService")
public class UserActionServiceImpl implements UserActionsService{
    @Override
    public ServiceResult login() {
        return null;
    }

    @Override
    public ServiceResult logout() {
        return null;
    }
}
