package com.yugen.todomgmtbe.service.imp;

import com.yugen.todomgmtbe.dto.RegisterDto;
import com.yugen.todomgmtbe.entity.Role;
import com.yugen.todomgmtbe.entity.User;
import com.yugen.todomgmtbe.exception.TodoAPIException;
import com.yugen.todomgmtbe.repository.RoleRepository;
import com.yugen.todomgmtbe.repository.UserRepository;
import com.yugen.todomgmtbe.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents the service layer implementation for managing authentication.
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public String register(RegisterDto registerDto) {

        //Check username exists or not
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        //Check email exists or not
        if (userRepository.existsByEmail(registerDto.getEmail())) {
            throw new TodoAPIException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);
        return "User registered successfully";
    }
}
