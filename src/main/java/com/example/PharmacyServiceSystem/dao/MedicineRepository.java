package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public  interface MedicineRepository extends JpaRepository<Medicine,Integer> {
    @Query("SELECT m FROM Medicine m where m.id = ?1")
    Medicine findById(int id);
}
