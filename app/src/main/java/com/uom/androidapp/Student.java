package com.uom.androidapp;

public class Student {

    private String name;
    private double gpa;

    public Student(){}

    public Student(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
