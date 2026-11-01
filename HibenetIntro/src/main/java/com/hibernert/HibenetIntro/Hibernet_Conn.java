package com.hibernert.HibenetIntro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Hibernet_Conn 
{
    public static void main( String[] args )
    {
        Anime naruto = new Anime();
        naruto.setAnime_id(101);
        naruto.setName("Naruto Shippuden");
        naruto.setRelease_date(2017);
        
        Configuration cf = new Configuration();
        SessionFactory sf = cf.buildSessionFactory();
        Session s = sf.openSession();
    }
}
