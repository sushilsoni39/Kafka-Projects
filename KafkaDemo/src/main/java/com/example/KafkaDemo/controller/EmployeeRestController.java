package com.example.KafkaDemo.controller;

import com.example.KafkaDemo.repository.EmployeeRepository;
import com.example.KafkaDemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeRestController {
    @Autowired
    private EmployeeRepository employeeRepository;


    @GetMapping("/employee/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return ResponseEntity.ok().body(employee);
    }


    @GetMapping("/listEmployees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }


    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Integer id) {
        Optional<Employee> employee_opt = employeeRepository.findById(id);
        Employee employee = null;
        if (employee_opt.isPresent()) {
            employee = employee_opt.get();
            employeeRepository.delete(employee);
        }
        return ResponseEntity.ok().body(employee);

    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id,
                                                   @RequestBody Employee employeeDetails) {
        Optional<Employee> employee_opt = employeeRepository.findById(id);
        Employee updatedEmployee = null;
        if (employee_opt.isPresent()) {
            Employee employee = employee_opt.get();
            employee.setEmail(employeeDetails.getEmail());
            employee.setName(employeeDetails.getName());
            employee.setNumber(employeeDetails.getNumber());
            updatedEmployee = employeeRepository.save(employee);
        }

        return ResponseEntity.ok(updatedEmployee);
    }
}
