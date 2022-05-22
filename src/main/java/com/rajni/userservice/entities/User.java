package com.rajni.userservice.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import static com.rajni.userservice.util.DBConstants.*;

@Entity
@Table(name = USER_TABLE)
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = USER_ID_COL)
    private int userId;

    @Column(name = FIRST_NAME_COL, nullable = false)
    private String firstName;

    @Column(name = LAST_NAME_COL)
    private String lastName;

    @Column(name = USER_NAME_COL, length = 20, nullable = false, unique = true)
    private String userName;

    @Column(name = PASSWORD_COL, nullable = false, length = 20)
    private String password;

    @Column(name = DATE_OF_BIRTH_COL, nullable = false)
    private LocalDateTime dateOfBirth;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = USER_CONTACT_TABLE, joinColumns = @JoinColumn(name = USER_ID_COL))
    @Column(name = MOBILE_NUMBERS_COL, nullable = false)
    private Set<Integer> phoneNumbers;
}
