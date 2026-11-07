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

        // 1. Transient state
        Configuration cf = new Configuration();
        cf.configure().addAnnotatedClass(Student.class);

        StandardServiceRegistry sr =
                new StandardServiceRegistryBuilder()
                        .applySettings(cf.getProperties())
                        .build();

        SessionFactory sf = cf.buildSessionFactory(sr);
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();

        // 2. Persistent state
        s1.persist(s);

        s.setMarks(90);

        // 3. Detached state
        s1.detach(s);

        // 4. Reattach the object
        s1.merge(s);

        // 5. Removed state
        s1.remove(s);

        tx.commit();

        s1.close();
        sf.close();
    }
}