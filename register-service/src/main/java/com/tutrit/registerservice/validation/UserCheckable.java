package com.tutrit.registerservice.validation;

import com.tutrit.registerservice.bean.User;
import com.tutrit.registerservice.exception.UserValidationException;

public interface UserCheckable {

    void check(User user) throws UserValidationException;
}
