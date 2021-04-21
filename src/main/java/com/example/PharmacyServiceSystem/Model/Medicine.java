package com.example.PharmacyServiceSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medId")
    private int medicineNumber;

    @Column(name = "medName", unique = true)
    private String medicineName;

    @Column(name = "medPrice")
    private BigDecimal medicinePrice;

    @Column(name = "prescription")
    private boolean ifPrescription; //in SQL Server 0-false,1-true

    @Column(name = "quantity_ava")
    protected int quantityStock; //quantity available in warehouse

    @Column(name = "expiryDate")
    LocalDate expiryDate;

    @Column
    private MedicineType medicineType;

    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderDetails> orderDetails;

    public Medicine() {
    }

    public int getMedicineNumber() {
        return medicineNumber;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public BigDecimal getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(BigDecimal medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public boolean isIfPrescription() {
        return ifPrescription;
    }

    public void setIfPrescription(boolean ifPrescription) {
        this.ifPrescription = ifPrescription;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

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

    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineNumber=" + medicineNumber +
                ", medicineName='" + medicineName + '\'' +
                ", medicinePrice=" + medicinePrice +
                ", ifPrescription=" + ifPrescription +
                ", quantity=" + quantityStock +
                ", expiryDate=" + expiryDate +
                ", medicineType=" + medicineType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine)) return false;
        Medicine medicine = (Medicine) o;
        return medicineNumber == medicine.medicineNumber &&
                medicineName.equals(medicine.medicineName) &&
                medicinePrice.equals(medicine.medicinePrice) &&
                orderDetails.equals(medicine.orderDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineNumber, medicineName, medicinePrice, orderDetails);
    }
}