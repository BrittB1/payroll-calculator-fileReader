package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(int id, String empName, double hours, double pay) {
        this.employeeId = id;
        this.name = empName;
        this.hoursWorked = hours;
        this.payRate = pay;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossPay() {
        return this.hoursWorked * this.payRate;
    }
}
