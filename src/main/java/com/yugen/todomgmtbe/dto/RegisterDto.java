package com.yugen.todomgmtbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents a data transfer object for user registration.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    /**
     * The name of the user.
     */
    private String name;

    /**
     * The username of the user.
     */
    private String username;

    /**
     * The email of the user.
     */
    private String email;

    /**
     * The password of the user.
     */
    private String password;
}
