package com.amigoscode.order.exception;

// TODO: 7 - Create a global exception handler:
//  - Annotate with @ControllerAdvice
//  - Add an @ExceptionHandler(OrderNotFoundException.class) method
//    that returns ResponseEntity<ApiError>
//  - Build an ApiError with the request path, exception message, 404 status, and current timestamp
//  Hint: inject HttpServletRequest to get the request path

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

// TODO: 8 - Add another @ExceptionHandler for MethodArgumentNotValidException:
//  - Extract field errors from the exception
//  - Build a message string with all field errors: "field: message; field: message"
//  - Return a 400 Bad Request response with ApiError
//  Hint: ex.getBindingResult().getFieldErrors()
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ApiError> handleOrderNotFoundException(
            OrderNotFoundException exception,
            HttpServletRequest request) {
        ApiError apiError = new ApiError(
                request.getRequestURI(),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception, HttpServletRequest request) {
        String message = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ApiError apiError = new ApiError(
                request.getRequestURI(),
                message,
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now());
        return ResponseEntity.status(400).body(apiError);

    }

}
