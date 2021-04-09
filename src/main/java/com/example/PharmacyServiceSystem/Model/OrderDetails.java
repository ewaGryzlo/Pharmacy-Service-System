package com.example.PharmacyServiceSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="order_details")

public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.MERGE) //,orphanRemoval = true
    @JoinColumn(name="order_id",foreignKey= @ForeignKey(name="OrderDetails_Orders"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Orders orders;

    @Column(name="unitPrice")
    private BigDecimal unitPrice;

    @Column(name="quantity")
    private int quantity;

    //    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE) //opcja merge w przypadku takiej relacji, bo pobieramy dane z istniejacego id ?
    @JoinColumn(name="medId",foreignKey= @ForeignKey(name="OrderDetails_Medicines"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Medicine medicine;

    public OrderDetails(Orders orders, BigDecimal unitPrice, int quantity, Medicine medicine) {
        this.orders = orders;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.medicine = medicine;
    }

    @Autowired
    public OrderDetails() {
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.id = orderDetailsId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetails)) return false;
        OrderDetails that = (OrderDetails) o;
        return id == that.id &&
                orders.equals(that.orders) &&
                medicine.equals(that.medicine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orders, medicine);
    }
}
