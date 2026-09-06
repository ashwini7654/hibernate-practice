package com.telsko7ChangeTableName;

import jakarta.persistence.*;

@Entity()
 @Table(name ="aline_table")
//eninty name gate from class name and table from entity name
//@Entity(name="aline_table") then table name is not changed ,its create new table, to change table name use @Table(name ="aline_table")
public class Aline {
    @Id
   private int aid;
    @Column(name = "aline_name")
    private  String aname;
    private String tech;
    @Transient
    //use for only processing  after this annotation  age not make colume in table
     private int age;

    public int getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public String getTech() {
        return tech;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Aline{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
