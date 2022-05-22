package com.rajni.userservice.controller;

import com.rajni.userservice.dto.UserDTO;
import com.rajni.userservice.entities.User;
import com.rajni.userservice.service.UserService;
import com.rajni.userservice.util.UserEntityDTOAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user_service/v1")
public class UserController {

    private final UserService userService;

    private final UserEntityDTOAdapter userEntityDTOAdapter;

    @Autowired
    public UserController(UserService userService, UserEntityDTOAdapter userEntityDTOAdapter) {
        this.userService = userService;
        this.userEntityDTOAdapter = userEntityDTOAdapter;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Ping Successful";
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userEntityDTOAdapter.retraceBack(userDTO);
        user = userService.createUser(user);
        if (user != null) {
            UserDTO createdObject = userEntityDTOAdapter.convertFrom(user);
            return new ResponseEntity<>(createdObject, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "/user/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> findUser(@PathVariable("userID") int userID) {
        ResponseEntity<UserDTO> responseEntity = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        User user = userService.getUserByID(userID);
        if (user != null) {
            UserDTO createdObject = userEntityDTOAdapter.convertFrom(user);
            responseEntity = new ResponseEntity<>(createdObject, HttpStatus.ACCEPTED);
        }
        return responseEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> resultList = new ArrayList<>();
        users.forEach(u -> resultList.add(userEntityDTOAdapter.convertFrom(u)));
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @PutMapping(value = "/user/{userID}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@PathVariable("userID") int userID, @RequestBody UserDTO userDTO) {
        User existingUser = userService.getUserByID(userID);
        if (existingUser != null) {
            User user = userEntityDTOAdapter.retraceBack(userDTO);
            user.setUserId(userID);
            user = userService.updateUser(user);
            if (user != null) {
                UserDTO updatedObject = userEntityDTOAdapter.convertFrom(user);
                return new ResponseEntity<>(updatedObject, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping(value = "/user/{userID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("userID") int userID) {
        User existingUser = userService.getUserByID(userID);
        if (existingUser != null) {
            existingUser = userService.deleteUser(existingUser);
            if (existingUser != null) {
                UserDTO updatedObject = userEntityDTOAdapter.convertFrom(existingUser);
                return new ResponseEntity<>(updatedObject, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
    }
}
