package com.example.PharmacyServiceSystem;

import com.example.PharmacyServiceSystem.Model.Employee;
import com.example.PharmacyServiceSystem.Model.OrderDetails;
import com.example.PharmacyServiceSystem.Service.OrderDetailsService;
import com.example.PharmacyServiceSystem.dao.EmployeeRepository;
import com.example.PharmacyServiceSystem.dao.OrderDetailsRepository;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest

class PharmacyServiceSystemApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Before
    public void setUp() throws Exception {
        Employee emp1 = new Employee("Anna", "Kowalska", 2000);
        Employee emp2 = new Employee("Jan", "Kowalski", 4000);
        assertNotNull(emp1.getEmployeeID());
        assertNotNull(emp2.getEmployeeID());
        //save user
        this.employeeRepo.save(emp1);
        this.employeeRepo.save(emp2);
    }

    @Test
    public void testFetchData() {
        List<OrderDetails> odList =  orderDetailsRepository.findAllByOrderDetails(1);
        List<BigDecimal> list = new ArrayList<>();

        for (OrderDetails or : odList) {
            BigDecimal result = (orderDetailsService.getTotalPriceOfOrderDetails(or));
            list.add(result);
        }
        BigDecimal result = list.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(result);

//        for (Object e : employees) {
//            count++;
//            System.out.println(e);
//        }
//        Employee empA = employeeRepo.findByWage(2000);
//        Employee empB = employeeRepo.findByWage(3000);
//        Employee empC = employeeRepo.findBySurname("Kowalska");
//        assertNotNull(empA);
//        assertNotNull(empB);
//        assertNotNull(empC);
//        assertEquals("Kowalska", empC.getSurname());
//        assertEquals(2000, empA.getWage());
//        assertEquals(3000, empB.getWage());
//        int count=0;
//
//        Iterable employees = employeeRepo.findAll();
//        for (Object e : employees) {
//            count++;
//            System.out.println(e);
//        }
//        assertEquals(count, employeeRepo.count());
    }

}
