package com.tel_ran.hederkosher.security;

import com.tel_ran.hederkosher.model.Room;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by Igor on 13.08.2016.
 */

@Component("Verifier")
public class VerifierComponent implements VerifierService {

    @Override
    public boolean checkAuthority(String authName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) return false;
        for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            if (authName.equals(grantedAuthority.getAuthority()))
                return true;
        }
        return false;
    }
}
