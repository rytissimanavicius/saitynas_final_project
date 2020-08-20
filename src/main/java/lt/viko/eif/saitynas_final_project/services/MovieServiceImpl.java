package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.database.MovieDAO;
import lt.viko.eif.saitynas_final_project.database.MovieDAOImpl;

@Path("movie")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieServiceImpl implements MovieService{
	private MovieDAO movieDAO = new MovieDAOImpl();
	
	@POST
	@Override
	public Response addMovie(Movie movie, @Context UriInfo uriInfo) {
		if (movieDAO.addMovie(movie) != 0) {
			//
			return Response.ok("Added successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@DELETE
	@Override
	@Path("{id}")
	public Response deleteMovieById(@PathParam("id") int id) {
		if (movieDAO.deleteMovieById(id) != 0) {
			//
			return Response.ok("Deleted successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@PUT
	@Override
	public Response updateMovieById(Movie movie, @Context UriInfo uriInfo) {
		if (movieDAO.updateMovieById(movie) != 0) {
			//
			return Response.ok("Updated successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@GET
	@Override
	@Path("{id}")
	public Response getMovieById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Movie movie = movieDAO.getMovieById(id);
		
		if (movie != null) {
			//
			return Response.ok(movie).build();
		}
		return Response.serverError().build();
	}
}
