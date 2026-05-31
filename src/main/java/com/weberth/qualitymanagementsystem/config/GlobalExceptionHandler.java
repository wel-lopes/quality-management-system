package com.weberth.qualitymanagementsystem.config;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import com.weberth.qualitymanagementsystem.exception.InspectionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;
import java.util.Arrays;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .toList();

        ValidationErrorResponse response = new ValidationErrorResponse(
                "Validation failed",
                errors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    public record ValidationErrorResponse(
            String message,
            List<String> errors
    ) {
    }

    @ExceptionHandler(InspectionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInspectionNotFound(InspectionNotFoundException exception) {
        ErrorResponse response = new ErrorResponse(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    public record ErrorResponse(
            String message
    ) {
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidEnum(HttpMessageNotReadableException exception) {
        String validStatus = Arrays.toString(
                com.weberth.qualitymanagementsystem.enums.InspectionStatus.values()
        );

        ErrorResponse response = new ErrorResponse(
                "Invalid request format. Status must be one of: " +validStatus
        );

        return ResponseEntity
                .status( HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
