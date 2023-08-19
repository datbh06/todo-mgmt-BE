package com.yugen.todomgmtbe.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * This class represents a data transfer object for error details.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    /**
     * The timestamp of the error.
     */
    private LocalDateTime timestamp;

    /**
     * The message of the error.
     */
    private String message;

    /**
     * The details of the error.
     */
    private String details;
}
