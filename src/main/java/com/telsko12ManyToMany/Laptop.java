package com.telsko12ManyToMany;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;


@Entity
public class Laptop {
    @Id
    private int lId;
    private String brand;
    private String model;
    private int ram;
    @ManyToMany(mappedBy = "laptops")
    private List <Aline> alines;
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

    public List<Aline> getAlines() {
        return alines;
    }

    public void setAlines(List<Aline> alines) {
        this.alines = alines;
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
