package ru.denis.employeeapi.exception;

public class UnknowValidationException extends RuntimeException {
    public UnknowValidationException(String message) {
        super(message);
    }
}
