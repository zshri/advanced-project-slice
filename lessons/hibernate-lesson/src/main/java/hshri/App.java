package hshri;

import hshri.model.Song;
import hshri.service.SongService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */


public class App {




    public static void main(String[] args) throws InterruptedException {


        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);


        // Create Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        // Initialize Session Object
        Session session = sessionFactory.openSession();


        new SongService().method(sessionFactory);

//
//        Song song1 = new Song();
//        song1.setId(1);
//        song1.setSongName("Broken Angel");
//        song1.setArtist("Akon");
//
//        session.beginTransaction();
//
//        // Here we have used
//        // save() method of JPA
//        session.save(song1);
//
//        session.getTransaction().commit();
//
//
//session.beginTransaction();
//        Song song2 = new Song();
//        song2.setId(2);
//        song2.setSongName("Nane1");
//        song2.setArtist("Bab");
////        entityManager.persist(song);
//        session.save(song2);
//
//session.getTransaction().commit();
//
//
////session.setFlushMode();




        Thread.sleep(10000);

    }
}
