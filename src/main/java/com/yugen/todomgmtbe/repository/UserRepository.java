package com.yugen.todomgmtbe.repository;

import com.yugen.todomgmtbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by its username.
     *
     * @param username the username of the user to find
     * @return the user with the given username
     */
    Optional<User> findByUsername(String username);

    /**
     * Checks if a user exists by its email.
     *
     * @param email the email of the user to check
     * @return true if the email exists, false otherwise
     */
    Boolean existsByEmail(String email);

    /**
     * Finds a user by its username or email.
     *
     * @param username the username of the user to find
     * @param email    the email of the user to find
     * @return the user with the given username or email
     */
    Optional<User> findByUsernameOrEmail(String username, String email);

    /**
     * Checks if a user exists by its username.
     *
     * @param username the username of the user to check
     * @return true if the username exists, false otherwise
     */
    Boolean existsByUsername(String username);

}
