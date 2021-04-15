package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Orders;
import com.example.PharmacyServiceSystem.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/test")
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public Iterable<Orders> getAllOrdersAction() {
        return ordersService.getAllOrders();
    }

    @PostMapping("/orders")
    public Orders saveNewOrderAction(@RequestBody Orders inputPayload) {
        return ordersService.saveNewOrder(inputPayload);
    }

}
