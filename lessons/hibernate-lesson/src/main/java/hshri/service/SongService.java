package hshri.service;



import hshri.model.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SongService {

//    @PersistenceContext // or even @Autowired
//    private EntityManager entityManager;





    public void method(SessionFactory sessionFactory){

        Song song = new Song();
        song.setId(2);
        song.setSongName("Nane1");
        song.setArtist("Bab");
//        entityManager.persist(song);
        sessionFactory.getCurrentSession().save(song);

    }

}