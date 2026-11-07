package com.hibernert.Hibernet_intro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Anime_Publice {
    public static void main(String[] args) {

//        Anime Naruto = new Anime();
//        

//        Naruto.setAnime_id(101);
//        Naruto.setAnime_Name("Naruto Shipudden");
//        Naruto.setAnime_Year(2017);
    	
    	Anime dn = new Anime();
    	dn.setAnime_id(102);
    	dn.setAnime_Name("Death Note");
    	dn.setAnime_Year(2020);
    	
    	
        
        

        Configuration cf = new Configuration();
        cf.configure().addAnnotatedClass(Anime.class);

        SessionFactory sf = cf.buildSessionFactory();
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();

        s1.persist(dn);

        tx.commit();  // Save changes in the database

        s1.close();
        sf.close();
    }
}

//Method	Purpose
//update()	Reattach a detached object to the Session (legacy API).
//delete()	Delete an object (legacy API).
//merge()	Copy detached object's data into a managed object.
//remove()	Mark a managed object for deletion.
//persist()	Make a new object persistent.