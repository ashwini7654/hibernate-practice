package com.telsko2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student s1=new Student();
        Scanner kb=new Scanner(System.in);
        System.out.println("Enter Student roll no :");
        int roll=kb.nextInt();
        kb.nextLine(); // consume leftover newline
        System.out.println("Enter Name of Student:");
        String name=kb.nextLine();
        System.out.println("Enter age of Student:");
        int age=kb.nextInt();
        s1.setRollno(roll);
        s1.setAge(age);
        s1.setName(name);

//        Configuration cfg=new Configuration();
//
//        cfg.addAnnotatedClass(Student.class);
//
//        cfg.configure();

        SessionFactory sf= new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        //session factory is heavy weight object since it should try catch or it should be close

        Session session=sf.openSession();
        Transaction transaction =session.beginTransaction();
        session.persist(s1);
        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);


    }
}