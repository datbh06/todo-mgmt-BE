package com.yugen.todomgmtbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents the data transfer object for login.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    /**
     * The username or email of the user.
     */
    private String usernameOrEmail;

    /**
     * The password of the user.
     */
    private String password;
}
