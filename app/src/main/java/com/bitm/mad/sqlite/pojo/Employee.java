package com.bitm.mad.sqlite.pojo;

public class Employee {
    private int id;
    private String name;
    private String designation;
    private String branch;
    private double salary;

    public Employee(int id, String name, String designation, String branch, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.branch = branch;
        this.salary = salary;
    }

    public Employee(String name, String designation, String branch, double salary) {
        this.name = name;
        this.designation = designation;
        this.branch = branch;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

