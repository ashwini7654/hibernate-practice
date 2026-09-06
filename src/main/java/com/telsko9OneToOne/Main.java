package com.telsko9OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
       Laptop l1= new Laptop();
        l1.setlId(1);
        l1.setBrand("MSI");
        l1.setModel("Thin Gf63 12UC");
        l1.setRam(16);

        Aline a1=new Aline();
        a1.setAid(101);
        a1.setAname("Ashwini");
        a1.setTech("Java");
        a1.setLaptop(l1);



        SessionFactory sf= new Configuration()
                .addAnnotatedClass(Aline.class)
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();

       session.persist(a1);
       session.persist(l1);

        Transaction transaction =session.beginTransaction();


        transaction.commit();
        //Data is permanently stored in the database




    }
}