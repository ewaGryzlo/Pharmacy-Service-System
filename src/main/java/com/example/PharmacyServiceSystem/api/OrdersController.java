package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.Model.Orders;
import com.example.PharmacyServiceSystem.Service.OrderDetailsService;
import com.example.PharmacyServiceSystem.Service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/test")
@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/order")
    public Iterable<Orders> getAllOrdersAction() {
        return ordersService.getAllOrders();
    }

    @PostMapping("/order")
    public Orders saveNewOrderAction(@RequestBody Orders inputPayload) {
        return ordersService.saveNewOrder(inputPayload);
    }

    @GetMapping("/order/{id}")
    public Optional getOrderByIdAction(@PathVariable("id") int id) {
        return ordersService.getOrderById(id);
    }

    @GetMapping("/order/{id}/summary/totalprice")
    public BigDecimal getTotalPriceOfOrderByIdAction(@PathVariable("id") int id) {
        return orderDetailsService.getTotalPriceOfOrderById(id);
    }

    @GetMapping("/order/{id}/summary/totalmed")
    public List<Medicine> getTotalMedicinesByOrderIdAction(@PathVariable("id") int id) {
        return orderDetailsService.getTotalMedicinesByOrderId(id);
    }

}
