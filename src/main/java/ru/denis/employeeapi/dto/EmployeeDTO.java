package ru.denis.employeeapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Field name is required")
    @Size(max = 40, message = "Field name must been less than 40 letters")
    private String name;

    @NotBlank(message = "Field surname is required")
    @Size(max = 40, message = "Field surname must been less than 40 letters")
    private String surname;

    @NotBlank(message = "Field department is required")
    @Size(max = 70, message = "Field department must been less than 70 letters")
    private String department;

    @Min(value = 400, message = "Min salary is 400$")
    @Max(value = 15000, message = "Max salary is 15000$")
    private Integer salary;

    @JsonFormat(pattern = "hh:mm:ss dd.MM.yyyy")
    private LocalDateTime creationTime;
}
