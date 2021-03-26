package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {

}
