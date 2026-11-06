
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
        op.setAnime_id(101);
        op.setAnime_Name("Attack on titan");
        op.setRelease_date(ar);

        Anime op2 = new Anime();
        op2.setAnime_id(102);
        op2.setAnime_Name("One punch");
        op2.setRelease_date(ar);

        Audeince a1 = new Audeince();
        a1.setAude_id(101);
        a1.setName("Nagato");
        a1.setDate("12-apr-2026");

        // Set Many-to-One relationship
        op.setAudience(a1);
        op2.setAudience(a1);

        // Add Anime to Audience list
        a1.getMylist().add(op);
        a1.getMylist().add(op2);

        Configuration cf = new Configuration();

        cf.configure()
          .addAnnotatedClass(Anime.class)
          .addAnnotatedClass(Audeince.class);

        StandardServiceRegistry sr =
            new StandardServiceRegistryBuilder()
                .applySettings(cf.getProperties())
                .build();

        SessionFactory sf = cf.buildSessionFactory(sr);
        Session s1 = sf.openSession();

        Transaction tx = s1.beginTransaction();

//        s1.persist(a1);
//        s1.persist(op);
//        s1.persist(op2);

        Audeince a2 = s1.get(Audeince.class, 101);

        System.out.println(a2);

        tx.commit();

        s1.close();
        sf.close();

        StandardServiceRegistryBuilder.destroy(sr);
    }
}
