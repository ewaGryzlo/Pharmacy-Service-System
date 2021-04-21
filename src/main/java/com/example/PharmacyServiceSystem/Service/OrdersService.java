package com.example.PharmacyServiceSystem.Service;

import com.example.PharmacyServiceSystem.Model.Orders;
import com.example.PharmacyServiceSystem.dao.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrderDetailsService orderDetailsService;

    public Orders saveNewOrder(Orders inputPayload) {
        Orders o = new Orders();
        o.setOrderDate(inputPayload.getOrderDate());
        o.setShipCity(inputPayload.getShipCity());
        o.setPharmacy(inputPayload.getPharmacy());
        return ordersRepository.save(o);
    }

    public Iterable<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Optional getOrderById(int id) {
        return ordersRepository.findById(id);
    }
}
