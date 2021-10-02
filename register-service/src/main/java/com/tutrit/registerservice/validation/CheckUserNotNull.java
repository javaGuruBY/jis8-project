package com.tutrit.registerservice.validation;

import com.tutrit.registerservice.bean.User;
import com.tutrit.registerservice.exception.UserValidationException;

public class CheckUserNotNull implements UserCheckable {
    @Override
    public void check(User user) throws UserValidationException {
        if (user == null) {
            throw new UserValidationException("User must be not null!!");
        }
    }
}
