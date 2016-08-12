package com.tel_ran.hederkosher.annotations;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
public @interface RoleAdmin {
}
