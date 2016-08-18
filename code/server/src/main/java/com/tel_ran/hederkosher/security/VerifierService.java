package com.tel_ran.hederkosher.security;

import com.tel_ran.hederkosher.model.Room;
import org.springframework.security.core.userdetails.UserDetails;

public interface VerifierService {
    boolean checkAuthority(String authName);
    //boolean checkAuthority(String authName, Room room);
}
