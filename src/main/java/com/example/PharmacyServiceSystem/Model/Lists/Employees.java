package com.example.PharmacyServiceSystem.Model.Lists;

import com.example.PharmacyServiceSystem.Model.Employee;
import com.example.PharmacyServiceSystem.SystemManagement.IManagement;
import com.example.PharmacyServiceSystem.NoExistsException;

import java.util.ArrayList;
import java.util.List;

public class Employees implements IManagement {

    private List<Employee> employeesList;

    public Employees() {
        employeesList = new ArrayList<>();
    }

    public void addEmployee(Employee e) {
        employeesList.add(e);
    }

    public void removeEmployee(Employee e) throws NoExistsException {
        boolean b = ifExists(e);
        if (b) {
            employeesList.remove(e);
        } else {
            throw new NoExistsException(e + " no exists.");
        }

    }

    @Override
    public Object fetch(int i) {
        return employeesList.get(i);
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "Employees list=" + getEmployeesList() +
                '}';
    }

    public void getAllEmployeesFromWarehouse() {
        for (Employee e : employeesList) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Employee> getSelectedEmployeesFromWarehouse(Employee... employees) {
        System.out.println("=================Employees================");
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee e : employees) {
            list.add(e);
        }
        return list;
    }

    public void setWage(Employee e, int wage) {
        e.setWage(wage);
    }
}