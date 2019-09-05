package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private MovieFacade() {
       
    }
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Movie> getMovies(){
        EntityManager em = getEntityManager();
        TypedQuery tq = em.createNamedQuery("Movies.all", Movie.class);
        List<Movie> movies = tq.getResultList();
        return movies;
    }
    public Movie getMovieByName(String name){
        EntityManager em = getEntityManager();
        TypedQuery tq = em.createNamedQuery("Movies.getMovieByName", Movie.class);
        tq.setParameter("name", name);
        Movie movie = (Movie) tq.getSingleResult();
        return movie;
        
    }
    public Movie createMovie(Movie mov){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(mov);
        em.getTransaction().commit();
        return mov;
    }
   
    

}
