package com.example.PharmacyServiceSystem.Service;

import com.example.PharmacyServiceSystem.Model.Employee;
import com.example.PharmacyServiceSystem.Model.Medicine;
import com.example.PharmacyServiceSystem.Model.Pharmacy;

import java.util.ArrayList;

public interface IManagement<T> {

    Object fetch(int i);

    default void getAllSuppliersFromWarehouse() {
    }
    default void getAllEmployeesFromWarehouse() {
    }
    default void getAllMedicinesFromWarehouse() {
    }
    default ArrayList<T> getSelectedMedicinesFromWarehouse(Medicine... medicines) {
        return new ArrayList<>();
    }
    default ArrayList<Employee> getSelectedEmployeesFromWarehouse(Employee... employees) {
        return new ArrayList<>();
    }
    default boolean ifExists(Object obj) {
        return false;
    }
}