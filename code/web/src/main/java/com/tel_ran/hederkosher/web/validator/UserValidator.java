package com.tel_ran.hederkosher.web.validator;

import com.tel_ran.hederkosher.web.model.User;
import com.tel_ran.hederkosher.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Ruslan on 10/02/17.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","Required");
        if (user.getUsername().length()<8 || user.getUsername().length()>32) {
            errors.rejectValue("username","Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername())!=null) {
            errors.rejectValue("username","Dublicate.userForm.username");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Required");
        if (user.getPassword().length()<8 || user.getPassword().length()>32) {
            errors.rejectValue("password","Size.userForm.password");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword","Different.userForm.password");
        }

    }
}
