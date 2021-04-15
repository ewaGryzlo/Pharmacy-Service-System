package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.PharmacyServiceSystem.Model.Employee;

@RequestMapping("api/test")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployeesAction() {
        return  employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee saveNewEmployeeAction(@RequestBody Employee inputPayload){
        return employeeService.saveNewEmployee(inputPayload);
    }
}
