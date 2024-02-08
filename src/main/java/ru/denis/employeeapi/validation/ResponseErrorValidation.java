package ru.denis.employeeapi.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import ru.denis.employeeapi.exception.UnknowValidationException;

import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseErrorValidation {
    public Map<String, String> validate(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                errorMap.put(fieldError.getField() + "Error", fieldError.getDefaultMessage());
            }
            return errorMap;
        } else throw new UnknowValidationException("Unknow validate error");
    }
}
