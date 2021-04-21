package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.OrderDetails;
import com.example.PharmacyServiceSystem.Service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequestMapping("api/test")
@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/orderDetails")
    public Iterable<OrderDetails> getAllOrderDetails() {
        return orderDetailsService.getAllOrderDetails();
    }

    @PostMapping("/orderDetails")
    public OrderDetails saveNewOrderDetail(@RequestBody OrderDetails inputPayload) {
        return orderDetailsService.saveNewOrderDetail(inputPayload);
    }

    @GetMapping("/orderDetails/{id}")
    public Optional getOrderByIdAction(@PathVariable("id") int id) {
        return orderDetailsService.getOrderDetailsById(id);
    }
}