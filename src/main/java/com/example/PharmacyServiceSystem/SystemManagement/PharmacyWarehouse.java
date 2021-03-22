package com.example.PharmacyServiceSystem.SystemManagement;

import com.example.PharmacyServiceSystem.Model.Lists.Employees;
import com.example.PharmacyServiceSystem.Model.Lists.Medicines;
import com.example.PharmacyServiceSystem.Model.Lists.Suppliers;

public class PharmacyWarehouse {

    private static int totalNumberOfDifferentMedicines;
    private Employees employees;
    private Suppliers suppliers;
    private Medicines medicines;


    public PharmacyWarehouse() {
        employees = new Employees();
        suppliers = new Suppliers();
        medicines = new Medicines();

    }

    public static int getTotalNumberOfDifferentMedicines() {
        return totalNumberOfDifferentMedicines;
    }

    public Employees getEmployees() {
        return employees;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public Medicines getMedicines() {
        return medicines;
    }
}
