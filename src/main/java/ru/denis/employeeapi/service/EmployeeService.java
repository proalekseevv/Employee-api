package ru.denis.employeeapi.service;

import ru.denis.employeeapi.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAll();

    EmployeeDTO getById(Long id);

    EmployeeDTO getByName(String name);

    EmployeeDTO saveOrUpdate(EmployeeDTO employeeDTO);

    void deleteById(Long id);
}
