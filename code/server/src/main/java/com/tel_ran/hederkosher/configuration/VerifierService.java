package com.tel_ran.hederkosher.configuration;

import org.springframework.security.core.userdetails.UserDetails;

public interface VerifierService {
    boolean checkAuthority(UserDetails principal, String authName);
}
