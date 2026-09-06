package com.telsko12ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
       Laptop l1= new Laptop();
        l1.setlId(1);
        l1.setBrand("MSI");
        l1.setModel("Thin Gf63 12UC");
        l1.setRam(16);
        Laptop l2= new Laptop();
        l2.setlId(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(16);
        Laptop l3= new Laptop();
        l3.setlId(3);
        l3.setBrand("Apple");
        l3.setModel("MackBook");
        l3.setRam(32);


        Aline a1=new Aline();
        a1.setAid(101);
        a1.setAname("Ashwini");
        a1.setTech("Java");

        Aline a2=new Aline();
        a2.setAid(102);
        a2.setAname("Raj");
        a2.setTech("Python");
        Aline a3=new Aline();
        a3.setAid(103);
        a3.setAname("Raushan");
        a3.setTech("AI");

        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l2,l3));
        a3.setLaptops(Arrays.asList(l1));

        l1.setAlines(Arrays.asList(a1,a3));
        l2.setAlines(Arrays.asList(a1,a2));
        l3.setAlines(Arrays.asList(a2));






        SessionFactory sf= new Configuration()
                .addAnnotatedClass(Aline.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();

       session.persist(a1);
       session.persist(a2);
       session.persist(a3);

       session.persist(l1);
       session.persist(l2);
       session.persist(l3);

        Transaction transaction =session.beginTransaction();
        transaction.commit();
        //Data is permanently stored in the database

       Aline a5= session.find(Aline.class,101);




    }
}