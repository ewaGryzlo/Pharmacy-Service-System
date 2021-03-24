package com.example.PharmacyServiceSystem.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.*;

@Entity
@EntityScan
@Table(name="employees")
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional=false)
    @Column(name ="id")
    private int EmployeeID;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="wage")
    private int wage;

    @Autowired
    public Employee(String name, String surname, int wage) {
        this.name = name;
        this.surname = surname;
        this.wage = wage;
    }

    @Autowired
    public Employee(){

    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getWage() {
        return wage;
    }

    @Override
    public String toString() {

        return super.toString() +
                " ,EmployeeId=" + getEmployeeID() +
                ", name=" + getName() +
                ", surname=" + getSurname() +
                ", wage=" + getWage() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
