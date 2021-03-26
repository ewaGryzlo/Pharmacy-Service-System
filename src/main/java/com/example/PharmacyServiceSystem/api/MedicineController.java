package com.example.PharmacyServiceSystem.api;


import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.dao.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/test")
@RestController
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepo;

    @GetMapping("/medicines")
    public Iterable<Medicine> getAllEmployees() {
        List<Medicine> listMedicines = medicineRepo.findAll();
        return listMedicines;
    }

    @RequestMapping("/medicines")
    public Medicine test(@RequestBody Medicine inputPayload){
        Medicine m = new Medicine();
        m.setMedicineName(inputPayload.getMedicineName());
        m.setQuantity(inputPayload.getQuantity());
        m.setIfPrescription(inputPayload.isIfPrescription());
        m.setMedicinePrice(inputPayload.getMedicinePrice());
        m.setExpiryDate(inputPayload.getExpiryDate());
        m.setMedicineType(inputPayload.getMedicineType());
        return medicineRepo.save(m) ;
    }
}
