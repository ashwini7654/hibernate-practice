package com.telsko7ChangeTableName;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Aline a1=new Aline();
        a1.setAid(101);
        a1.setAname("Ashwini");
        a1.setTech("Java");

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