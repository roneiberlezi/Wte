package com.sap.wte.validators;

import com.sap.wte.models.User;
import com.sap.wte.services.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.annotation.Resource;

/**
 * Created by I863273 on 01/08/2017.
 */
public class UserValidator implements Validator {

    @Resource
    UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if(!user.getPassword().equals(user.getPasswordConfirm())){
            errors.rejectValue("passwordConfirm", "Diff.user.passwordConfirm");
        }

        if(user.getPassword().length() < 6){
            errors.rejectValue("password", "Size.user.password");
        }

        if(!user.getPassword().matches("^(?=.*\\d)(?=.*[a-z]).{6,255}$")){
            errors.rejectValue("password", "Pattern.user.password");
        }

        if (userService.findUserByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "Duplicate.user.email");
        }
    }
}
