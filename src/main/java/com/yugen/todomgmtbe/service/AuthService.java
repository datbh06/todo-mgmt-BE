package com.yugen.todomgmtbe.service;

import com.yugen.todomgmtbe.dto.RegisterDto;

/**
 * This interface represents the service layer for managing authentication.
 */
public interface AuthService {

    /**
     * Registers a new user.
     *
     * @param registerDto the registration data transfer object
     * @return a string representing the result of the registration
     */
    String register(RegisterDto registerDto);
}
