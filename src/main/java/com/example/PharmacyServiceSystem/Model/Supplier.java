package com.example.PharmacyServiceSystem.Model;

import javax.persistence.*;

@Entity
@Table(name="suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int supplierID;
    @Column(name = "suppCompanyName")
    private String companyName;
    @Column(name = "suppAddress")
    private String address;
    @Column(name = "suppPhone")
    private String phoneNumber;

//    public Supplier(int SupplierID, String companyName, String address) {
//        this.supplierID = SupplierID;
//        this.companyName = companyName;
//        this.address = address;
//        this.phoneNumber = null;
//    }


    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "SupplierID=" + getSupplierID() +
                ", company name='" + getCompanyName() + '\'' +
                ", phone number='" + getPhoneNumber() + '\'' +
                '}';
    }

    /*
    There are overridden equals and hashCode methods.
    "If two objects are equal according to the equals(Object) method, then calling the hashCode()
    method on each of the two objects must produce the same value"
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof com.example.PharmacyServiceSystem.Model.Supplier)) {
            return false;
        }
        com.example.PharmacyServiceSystem.Model.Supplier supp = (com.example.PharmacyServiceSystem.Model.Supplier) o;
        return this.getCompanyName().equals(supp.companyName);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + supplierID;
        hash = 31 * hash + (companyName == null ? 0 : companyName.hashCode());
        hash = 31 * hash + (phoneNumber == null ? 0 : phoneNumber.hashCode());
        return hash;
    }
}

