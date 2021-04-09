package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Service.EmployeeService;
import com.example.PharmacyServiceSystem.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.PharmacyServiceSystem.Model.Employee;

@RequestMapping("api/test")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @PostMapping("/employees")
    public Employee saveNewEmployeeAction(@RequestBody Employee inputPayload){
        return employeeService.saveNewEmployee(inputPayload);
    }
}
