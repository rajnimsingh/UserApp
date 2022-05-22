package com.rajni.userservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@ToString
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private int userID;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private LocalDateTime dateOfBirth;
    private Set<Integer> phoneNumbers;
}
