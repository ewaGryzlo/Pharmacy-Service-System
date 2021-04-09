package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.Service.MedicineService;
import com.example.PharmacyServiceSystem.dao.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/test")
@RestController
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepo;

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/medicines")
    public Iterable<Medicine> getAllMedicines() {
        return medicineRepo.findAll();
    }

    @PostMapping("/medicines")
    public Medicine saveNewMedicineAction(@RequestBody Medicine inputPayload){
        return medicineService.saveNewMedicine(inputPayload);
    }
}
