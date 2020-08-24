package lt.viko.eif.saitynas_final_project.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.database.MovieDAO;
import lt.viko.eif.saitynas_final_project.database.MovieDAOImpl;
import lt.viko.eif.saitynas_final_project.database.RatingDAO;
import lt.viko.eif.saitynas_final_project.database.RatingDAOImpl;
import lt.viko.eif.saitynas_final_project.database.StaffDAO;
import lt.viko.eif.saitynas_final_project.database.StaffDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.MovieSearch;
import lt.viko.eif.saitynas_final_project.objects.Rating;
import lt.viko.eif.saitynas_final_project.objects.Staff;

@Path("finder")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieFinderServiceImpl implements MovieFinderService{
	private StaffDAO staffDAO = new StaffDAOImpl();
	private MovieDAO movieDAO = new MovieDAOImpl();
	private RatingDAO ratingDAO = new RatingDAOImpl();
	
	@POST
	@Path("byStaff")
	@Override
	public Response getMoviesByStaff(Staff staff, @Context UriInfo uriInfo) {
		List<Movie> retrievedMovies = staffDAO.getMoviesByStaff(staff);
		
		if (retrievedMovies.size() > 0)
			return Response.ok(retrievedMovies).build();
		
		return Response.serverError().build();
	}
	
	@POST
	@Path("byAttributes")
	@Override
	public Response getMoviesByAttributes(MovieSearch movieSearch, @Context UriInfo uriInfo) {
		List<Movie> retrievedMovies = movieDAO.getMoviesByAttributes(movieSearch);
		
		if (retrievedMovies.size() > 0)
			return Response.ok(retrievedMovies).build();
		
		return Response.serverError().build();
	}
	
	@POST
	@Path("byRatings")
	@Override
	public Response getMoviesByRatings(Rating rating, @Context UriInfo uriInfo) {
		List<Movie> retrievedMovies = ratingDAO.getMoviesByRatings(rating);
		
		if (retrievedMovies.size() > 0)
			return Response.ok(retrievedMovies).build();
		
		return Response.serverError().build();
	}
}
