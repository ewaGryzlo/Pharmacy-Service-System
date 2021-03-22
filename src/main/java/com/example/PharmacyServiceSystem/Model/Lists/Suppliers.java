package com.example.PharmacyServiceSystem.Model.Lists;

import com.example.PharmacyServiceSystem.Model.Supplier;
import com.example.PharmacyServiceSystem.SystemManagement.IManagement;
import com.example.PharmacyServiceSystem.NoExistsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Suppliers implements IManagement {

    private List<Supplier> suppliersList;
    private Map<String,String> phoneNumberStringMap;

    public Suppliers(){
        suppliersList = new ArrayList<>();
        phoneNumberStringMap = new HashMap<>();

    }

    public void addSupplier(Supplier d) {
        boolean b = ifExists(d);
        suppliersList.add(d);
    }


    public void removeSupplier(Supplier s) throws NoExistsException {
        boolean b = ifExists(s);
        if(b) {
            suppliersList.add(s);
        } else{
            throw new NoExistsException(s + "no exists.");
        }
    }

    public Supplier fetch(int i){
        return suppliersList.get(i);
    }

    public List<Supplier> getSuppliersList() {
        return suppliersList;
    }
    public void setSuppliersList(List<Supplier> suppliersList) {
        this.suppliersList = suppliersList;
    }

    public Map<String, String> getPhoneNumberStringMap() {
        return phoneNumberStringMap;
    }

    public void setPhoneNumberStringMap(Map<String,String> phoneNumberStringMap) {
        this.phoneNumberStringMap = phoneNumberStringMap;
    }

    public void addPhoneNumberForSupplier(String newPhoneNumber, Supplier s){
        phoneNumberStringMap.put(newPhoneNumber,s.getCompanyName());
        s.setPhoneNumber(newPhoneNumber);
    }

    public void getAllSuppliersFromWarehouse(){
        for(Supplier d: suppliersList){
            System.out.println(d);
        }
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "suppliersList=" + getSuppliersList() +
                ", phone numbers =" + getPhoneNumberStringMap() +
                '}';
    }


}