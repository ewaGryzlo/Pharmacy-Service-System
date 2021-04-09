package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;


public  interface MedicineRepository extends JpaRepository<Medicine,Integer> {

}
