package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.OrderDetails;
import com.example.PharmacyServiceSystem.Service.OrderDetailsService;
import com.example.PharmacyServiceSystem.dao.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/test")
@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepo;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/orderDetails")
    public Iterable<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepo.findAll();
    }

    @PostMapping("/orderDetails")
    public OrderDetails saveNewOrderDetailAction(@RequestBody OrderDetails inputPayload) {
        return orderDetailsService.saveNewOrderDetail(inputPayload);
    }

}