package com.tel_ran.hederkosher.service.security.implementation;

import com.tel_ran.hederkosher.service.ServiceResult;
import com.tel_ran.hederkosher.service.security.UserActionsService;
import org.springframework.stereotype.Service;

/**
 * Created by Igor on 05.08.2016.
 */

@Service("UserActionService")
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
