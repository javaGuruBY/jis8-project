package com.tutrit.registerservice.validation;

import com.tutrit.registerservice.bean.User;
import com.tutrit.registerservice.exception.UserValidationException;
import java.util.List;

public class UserValidator {

    private static final List<UserCheckable> userCheck = List.of(
            new CheckUserNotNull(),
            new CheckUserNameAndSurnameNotNull(),
//            new CheckUserNameAndSurnameLength(),
            new CheckUserSlot()
    );

    private UserValidator() {
    }

    public static void validation(User user) throws UserValidationException {
        userCheck.forEach(u -> u.check(user));
    }
}
