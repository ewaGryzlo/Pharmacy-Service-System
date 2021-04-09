package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Pharmacy;
import com.example.PharmacyServiceSystem.Service.PharmacyService;
import com.example.PharmacyServiceSystem.dao.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/test")
@RestController
public class PharmacyController {
    @Autowired
    private PharmacyRepository pharmacyRepo;

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping("/pharmacies")
    public Iterable<Pharmacy> getAllPharmacies() {
        List<Pharmacy> listPharmacies = pharmacyRepo.findAll();
        return listPharmacies;
    }

    @PostMapping("/pharmacies")
    public Pharmacy saveNewPharmacyClientAction(@RequestBody Pharmacy inputPayload){
       return pharmacyService.saveNewPharmacyClient(inputPayload);
    }
}
