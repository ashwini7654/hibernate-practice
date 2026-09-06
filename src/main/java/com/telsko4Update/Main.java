package com.telsko4Update;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner kb= new Scanner(System.in);
        System.out.println("Enter  Student 's roll to update age :");
        int roll= kb.nextInt();
        Student s1=new Student();

        SessionFactory sf= new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        //session factory is heavy weight object since it should try catch or it should be close

        Session session=sf.openSession();

        s1=session.find(Student.class,roll);

        //hibernate 7.1 ke get() is depcricated after that find in new hibernate
      String name=  s1.getName();
        Transaction transaction = session.beginTransaction();
        System.out.println("Enter new age of " + name);
        int newage= kb.nextInt();
        s1.setAge(newage);

        session.merge(s1);
        // merge is used to update  if there  can be update if there is  not update then create  in DB
        transaction.commit();
        session.close();
        sf.close();

        System.out.println(s1);


    }
}