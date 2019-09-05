package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Movie;
import utils.EMF_Creator;
import facades.MovieFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/movies",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final MovieFacade FACADE = MovieFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    
    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovies(){
        List<Movie> movies = FACADE.getMovies();
        return Response.ok().entity(GSON.toJson(movies)).build();
    }
    @Path("/demo")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    @Path("/name/{name}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovieByName(@PathParam("name")String name){
//        String str = name.replaceAll("\\s+","");
        Movie mov = FACADE.getMovieByName(name);
        return Response.ok().entity(GSON.toJson(mov)).build();
        
    }

    @Path("/populatewithdummymovies")
    @GET
//    @Produces({MediaType.APPLICATION_JSON})
    public String populate(){
        FACADE.createMovie(new Movie(1L, "The Lion King", "Disney", 1.22, 9.0));
        FACADE.createMovie(new Movie(2L, "Return of the King", "Fantasy", 3.01, 8.0));
        FACADE.createMovie(new Movie(3L, "Braindead", "Splatter", 1.42, 7.0));
        FACADE.createMovie(new Movie(4L, "Fifty Shades of Grey", "Chick Flick", 2.0, 1.0));
        FACADE.createMovie(new Movie(5L, "Asterix and Obelix", "Cartoon", 1.42, 5.0));
        FACADE.createMovie(new Movie(6L, "Book of Eli", "Post Apocalyptic", 1.52, 9.5));
        FACADE.createMovie(new Movie(7L, "Deadpool", "Action", 1.55, 10.0));
        return "Succes!!!";
    }


    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Movie entity) {
        throw new UnsupportedOperationException();
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(Movie entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
    
    
}
