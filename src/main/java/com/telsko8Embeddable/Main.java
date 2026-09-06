package com.telsko8Embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
       Laptop l1= new Laptop();
        l1.setBrand("MSI");
        l1.setModel("Thin Gf63 12UC");
        l1.setRam(16);

        Aline a1=new Aline();
        a1.setAid(101);
        a1.setAname("Ashwini");
        a1.setTech("Java");
        a1.setLaptop(l1);




        Configuration cfg=new Configuration();
        cfg.addAnnotatedClass(Aline.class);
        cfg.configure();
        SessionFactory sf= cfg.buildSessionFactory();
        Session session=sf.openSession();

       session.persist(a1);
        Transaction transaction =session.beginTransaction();


        transaction.commit();
        //Data is permanently stored in the database




    }
}