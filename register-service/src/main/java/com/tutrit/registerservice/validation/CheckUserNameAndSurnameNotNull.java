package com.tutrit.registerservice.validation;


import com.tutrit.registerservice.bean.User;
import com.tutrit.registerservice.exception.UserValidationException;

public class CheckUserNameAndSurnameNotNull implements UserCheckable {
    @Override
    public void check(User user) throws UserValidationException {
        if (user.getName() == null || user.getSurname() == null) {
            throw new UserValidationException("Name or Surname User can't be null!!");
        }
    }
}
