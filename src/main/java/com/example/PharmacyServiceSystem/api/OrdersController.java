package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Orders;
import com.example.PharmacyServiceSystem.Service.OrdersService;
import com.example.PharmacyServiceSystem.dao.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/test")
@RestController
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepo;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public Iterable<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }

    @PostMapping("/orders")
    public Orders saveNewOrderAction(@RequestBody Orders inputPayload) {
        return ordersService.saveNewOrder(inputPayload);
    }

}
