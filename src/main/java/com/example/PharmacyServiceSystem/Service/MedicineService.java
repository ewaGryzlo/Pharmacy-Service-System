package com.example.PharmacyServiceSystem.Service;

import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.dao.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    @Autowired
    MedicineRepository medicineRepository;

    public Medicine saveNewMedicine(Medicine inputPayload){
        Medicine m = new Medicine();
        m.setMedicineName(inputPayload.getMedicineName());
        m.setQuantityStock(inputPayload.getQuantityStock());
        m.setIfPrescription(inputPayload.isIfPrescription());
        m.setMedicinePrice(inputPayload.getMedicinePrice());
        m.setExpiryDate(inputPayload.getExpiryDate());
        m.setMedicineType(inputPayload.getMedicineType());
        return medicineRepository.save(m) ;
    }

    public Iterable<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }
}
