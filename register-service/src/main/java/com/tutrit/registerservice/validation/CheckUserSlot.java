package com.tutrit.registerservice.validation;

import com.tutrit.registerservice.bean.User;
import com.tutrit.registerservice.exception.UserValidationException;

public class CheckUserSlot implements UserCheckable {
    @Override
    public void check(User user) throws UserValidationException {
        if (user.getSlots() == null) {
            throw new UserValidationException("Slot can't be null!!");
        }
    }
}
