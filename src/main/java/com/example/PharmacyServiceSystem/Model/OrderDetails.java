package com.example.PharmacyServiceSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="order_details")

public class OrderDetails {
    @Id
    @Column(name="order_id")
    private int orderId;


    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,optional = false) //,orphanRemoval = true
//    @MapsId
    @JoinColumn(name="order_id",foreignKey= @ForeignKey(name="OrderDetails_Orders"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @OneToOne(cascade=CascadeType.ALL, mappedBy = "orderDetails")//,orphanRemoval = true
////    @MapsId
//    @PrimaryKeyJoinColumn
////    @JoinColumn(name="order_id")
    private Orders orders;

    @Column(name="unitPrice")
    private BigDecimal unitPrice;

    @Column(name="quantity")
    private int quantity;

//    @EmbeddedId
    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    @JoinColumn(name="medId",foreignKey= @ForeignKey(name="OrderDetails_Medicines"),nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Medicine medicine;


    public OrderDetails(int orderId, Orders orders, BigDecimal unitPrice, int quantity, Medicine medicine) {
        this.orderId = orderId;
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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

}
