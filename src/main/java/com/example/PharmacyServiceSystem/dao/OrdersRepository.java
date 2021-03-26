package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}

