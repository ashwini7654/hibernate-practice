package com.telsko6Delete;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity// this class is represented in DB
public class Student {
    @Id// this makes primery key for DB
    private int rollno;
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", rollno=" + rollno +
                ", name='" + name + '\'' +
                '}';
    }
}
