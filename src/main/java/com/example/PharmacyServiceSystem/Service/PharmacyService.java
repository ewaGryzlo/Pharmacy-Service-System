package com.example.PharmacyServiceSystem.Service;

import com.example.PharmacyServiceSystem.Model.Pharmacy;
import com.example.PharmacyServiceSystem.dao.PharmacyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {

    @Autowired
    PharmacyRepository pharmacyRepository;

    public Pharmacy saveNewPharmacyClient (Pharmacy inputPayload){
        Pharmacy ph = new Pharmacy();
        ph.setCompanyName(inputPayload.getCompanyName());
        ph.setAddress(inputPayload.getAddress());
        ph.setCity(inputPayload.getCity());
        ph.setContactName(inputPayload.getContactName());
        ph.setPhoneNumber(inputPayload.getPhoneNumber());
        return pharmacyRepository.save(ph) ;
    }

    public Iterable<Pharmacy> getAllPharmacies() {
        return pharmacyRepository.findAll();
    }
}
