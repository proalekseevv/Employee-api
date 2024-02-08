package ru.denis.employeeapi.mapper;


import org.springframework.stereotype.Component;
import ru.denis.employeeapi.dto.EmployeeDTO;
import ru.denis.employeeapi.entity.Employee;

@Component
public class EmployeeMapper {
    public Employee toEmployee(EmployeeDTO employeeDTO) {
        return Employee.builder()
                .id(employeeDTO.getId())
                .name(employeeDTO.getName())
                .surname(employeeDTO.getSurname())
                .salary(employeeDTO.getSalary())
                .department(employeeDTO.getDepartment())
                .build();
    }

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .salary(employee.getSalary())
                .department(employee.getDepartment())
               .creationTime(employee.getCreationTime())
                .build();
    }
}
