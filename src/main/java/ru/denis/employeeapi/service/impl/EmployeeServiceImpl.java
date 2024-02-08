package ru.denis.employeeapi.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.denis.employeeapi.dto.EmployeeDTO;
import ru.denis.employeeapi.entity.Employee;
import ru.denis.employeeapi.exception.EmployeeNotSuchException;
import ru.denis.employeeapi.mapper.EmployeeMapper;
import ru.denis.employeeapi.repository.EmployeeRepository;
import ru.denis.employeeapi.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> getAll() {
        log.info("Get all Employees");
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toEmployeeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getById(Long id) {
        log.info("Get Employee by id: {}", id);
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotSuchException("Not found Employee with id " + id));
        return employeeMapper.toEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO getByName(String name) {
        log.info("Get Employee by name: {}", name);
        Employee employee = employeeRepository.findEmployeeByName(name)
                .orElseThrow(() -> new EmployeeNotSuchException("Not found Employee by name " + name));
        return employeeMapper.toEmployeeDTO(employee);
    }

    @Override
    public EmployeeDTO saveOrUpdate(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.toEmployee(employeeDTO);
        if (employee.getId() == null) {
            log.info("Save new Employee with name: {}", employee.getName());
        } else {
            log.info("Update Employee with name: {}, id: {}", employee.getName(), employee.getId());
        }
        return employeeMapper.toEmployeeDTO(employeeRepository.save(employee));
    }

    @Override
    public void deleteById(Long id) {
        log.info("Delete Employee with id: {}", id);
        employeeRepository.deleteById(id);
    }
}
