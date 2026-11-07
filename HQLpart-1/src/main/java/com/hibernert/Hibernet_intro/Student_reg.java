package com.hibernert.Hibernet_intro;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Student_reg {
    public static void main(String[] args) {
          
    	Random r = new Random();

        Configuration cf = new Configuration();
        cf.configure().addAnnotatedClass(Student.class);
        
        StandardServiceRegistry sr =
                new StandardServiceRegistryBuilder()
                        .applySettings(cf.getProperties())
                        .build();

        SessionFactory sf = cf.buildSessionFactory(sr);
        Session s1 = sf.openSession();
        

        Transaction tx = s1.beginTransaction();

//          for (int i=1;i<=10;i++)
//        {
//	             Student s = new Student(100+i,"Student"+i,r.nextInt(100));
//	             s1.persist(s);
//	             
//           }
     
        Query q1  = s1.createQuery("from Student where marks < 45");
        
        List<Student> ls = q1.list();
        
        for(Student stud: ls)
        {
        	System.out.println(stud);
        }
        
        
        tx.commit(); 

        s1.close();
        sf.close();
    }
}