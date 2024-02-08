package ru.denis.employeeapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.denis.employeeapi.dto.EmployeeDTO;
import ru.denis.employeeapi.entity.Employee;
import ru.denis.employeeapi.exception.EmployeeNotSuchException;
import ru.denis.employeeapi.service.EmployeeService;
import ru.denis.employeeapi.validation.ResponseErrorValidation;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final ResponseErrorValidation responseErrorValidation;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAll() {
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @GetMapping("search")
    public ResponseEntity<EmployeeDTO> getByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(employeeService.getByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult result) {
        if (result.hasErrors()) return new ResponseEntity<>(responseErrorValidation.validate(result), HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(employeeService.saveOrUpdate(employeeDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody EmployeeDTO employeeDTO, BindingResult result) {
        if (result.hasErrors()) return new ResponseEntity<>(responseErrorValidation.validate(result), HttpStatus.BAD_REQUEST);
        else return new ResponseEntity<>(employeeService.saveOrUpdate(employeeDTO), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return new ResponseEntity<>(Map.of("info", "Delete Employee with id " + id),
                HttpStatus.OK);
    }
}
