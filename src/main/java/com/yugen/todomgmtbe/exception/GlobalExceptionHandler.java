package com.yugen.todomgmtbe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * This class represents a global exception handler for the TodoAPI.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Handles TodoAPIException exceptions.
     *
     * @param ex      the TodoAPIException exception
     * @param request the WebRequest object
     * @return a ResponseEntity object containing the error details
     */
    @ExceptionHandler(TodoAPIException.class)
    public ResponseEntity<ErrorDetails> handleTodoAPIException(TodoAPIException ex, WebRequest request) {
        ErrorDetails errorDetail = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }
}
