package com.example.PharmacyServiceSystem.dao;

import com.example.PharmacyServiceSystem.Model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Integer> {

    @Query(value = "SELECT * FROM order_details od where od.order_id = ?1", nativeQuery = true)
    List<OrderDetails> findAllByOrderDetails(int id);
}
