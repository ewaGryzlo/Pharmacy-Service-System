package com.example.PharmacyServiceSystem.Service;

import com.example.PharmacyServiceSystem.Model.Employee;
import com.example.PharmacyServiceSystem.Model.OrderStatus;
import com.example.PharmacyServiceSystem.Model.Orders;
import com.example.PharmacyServiceSystem.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveNewEmployee(Employee inputPayload) {
        Employee e = new Employee();
        e.setName(inputPayload.getName());
        e.setSurname(inputPayload.getSurname());
        e.setWage(inputPayload.getWage());
        e.setHireDate(inputPayload.getHireDate());
        e.setPhoneNumber(inputPayload.getPhoneNumber());
        System.out.println(e.toString());
        return employeeRepository.save(e);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void setStatusOrder(Orders order, OrderStatus orderStatus) {
        if (order.getOrderStatus() == null) {
            return;
        }
        order.setOrderStatus(orderStatus);
    }
}
