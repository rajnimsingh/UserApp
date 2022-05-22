package com.rajni.userservice.util;

import com.rajni.userservice.dto.UserDTO;
import com.rajni.userservice.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityDTOAdapter implements BIAdapter<User, UserDTO> {

    @Override
    public UserDTO convertFrom(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(user.getUserId());
        userDTO.setUsername(user.getUserName());
        userDTO.setPassword(user.getPassword());
        userDTO.setDateOfBirth(user.getDateOfBirth());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumbers(user.getPhoneNumbers());
        return userDTO;
    }

    @Override
    public User retraceBack(UserDTO userDTO) {
        User user = new User();
        user.setUserId(userDTO.getUserID());
        user.setUserName(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setDateOfBirth(userDTO.getDateOfBirth());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumbers(userDTO.getPhoneNumbers());
        return user;
    }
}
