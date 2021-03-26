package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Pharmacy;
import com.example.PharmacyServiceSystem.dao.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/test")
@RestController
public class PharmacyController {
    @Autowired
    private PharmacyRepository pharmacyRepo;

    @GetMapping("/pharmacies")
    public Iterable<Pharmacy> getAllPharmacies() {
        List<Pharmacy> listPharmacies = pharmacyRepo.findAll();
        return listPharmacies;
    }

    @RequestMapping("/pharmacies")
    public Pharmacy test(@RequestBody Pharmacy inputPayload){
        Pharmacy ph = new Pharmacy();
        ph.setCompanyName(inputPayload.getCompanyName());
        ph.setAddress(inputPayload.getAddress());
        ph.setCity(inputPayload.getCity());
        ph.setContactName(inputPayload.getContactName());
        ph.setPhoneNumber(inputPayload.getPhoneNumber());
        return pharmacyRepo.save(ph) ;
    }
}
