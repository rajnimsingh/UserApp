package com.rajni.userservice.service;

import com.rajni.userservice.entities.User;

import java.util.List;

public interface UserService {
    User getUserByID(int userID);

    List<User> getAllUsers();

    User createUser(User user);

    User updateUser(User user);

    User deleteUserByID(int userID);

    User deleteUser(User user);


}
