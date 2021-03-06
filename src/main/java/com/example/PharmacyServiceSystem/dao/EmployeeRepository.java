package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("SELECT e FROM Employee e WHERE e.wage = ?1")
    Employee findByWage(int wage);

    @Query("SELECT e FROM Employee e WHERE e.surname = ?1")
    Employee findBySurname(String surname);

    @Query("SELECT e FROM Employee e WHERE e.id = ?1")
    Employee findById(int id);
}
