package com.tel_ran.hederkosher.security;

/**
 * Created by Igor on 14.08.2016.
 */
public class UserLoginInfo {
    private String email;
    private String passHash;

    public UserLoginInfo() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}
