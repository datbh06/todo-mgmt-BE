package com.yugen.todomgmtbe.controller;

import com.yugen.todomgmtbe.dto.LoginDto;
import com.yugen.todomgmtbe.dto.RegisterDto;
import com.yugen.todomgmtbe.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class represents the REST controller for managing authentication.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    /**
     * Registers a new user.
     *
     * @param registerDto the registration data transfer object
     * @return a ResponseEntity object containing the result of the registration
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Logs in a user.
     *
     * @param loginDto the login data transfer object
     * @return a ResponseEntity object containing the result of the login
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String response = authService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
