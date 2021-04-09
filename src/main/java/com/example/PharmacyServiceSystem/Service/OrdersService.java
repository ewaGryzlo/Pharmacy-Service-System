package com.example.PharmacyServiceSystem.Service;

import com.example.PharmacyServiceSystem.Model.Orders;
import com.example.PharmacyServiceSystem.dao.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public Orders saveNewOrder(Orders inputPayload) {
        Orders o = new Orders();
        o.setOrderDate(inputPayload.getOrderDate());
        o.setShippedDate(inputPayload.getShippedDate());
        o.setShipCity(inputPayload.getShipCity());
        o.setPharmacy(inputPayload.getPharmacy());
        return ordersRepository.save(o);
    }
}
