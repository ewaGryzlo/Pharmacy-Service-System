package com.example.PharmacyServiceSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

@Entity
@Table(name="medicines")
//@Embeddable
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medId")
    private int medicineNumber;

    @Column(name = "medName")
    private String medicineName;

    @Column(name = "medPrice")
    private BigDecimal medicinePrice;

    @Column(name = "prescription")
    private boolean ifPrescription; //in SQL Server 0-false,1-true

    @Column(name = "quantity_ava")
    protected int quantity; //quantity available in warehouse

    @Column(name= "expiryDate")
    LocalDate expiryDate;

    @Column
    private MedicineType medicineType;

    @OneToMany(mappedBy = "medicine",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderDetails> orderDetails;

    public Medicine(String medicineName, BigDecimal medicinePrice, boolean ifPrescription, int quantity, LocalDate expiryDate,
                    MedicineType medicineType, List<OrderDetails> orderDetails) {
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.ifPrescription = ifPrescription;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.medicineType = medicineType;
        this.orderDetails = orderDetails;
    }

    @Autowired
    public Medicine(String medicineName,BigDecimal medicinePrice, boolean ifPrescription,MedicineType medicineType) {
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.ifPrescription = ifPrescription;
        this.medicineType = medicineType;
        this.quantity =0;
    }

    @Autowired
    public Medicine() {

    }
    //    public void setMedicineNumber(int medicineNumber) {
//        this.medicineNumber = medicineNumber;
//    }


    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public MedicineType getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineType medicineType) {
        this.medicineType = medicineType;
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

    public BigDecimal getMedicinePrice() {
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

    public void setMedicinePrice(BigDecimal medicinePrice) {
        this.medicinePrice = medicinePrice;
    }
//    public void setIfPrescription(boolean ifPrescription,MedicineType medicineType) {
//        if (medicineType == MedicineType.POM) {
//            this.ifPrescription = ifPrescription;
//        }
//    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineNumber=" + medicineNumber +
                ", medicineName='" + medicineName + '\'' +
                ", medicinePrice=" + medicinePrice +
                ", ifPrescription=" + ifPrescription +
                ", quantity=" + quantity +
                ", expiryDate=" + expiryDate +
                ", medicineType=" + medicineType +
                '}';
    }
}