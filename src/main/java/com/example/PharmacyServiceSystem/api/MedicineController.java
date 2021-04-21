package com.example.PharmacyServiceSystem.api;

import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServlet;
import java.util.Optional;

@RequestMapping("api/test")
@RestController
public class MedicineController extends HttpServlet {

    @Autowired
    private MedicineService medicineService;

    @GetMapping("/medicines")
    public Iterable<Medicine> getAllMedicinesAction(){
        return medicineService.getAllMedicines();
    }

    @GetMapping("/medicines/{id}")
    public Optional getMedicineByIdAction(@PathVariable("id") int id){
        return medicineService.getMedicineById(id);
    }

    @PostMapping("/medicines")
    public Medicine saveNewMedicineAction(@RequestBody Medicine inputPayload){
        return medicineService.saveNewMedicine(inputPayload);
    }

}
