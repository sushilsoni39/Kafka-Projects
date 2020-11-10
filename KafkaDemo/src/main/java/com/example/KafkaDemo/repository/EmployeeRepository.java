package com.example.KafkaDemo.repository;
import com.example.KafkaDemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findById(Integer id);

    Employee findByName(String name);

    Employee findByEmail(String email);

    Employee findByNumber(long number);
}