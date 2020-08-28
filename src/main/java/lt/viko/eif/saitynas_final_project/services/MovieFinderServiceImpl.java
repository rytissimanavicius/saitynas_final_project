package lt.viko.eif.saitynas_final_project.services;

import java.net.URI;
import java.net.URLDecoder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.jcabi.aspects.Cacheable;

import lt.viko.eif.saitynas_final_project.database.GenreDAO;
import lt.viko.eif.saitynas_final_project.database.GenreDAOImpl;
import lt.viko.eif.saitynas_final_project.database.MovieDAO;
import lt.viko.eif.saitynas_final_project.database.MovieDAOImpl;
import lt.viko.eif.saitynas_final_project.database.NominationDAO;
import lt.viko.eif.saitynas_final_project.database.NominationDAOImpl;
import lt.viko.eif.saitynas_final_project.database.RatingDAO;
import lt.viko.eif.saitynas_final_project.database.RatingDAOImpl;
import lt.viko.eif.saitynas_final_project.database.StaffDAO;
import lt.viko.eif.saitynas_final_project.database.StaffDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Genre;
import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.MovieSearch;
import lt.viko.eif.saitynas_final_project.objects.Nomination;
import lt.viko.eif.saitynas_final_project.objects.RatingSearch;
import lt.viko.eif.saitynas_final_project.objects.Staff;

/**
 * RESTful web service implementation of methods that are used in finding movies.
 * @author Rytis Simanavicius
 *
 */
@Path("finder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieFinderServiceImpl implements MovieFinderService{
	private StaffDAO staffDAO = new StaffDAOImpl();
	private MovieDAO movieDAO = new MovieDAOImpl();
	private RatingDAO ratingDAO = new RatingDAOImpl();
	private GenreDAO genreDAO = new GenreDAOImpl();
	private NominationDAO nominationDAO = new NominationDAOImpl();
	
	@POST
	@Path("byStaff")
	@Override
	public Response getMoviesByStaff(Staff staff, @Context UriInfo uriInfo) {
		List<Movie> retrievedMovies = staffDAO.getMoviesByStaff(staff);
		
		for (Movie movie : retrievedMovies)
			movie.addLink(getUriForSelf(uriInfo, movie.getTitle()), "self");
		
		if (retrievedMovies.size() > 0)
			return Response.ok(retrievedMovies).build();
		
		return Response.serverError().build();
	}
	
	@POST
	@Path("byAttributes")
	@Override
	public Response getMoviesByAttributes(MovieSearch movieSearch, @Context UriInfo uriInfo) {
		List<Movie> retrievedMovies = movieDAO.getMoviesByAttributes(movieSearch);
		
		for (Movie movie : retrievedMovies)
			movie.addLink(getUriForSelf(uriInfo, movie.getTitle()), "self");
		
		if (retrievedMovies.size() > 0)
			return Response.ok(retrievedMovies).build();
		
		return Response.serverError().build();
	}
	
	@POST
	@Path("byRatings")
	@Override
	public Response getMoviesByRatings(RatingSearch ratingSearch, @Context UriInfo uriInfo) {
		List<Movie> retrievedMovies = ratingDAO.getMoviesByRatings(ratingSearch);
		
		for (Movie movie : retrievedMovies)
			movie.addLink(getUriForSelf(uriInfo, movie.getTitle()), "self");
		
		if (retrievedMovies.size() > 0)
			return Response.ok(retrievedMovies).build();
		
		return Response.serverError().build();
	}
	
	@GET
	@Cacheable(lifetime = 60, unit = TimeUnit.SECONDS)
	@Override
	@Path("{title}")
	public Response getMovieByTitle(@PathParam(value = "title") String title, @Context UriInfo uriInfo) {
		Movie movie = movieDAO.getMovieByTitle(title);
		
		if (movie != null) {
			movie.addLink(getUriForSelf(uriInfo, movie.getTitle()), "self");
			
			CacheControl cacheControl = new CacheControl();
	        cacheControl.setMaxAge(60);

	        return Response.ok(movie).cacheControl(cacheControl).build();
		}
		return Response.serverError().build();
	}
	
	/**
	 * Returns URI of an object.
	 * @param uriInfo
	 * @param title
	 * @return
	 */
	private String getUriForSelf(UriInfo uriInfo, String title) {
        URI uri = null;
        
        try {
            uri = uriInfo.getBaseUriBuilder().path(this.getClass()).path(this.getClass(), "getMovieByTitle")
                    .resolveTemplate("title", URLDecoder.decode(title, "UTF-8")).build();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return uri.toString();
    }

	@POST
	@Path("byGenres")
	@Override
	public Response getMoviesByGenres(Genre genre, @Context UriInfo uriInfo) {
		List<Movie> retrievedMovies = genreDAO.getMoviesByGenres(genre);
		
		for (Movie movie : retrievedMovies)
			movie.addLink(getUriForSelf(uriInfo, movie.getTitle()), "self");
		
		if (retrievedMovies.size() > 0)
			return Response.ok(retrievedMovies).build();
		
		return Response.serverError().build();
	}

	@POST
	@Path("byNominations")
	@Override
	public Response getMoviesByNominations(Nomination nomination, @Context UriInfo uriInfo) {
		List<Movie> retrievedMovies = nominationDAO.getMoviesByNominations(nomination);
		
		for (Movie movie : retrievedMovies)
			movie.addLink(getUriForSelf(uriInfo, movie.getTitle()), "self");
		
		if (retrievedMovies.size() > 0)
			return Response.ok(retrievedMovies).build();
		
		return Response.serverError().build();
	}
}
