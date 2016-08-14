package com.tel_ran.hederkosher.rest.security;

import com.tel_ran.hederkosher.rest.ServiceResult;

/**
 * Created by Igor on 05.08.2016.
 */
public interface UserActionsService {
    ServiceResult login();
    ServiceResult logout();
}
