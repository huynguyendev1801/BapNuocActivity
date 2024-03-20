package com.example.bapnuocactivity.Moodle;

import androidx.recyclerview.widget.RecyclerView;

public class Food {

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getViBap() {
        return viBap;
    }

    public void setViBap(String viBap) {
        this.viBap = viBap;
    }

    public Food(double giaTien, String viBap) {
        this.giaTien = giaTien;
        this.viBap = viBap;
    }

    private double giaTien;
    private String viBap;



    public Food() {
    }

}
