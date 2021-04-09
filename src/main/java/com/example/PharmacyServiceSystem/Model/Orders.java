package com.example.PharmacyServiceSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="orders")
public class Orders {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.MERGE)
    @JoinColumn(name="pharmacy_id" , foreignKey= @ForeignKey(name="Orders_Pharmacies"),nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Pharmacy pharmacy;

//    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL) //,orphanRemoval = true
//    @MapsId
//    @JoinColumn(name="order_id",foreignKey= @ForeignKey(name="orderDetailsId"))
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "orders")
    private List<OrderDetails> orderDetails;

    @Column(name="order_date")
    private LocalDateTime orderDate;

    @Column(name="shipped_date")
    private LocalDateTime shippedDate;

    @Column(name="ship_city")
    private String shipCity;

    @Autowired
    public Orders(){

    }
    @Autowired
    public Orders(int orderId, Pharmacy pharmacy, LocalDateTime orderDate, LocalDateTime shippedDate, String shipCity) {
        this.orderId = orderId;
        this.pharmacy = pharmacy;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.shipCity = shipCity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDateTime shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", pharmacy=" + pharmacy +
                ", orderDate=" + orderDate +
                ", shippedDate=" + shippedDate +
                ", shipCity='" + shipCity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
