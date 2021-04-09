package com.example.PharmacyServiceSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="pharmacies")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pharmacy_id")
    private int pharmacyID;

    @Column(name = "pharmacyCompanyName")
    private String companyName;

    @Column(name = "pharmacyAddress")
    private String address;

    @Column(name = "pharmacyCity")
    private String city;

    @Column(name = "contactName")
    private String contactName;

    @Column(name = "pharmacyPhone")
    private String phoneNumber;

    @OneToMany(mappedBy = "pharmacy",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JsonIgnore
    private List<Orders> orders;

    @Autowired
    public Pharmacy(){
    }

    @Autowired
    public Pharmacy(String companyName, String address, String city, String contactName, String phoneNumber, List<Orders> orders) {
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.orders=orders;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public int getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(int pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyID=" + pharmacyID +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", contactName='" + contactName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orders='" + orders + '\'' ;

    }

    /*
        There are overridden equals and hashCode methods.
        "If two objects are equal according to the equals(Object) method, then calling the hashCode()
        method on each of the two objects must produce the same value"
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof com.example.PharmacyServiceSystem.Model.Pharmacy)) {
            return false;
        }
        com.example.PharmacyServiceSystem.Model.Pharmacy pharmacy = (com.example.PharmacyServiceSystem.Model.Pharmacy) o;
        return this.getCompanyName().equals(pharmacy.companyName);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + pharmacyID;
        hash = 31 * hash + (companyName == null ? 0 : companyName.hashCode());
        hash = 31 * hash + (phoneNumber == null ? 0 : phoneNumber.hashCode());
        return hash;
    }
}

