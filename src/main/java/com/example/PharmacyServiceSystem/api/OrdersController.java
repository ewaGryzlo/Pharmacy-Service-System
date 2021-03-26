package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.Model.Orders;
import com.example.PharmacyServiceSystem.dao.MedicineRepository;
import com.example.PharmacyServiceSystem.dao.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/test")
@RestController
public class OrdersController {
    @Autowired
    private OrdersRepository ordersRepo;

    @GetMapping("/orders")
    public Iterable<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }

    @RequestMapping("/orders")
    public Orders test(@RequestBody Orders inputPayload){
        Orders o = new Orders();
        o.setOrderDate(inputPayload.getOrderDate());
        o.setShippedDate(inputPayload.getShippedDate());
        o.setShipCity(inputPayload.getShipCity());
        o.setPharmacy(inputPayload.getPharmacy());
        return ordersRepo.save(o) ;
    }
}
