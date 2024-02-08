package ru.denis.employeeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.denis.employeeapi.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByName(String name);
}
