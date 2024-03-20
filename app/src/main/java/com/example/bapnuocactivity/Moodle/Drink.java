package com.example.bapnuocactivity.Moodle;

public class Drink {
    public Drink() {
    }

    public Drink(double giaTien, String tenNuoc) {
        this.giaTien = giaTien;
        this.tenNuoc = tenNuoc;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getTenNuoc() {
        return tenNuoc;
    }

    public void setTenNuoc(String tenNuoc) {
        this.tenNuoc = tenNuoc;
    }

    private double giaTien;
    private String tenNuoc;
}
