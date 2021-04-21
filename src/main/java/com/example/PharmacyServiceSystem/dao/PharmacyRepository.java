package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy,Integer> {
}


