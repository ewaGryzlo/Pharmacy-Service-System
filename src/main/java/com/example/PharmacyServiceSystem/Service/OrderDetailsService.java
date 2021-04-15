package com.example.PharmacyServiceSystem.Service;

import com.example.PharmacyServiceSystem.Model.OrderDetails;
import com.example.PharmacyServiceSystem.dao.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepo;

    public OrderDetails saveNewOrderDetail(OrderDetails inputPayload) {
        OrderDetails od = new OrderDetails();
        od.setOrders(inputPayload.getOrders());
        od.setMedicine(inputPayload.getMedicine());
        od.setQuantity(inputPayload.getQuantity());
        od.setUnitPrice(inputPayload.getUnitPrice());
        return orderDetailsRepo.save(od);
    }

    public Iterable<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepo.findAll();
    }


    public BigDecimal getTotalPriceOfOrder(OrderDetails orderDetails){
        return orderDetails.getUnitPrice()
                .multiply(new BigDecimal(orderDetails.getQuantity()));
    }
}