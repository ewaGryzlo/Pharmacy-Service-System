package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.Model.OrderDetails;
import com.example.PharmacyServiceSystem.Model.Orders;
import com.example.PharmacyServiceSystem.dao.MedicineRepository;
import com.example.PharmacyServiceSystem.dao.OrderDetailsRepository;
import com.example.PharmacyServiceSystem.dao.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/test")
@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsRepository orderDetailsRepo;

    @Autowired
    private OrdersRepository ordersRepo;


    @GetMapping("/orderDetails")
    public Iterable<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepo.findAll();
    }

    @RequestMapping("/orderDetails")
    public OrderDetails test(@RequestBody OrderDetails inputPayload){
        OrderDetails od = new OrderDetails();
        od.setOrders(inputPayload.getOrders());
        od.setMedicine(inputPayload.getMedicine());
        od.setQuantity(inputPayload.getQuantity());
        od.setUnitPrice(inputPayload.getMedicine().getMedicinePrice());
        return orderDetailsRepo.save(od) ;
    }
}
