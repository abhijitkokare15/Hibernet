package com.hibernert.Hibernet_intro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Student_reg {

    public static void main(String[] args) {

        Student s = new Student(111, "Sanman", 85);
        Student s2 = new Student(113,"Chuk",90);
        

       
        Configuration cf = new Configuration();
        cf.configure().addAnnotatedClass(Student.class);

        StandardServiceRegistry sr =
                new StandardServiceRegistryBuilder()
                        .applySettings(cf.getProperties())
                        .build();

        SessionFactory sf = cf.buildSessionFactory(sr);
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();
            
       
        s1.persist(s2);
        System.out.println("Waithing for query");
       
        tx.commit();
        

        s1.close();
        sf.close();
    }
}