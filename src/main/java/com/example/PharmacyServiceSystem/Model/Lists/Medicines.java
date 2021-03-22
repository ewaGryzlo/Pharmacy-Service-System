package com.example.PharmacyServiceSystem.Model.Lists;

import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.SystemManagement.IManagement;
import com.example.PharmacyServiceSystem.NoExistsException;


import java.util.ArrayList;
import java.util.List;

public class Medicines implements IManagement {

    private List<Medicine> medicinesList;


    public Medicines() {
        medicinesList = new ArrayList<>();

    }

    public void setQuantity(Medicine medicine, int quantity) {
        medicine.setQuantity(quantity);
    }

    public void addMedicine(Medicine medicine) {
        medicinesList.add(medicine);
    }

    public void removeMedicine(Medicine medicine) throws NoExistsException {
        boolean b = ifExists(medicine);
        if (b) {
            medicinesList.remove(medicine);
        } else {
            throw new NoExistsException(medicine + " no exists in warehouse.");
        }
    }

    @Override
    public Medicine fetch(int i) {
        return medicinesList.get(i);

    }

    public List<Medicine> getMedicinesList() {
        return medicinesList;
    }

    @Override
    public String toString() {
        return "Medicines{" +
                "medicines list=" + getMedicinesList() +
                '}';
    }

    public void getAllMedicinesFromWarehouse() {
        for (Medicine m : medicinesList) {
            System.out.println(m);
        }
    }

    @Override
    public ArrayList<Medicine> getSelectedMedicinesFromWarehouse(Medicine... medicines) {
        System.out.println("===================Medicines====================");
        ArrayList<Medicine> list = new ArrayList<>();
        for (Medicine medicine : medicines) {
            list.add(medicine);
        }
        return list;
    }
}