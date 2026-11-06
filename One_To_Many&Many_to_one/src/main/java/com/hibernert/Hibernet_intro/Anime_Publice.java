package com.hibernert.Hibernet_intro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Anime_Publice {
    public static void main(String[] args) {
    	
    	Anime_relase ar = new Anime_relase();
       ar.setDate(1);
       ar.setMonth("Aug");
       ar.setYear(2017);

 	Anime op = new Anime();
 	op.setAnime_id(104);
 	op.setAnime_Name("Naruto shippuden");
 	op.setRelease_date(ar);
 	
 	Audeince a1 = new Audeince();
 
 	a1.setAude_id(105);
 	a1.setName("Nagato");
 	a1.setDate("12-apr-2026");
 	a1.setAnime(op);
    	
        Configuration cf = new Configuration();
        cf.configure().addAnnotatedClass(Anime.class).addAnnotatedClass(Audeince.class);
        
        
        StandardServiceRegistry sr =
                new StandardServiceRegistryBuilder()
                        .applySettings(cf.getProperties())
                        .build();

        SessionFactory sf = cf.buildSessionFactory(sr);
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();

//        s1.persist(op);
//        s1.persist(a1);
//        
        
        Audeince a2 = s1.get(Audeince.class,104);
        
        System.out.println(a2);
        
        
        
        
//        for(int i=1;i<=2;i++)
//        {
//        	//Anime name = s1.get(Anime.class,100+i);
//        	Anime name = (Anime) s1.load(Anime.class,100+i);
//        	System.out.println(name);
//        }

        tx.commit(); 

        s1.close();
        sf.close();
    }
}