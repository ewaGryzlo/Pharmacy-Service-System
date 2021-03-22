package com.example.PharmacyServiceSystem;

import com.example.PharmacyServiceSystem.Model.Employee;
import com.example.PharmacyServiceSystem.dao.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PharmacyServiceSystemApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepo;

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
        Employee empA = employeeRepo.findByWage(2000);
        Employee empB = employeeRepo.findByWage(3000);
        assertNotNull(empA);
        assertNotNull(empB);
        assertEquals(2000, empA.getWage());
        assertEquals(3000, empB.getWage());
        Iterable employees = employeeRepo.findAll();
        int count = 0;
        for (Object e : employees) {
            count++;
            System.out.println(e);
        }
        assertEquals(count, 2);
    }
}
