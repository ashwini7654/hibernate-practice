package com.telsko14HQLFetching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;


public class Main {
    public static void main(String[] args) {
//        Laptop l1= new Laptop();
//        l1.setlId(1);
//        l1.setBrand("MSI");
//        l1.setModel("Thin Gf63 12UC");
//        l1.setRam(16);
//        Laptop l2= new Laptop();
//        l2.setlId(2);
//        l2.setBrand("Dell");
//        l2.setModel("XPS");
//        l2.setRam(16);
//        Laptop l3= new Laptop();
//        l3.setlId(3);
//        l3.setBrand("Apple");
//        l3.setModel("MackBook");
//        l3.setRam(32);
//        Laptop l4= new Laptop();
//        l4.setlId(4);
//        l4.setBrand("HP");
//        l4.setModel("Cxom");
//        l4.setRam(8);



        SessionFactory sf= new Configuration()
                .addAnnotatedClass(Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session=sf.openSession();
//        session.persist(l1);
//        session.persist(l2);
//        session.persist(l3);
//        session.persist(l4);

        Transaction transaction =session.beginTransaction();
        transaction.commit();

         //Select * from laptop where ram=32-->SQL
        //   from  Laptop where ram=32-->HQL
        Query query=session.createQuery("from Laptop where ram=32 ",Laptop.class);
        List<Laptop>laptops=query.getResultList();
        System.out.println(laptops);


        //Data is permanently stored in the database





    }
}