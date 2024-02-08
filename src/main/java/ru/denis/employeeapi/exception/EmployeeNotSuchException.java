package ru.denis.employeeapi.exception;

public class EmployeeNotSuchException extends RuntimeException {
    public EmployeeNotSuchException(String message) {
        super(message);
    }
}
