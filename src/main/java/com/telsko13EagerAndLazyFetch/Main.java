package com.telsko13EagerAndLazyFetch;

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
        l2.setRam(32);


        Aline a1=new Aline();
        a1.setAid(101);
        a1.setAname("Ashwini");
        a1.setTech("Java");

        Aline a2=new Aline();
        a2.setAid(102);
        a2.setAname("Raj");
        a2.setTech("Python");


        a1.setLaptops(Arrays.asList(l1,l2));
        a2.setLaptops(Arrays.asList(l3));

        SessionFactory sf= new Configuration()
                .addAnnotatedClass(Aline.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();

       session.persist(a1);
       session.persist(a2);


       session.persist(l1);
       session.persist(l2);
       session.persist(l3);

        Transaction transaction =session.beginTransaction();
        transaction.commit();


        Aline a5= session.find(Aline.class,101);
        System.out.println(a5);
        //Level 1 Cache (Default)
        //Works within the same session
        //Enabled automatically
        //If object already exists in session:
        //Hibernate does not hit the database
        //Returns object from cache
        //This is why:
        //Persist + Get in same session
        //No SELECT query fired


        Session session1= sf.openSession();

       Aline a6= session1.find(Aline.class,101);
        System.out.println(a5);


       session1.close();


    }
}