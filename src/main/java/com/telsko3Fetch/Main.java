package com.telsko3Fetch;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s1=null;
        SessionFactory sf= new Configuration()
                .addAnnotatedClass(Student.class)
                .configure()
                .buildSessionFactory();

        //session factory is heavy weight object since it should try catch or it should be close

        Session session=sf.openSession();

        s1=session.find(Student.class,53);
        //hibernate 7.1 ke get() is depcricated after that find in new hibernate

        session.close();
        sf.close();

        System.out.println(s1);


    }
}