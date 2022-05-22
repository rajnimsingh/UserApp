package com.rajni.userservice.service;

import com.rajni.userservice.dao.UserDao;
import com.rajni.userservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User getUserByID(int userID) {
        final Optional<User> optionalUser = userDao.findById(userID);
        return optionalUser.orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        User existingUser = getUserByID(user.getUserId());
        if(existingUser != null) {
            return userDao.save(user);
        }
        return null;
    }

    @Override
    public User deleteUserByID(int userID) {
        User existingUser = getUserByID(userID);
        if(existingUser != null) {
            userDao.delete(existingUser);
            return existingUser;
        }
        return null;
    }

    @Override
    public User deleteUser(User user) {
        User existingUser = getUserByID(user.getUserId());
        if(existingUser != null) {
            userDao.delete(existingUser);
            return existingUser;
        }
        return null;
    }
}
