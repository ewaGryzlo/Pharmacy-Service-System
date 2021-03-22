package com.example.PharmacyServiceSystem.api;


import com.example.PharmacyServiceSystem.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.PharmacyServiceSystem.Model.Employee;

import java.util.List;


@RequestMapping("api/test")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepo;

    @GetMapping("/employees")
    public Iterable<Employee> getAllEmployees() {
        List<Employee> listEmployees = employeeRepo.findAll();
        return listEmployees;
    }

    @RequestMapping("employees")
    public Employee test(@RequestBody Employee inputPayload){
        Employee e = new Employee();
        e.setEmployeeID(inputPayload.getEmployeeID());
        e.setName(inputPayload.getName());
        e.setSurname(inputPayload.getSurname());
        e.setWage(inputPayload.getWage());
        System.out.println(e.toString());
        return employeeRepo.save(e) ;
    }
}
