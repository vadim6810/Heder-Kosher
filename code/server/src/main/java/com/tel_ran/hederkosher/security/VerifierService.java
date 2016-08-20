package com.tel_ran.hederkosher.security;

public interface VerifierService {
    boolean checkAuthority(String authName);
    boolean checkAuthority(String authName, String room);
}
