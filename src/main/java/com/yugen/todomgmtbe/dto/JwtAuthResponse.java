package com.yugen.todomgmtbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents a data transfer object for a JWT authentication response.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthResponse {
    /**
     * The access token.
     */
    private String accessToken;

    /**
     * The token type.
     */
    private final String tokenType = "Bearer";

    /**
     * The user's role.
     */
    private String role;
}
