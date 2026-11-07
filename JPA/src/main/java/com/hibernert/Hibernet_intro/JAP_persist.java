package com.hibernert.Hibernet_intro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JAP_persist {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("u1");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Anime anime = new Anime();

            anime.setAnime_id(110);
            anime.setAnime_Name("Naruto");
            anime.setAnime_Year(2005);

            em.persist(anime);

            tx.commit();

            System.out.println("Anime inserted successfully!");

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }

            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }
    }
}