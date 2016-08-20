package com.tel_ran.hederkosher.security;

import com.tel_ran.hederkosher.model.Room;
import com.tel_ran.hederkosher.model.security.Authority;
import com.tel_ran.hederkosher.model.security.Role;
import com.tel_ran.hederkosher.model.security.UserGrantedAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by Igor on 13.08.2016.
 */

@Component("Verifier")
public class VerifierComponent implements VerifierService {

    Logger logger = LoggerFactory.getLogger(VerifierComponent.class);
    @Override
    public boolean checkAuthority(String authName) {
        logger.info("Auth name = "+authName);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Auth = " + auth);
        if (auth == null) return false;

        for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            logger.info("role = " + grantedAuthority);
            for (Authority authority : ((UserGrantedAuthority)grantedAuthority).getRole().getAuthorities()) {
                logger.info("authority = " + authority.getName());
                if (authName.equals(authority.getName()))
                    return true;
            }
        }
        return false;
    }

    public boolean checkAuthority(String authName, String roomName) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) return false;
        for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            Role role = ((UserGrantedAuthority) grantedAuthority).getRole();
            Room room = ((UserGrantedAuthority) grantedAuthority).getRoom();
            if (role.getName().equals(authName) &&
                room.getName().equals(roomName))
                    return true;
        }
        return false;
    }
}
