package com.example.PharmacyServiceSystem.Service;

import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.Model.OrderDetails;
import com.example.PharmacyServiceSystem.dao.MedicineRepository;
import com.example.PharmacyServiceSystem.dao.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepo;

    @Autowired
    private MedicineRepository medicineRepository;


    public OrderDetails saveNewOrderDetail(OrderDetails inputPayload) {
        OrderDetails od = new OrderDetails();
        od.setOrders(inputPayload.getOrders());
        od.setMedicine(inputPayload.getMedicine());
        od.setQuantity(inputPayload.getQuantity());
        od.setUnitPrice(inputPayload.getUnitPrice());
        updateQuantityStock(inputPayload);
        return orderDetailsRepo.save(od);
    }

    public Iterable<OrderDetails> getAllOrderDetails() {
        return orderDetailsRepo.findAll();
    }

    public Optional getOrderDetailsById(int id) {
        return orderDetailsRepo.findById(id);
    }

    public BigDecimal getTotalPriceOfOrderDetails(OrderDetails orderDetails) {
        return orderDetails.getUnitPrice()
                .multiply(new BigDecimal(orderDetails.getQuantity()));
    }

    public BigDecimal getTotalPriceOfOrderById(int id) {
        List<OrderDetails> odList = orderDetailsRepo.findAllByOrderDetails(id);
        List<BigDecimal> list = new ArrayList<>();

        for (OrderDetails or : odList) {
            BigDecimal result = (getTotalPriceOfOrderDetails(or));
            list.add(result);
        }
        return list.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Medicine> getTotalMedicinesByOrderId(int id) {
        List<OrderDetails> odList = orderDetailsRepo.findAllByOrderDetails(id);
        List<Medicine> medList = new ArrayList<>();
        for (OrderDetails or : odList) {
            Medicine medicine = (or.getMedicine());
            medList.add(medicine);
        }
        return medList;
    }

    public void updateQuantityStock(OrderDetails inputPayload) {
        Optional<Medicine> med = (medicineRepository.findById(inputPayload.getMedicine().getMedicineNumber()));
        int quantityStock = med.get().getQuantityStock();
        if (quantityStock < inputPayload.getQuantity())
            throw new IllegalArgumentException("The required quantity is not available in stock.");
        med.get().setQuantityStock(quantityStock - inputPayload.getQuantity());
    }
}