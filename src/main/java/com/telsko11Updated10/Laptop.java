package com.telsko11Updated10;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    private int lId;
    private String brand;
    private String model;
    private int ram;
    @ManyToOne
    private Aline aline;
    //this  is used make laptop have aline connection

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    public Aline getAline() {
        return aline;
    }

    public void setAline(Aline aline) {
        this.aline = aline;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", lId=" + lId +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
