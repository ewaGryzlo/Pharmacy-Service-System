package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByWage(int wage);
}
