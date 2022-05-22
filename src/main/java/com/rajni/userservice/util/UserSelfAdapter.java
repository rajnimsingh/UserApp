package com.rajni.userservice.util;

import com.rajni.userservice.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserSelfAdapter implements Adapter<User, User> {

    @Override
    public User convertFrom(User user) {
        User newUser = new User();
        newUser.setUserId(user.getUserId());
        newUser.setUserName(user.getUserName());
        newUser.setDateOfBirth(user.getDateOfBirth());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumbers(user.getPhoneNumbers());
        return newUser;
    }
}
