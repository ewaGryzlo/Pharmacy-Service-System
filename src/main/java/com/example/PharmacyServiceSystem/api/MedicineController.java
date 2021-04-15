package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServlet;

@RequestMapping("api/test")
@RestController
public class MedicineController extends HttpServlet {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/medicines")
    public Iterable<Medicine> getAllMedicinesAction(){
        return medicineService.getAllMedicines();
    }


    @PostMapping("/medicines")
    public Medicine saveNewMedicineAction(@RequestBody Medicine inputPayload){
        return medicineService.saveNewMedicine(inputPayload);
    }

}
