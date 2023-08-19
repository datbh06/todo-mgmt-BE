package com.yugen.todomgmtbe.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * This class represents a custom exception that is thrown by the TodoAPI.
 */
@Getter
@AllArgsConstructor
public class TodoAPIException extends RuntimeException {
    /**
     * The HTTP status of the exception.
     */
    private HttpStatus httpStatus;

    /**
     * The detail message of the exception.
     */
    private String message;
}
