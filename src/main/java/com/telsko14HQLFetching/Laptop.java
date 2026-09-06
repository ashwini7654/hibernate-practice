package com.telsko14HQLFetching;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Laptop {
    @Id
    private int lId;
    private String brand;
    private String model;
    private int ram;



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
