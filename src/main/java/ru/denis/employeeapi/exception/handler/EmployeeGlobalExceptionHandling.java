package ru.denis.employeeapi.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.denis.employeeapi.exception.EmployeeNotSuchException;
import ru.denis.employeeapi.exception.UnknowValidationException;

import java.util.Map;

@ControllerAdvice
public class EmployeeGlobalExceptionHandling {
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleException(EmployeeNotSuchException exception) {
        return new ResponseEntity<>(Map.of("info", exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleException(UnknowValidationException exception) {
        return new ResponseEntity<>(Map.of("info", exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
