package com.tel_ran.hederkosher.service.security;

import com.tel_ran.hederkosher.service.serviceResult;

/**
 * Created by Igor on 05.08.2016.
 */
public interface UserActionsService {
    serviceResult login();
    serviceResult logout();
}
