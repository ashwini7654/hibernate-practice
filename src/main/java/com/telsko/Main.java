package com.telsko;
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

        Configuration cfg=new Configuration();
        //Used to configure db connection and mappings.

        cfg.addAnnotatedClass(com.telsko.Student.class);
        //Registers the Student class as an entity.Hibernate reads annotations like @Entity, @Id, @Column.

        cfg.configure();
        //its load hibernate.cfg.xml from the classpath,Reads DB URL, username, password, dialect, etc.

        SessionFactory sf= cfg.buildSessionFactory();
        // Creates SessionFactory.This object is thread-safe and should be created once per application.

        Session session=sf.openSession();
        //Opens a new Hibernate session.Used to perform CRUD operation

        Transaction transaction =session.beginTransaction();
        //Starts a database transaction.Required for insert, update, and delete operations.

        session.persist(s1);
        //session.save phle tha but after hibernnate 7 comes save is removed
        //Saves the object into the database
        //Changes object state from transient → persistent.
        //Recommended in Hibernate 6/7

        transaction.commit();
        //Data is permanently stored in the database

        System.out.println(s1);


    }
}