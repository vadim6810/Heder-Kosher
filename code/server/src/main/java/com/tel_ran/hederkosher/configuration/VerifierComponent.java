package com.tel_ran.hederkosher.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Igor on 13.08.2016.
 */

@Component("Verifier")
public class VerifierComponent implements VerifierService {
    @Override
    public boolean checkAuthority(UserDetails principal, String authName) {
        return false;
    }
}
