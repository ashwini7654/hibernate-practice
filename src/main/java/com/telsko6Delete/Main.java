package com.telsko6Delete;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the roll to Delete Student  ");
        Scanner kb =new Scanner(System.in);
        int roll= kb.nextInt();
        Student s1=null;

        SessionFactory sf= new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();



        Session session=sf.openSession();

        s1=session.find(Student.class,roll);

        Transaction transaction= session.beginTransaction();
        session.remove(s1);

        transaction.commit();
        session.close();
        sf.close();
        System.out.println(s1);


    }
}