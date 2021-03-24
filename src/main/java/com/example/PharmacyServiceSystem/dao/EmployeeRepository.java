package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByWage(int wage);


    @Query("SELECT e FROM Employee e  WHERE e.surname = ?1")
    Employee findBySurname(String surname);


}
