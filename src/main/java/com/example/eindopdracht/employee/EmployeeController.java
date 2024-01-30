package com.example.eindopdracht.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAllEmployees() {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmployeeDto>> findEmployeeById(@PathVariable ("id") Long id ) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.created(null).body(employeeService.createEmployee(employeeDto));
    }
    @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody Long id, EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable ("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
