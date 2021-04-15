package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Pharmacy;
import com.example.PharmacyServiceSystem.Service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/test")
@RestController
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping("/pharmacies")
    public Iterable<Pharmacy> getAllPharmaciesAction() {
        return pharmacyService.getAllPharmacies();
    }

    @PostMapping("/pharmacies")
    public Pharmacy saveNewPharmacyClientAction(@RequestBody Pharmacy inputPayload){
       return pharmacyService.saveNewPharmacyClient(inputPayload);
    }
}
