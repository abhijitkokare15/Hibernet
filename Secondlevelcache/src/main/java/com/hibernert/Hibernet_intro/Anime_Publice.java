
package com.hibernert.Hibernet_intro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Anime_Publice {

    public static void main(String[] args) {

        Configuration cf = new Configuration();
        cf.configure().addAnnotatedClass(Anime.class);

        SessionFactory sf = cf.buildSessionFactory();

        Session s1 = sf.openSession();

        try {
            // First Session
            Anime a1 = s1.get(Anime.class, 102);
            Anime a2 = s1.get(Anime.class, 102);
            Anime a3 = s1.get(Anime.class, 102);

           
          
            s1.close();

            Session s2 = sf.openSession();

            Anime a4 = s2.get(Anime.class, 102);

       

            s2.close();

        } finally {
            sf.close();
        }
    }
}
