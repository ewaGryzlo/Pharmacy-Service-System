package com.example.PharmacyServiceSystem.api;


import com.example.PharmacyServiceSystem.Model.Supplier;
import com.example.PharmacyServiceSystem.dao.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/com/example/PharmacyServiceSystem/api/suppliers")
@RestController
public class SupplierController {
    @Autowired
    private SupplierRepository supplierRepo;

    @GetMapping("/suppliers")
    public Iterable<Supplier> getAllSuppliers() {
        List<Supplier> listSuppliers = supplierRepo.findAll();
        return listSuppliers;
    }

    @RequestMapping("/suppliers")
    public Supplier test(@RequestBody Supplier inputPayload){
        Supplier s = new Supplier();

        s.setCompanyName(inputPayload.getCompanyName());
        s.setAddress(inputPayload.getAddress());
        s.setPhoneNumber(inputPayload.getPhoneNumber());
        return supplierRepo.save(s) ;
    }
}
