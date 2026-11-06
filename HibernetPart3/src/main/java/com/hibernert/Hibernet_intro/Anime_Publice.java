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
       ar.setDate(25);
       ar.setMonth("May");
       ar.setYear(2020);

 	Anime op = new Anime();
 	op.setAnime_id(103);
 	op.setAnime_Name("One piece");
 	op.setRelease_date(ar);
 	 
    	
        Configuration cf = new Configuration();
        cf.configure().addAnnotatedClass(Anime.class);
        
        StandardServiceRegistry sr =
                new StandardServiceRegistryBuilder()
                        .applySettings(cf.getProperties())
                        .build();

        SessionFactory sf = cf.buildSessionFactory(sr);
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();

        s1.persist(op);
        
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