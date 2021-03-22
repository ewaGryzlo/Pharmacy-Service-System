package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    Supplier findByCompanyName(String companyName);
}
