package com.example.PharmacyServiceSystem.Model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int medicineNumber;
    @Column(name = "medName")
    private String medicineName;
    @Column(name = "medCompanyName")
    private String medicineCompanyName;
    @Column(name = "medPrice")
    private double medicinePrice;
    @Column(name = "prescription")
    private boolean ifPrescription; //in SQL Server 0-false,1-true
    @Column(name = "medQuantity")
    protected int quantity; //quantity available in warehouse

    @Autowired
    public Medicine(String medicineName, String medicineCompanyName,
                    double medicinePrice, boolean ifPrescription) {
        this.medicineName = medicineName;
        this.medicineCompanyName = medicineCompanyName;
        this.medicinePrice = medicinePrice;
        this.ifPrescription = ifPrescription;
        this.quantity =0;
    }

    @Autowired
    public Medicine() {

    }
    //    public void setMedicineNumber(int medicineNumber) {
//        this.medicineNumber = medicineNumber;
//    }

    public void setMedicineCompanyName(String medicineCompanyName) {
        this.medicineCompanyName = medicineCompanyName;
    }

    public void setMedicinePrice(double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected int getMedicineNumber() {
        return this.medicineNumber;
    }
    public String getMedicineCompanyName() {
        return this.medicineCompanyName;
    }

    public double getMedicinePrice() {
        return this.medicinePrice;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public boolean isIfPrescription() {
        return ifPrescription;
    }

    public void setIfPrescription(boolean ifPrescription) {
        this.ifPrescription = ifPrescription;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineNumber=" + getMedicineNumber() +
                ", medicineName='" + getMedicineName() + '\'' +
                ", medicine company name='" + getMedicineCompanyName() + '\'' +
                ", medicinePrice=" + getMedicinePrice() +
                ", on prescription=" + isIfPrescription() +
                ", quantity=" + getQuantity()+
                '}';
    }
}