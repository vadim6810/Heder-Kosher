package com.tel_ran.hederkosher.annotations;

import com.tel_ran.hederkosher.model.Room;

import java.lang.annotation.*;

/**
 * Created by Igor on 12.08.2016.
 */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckSecurity {
    Actions requiredAction();
}
