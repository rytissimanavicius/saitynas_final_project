package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Movie;

/**
 * RESTful web service interface which allows to perform CRUD operations with movie objects.
 * @author Rytis Simanavicius
 *
 */
public interface MovieService {
	/**
	 * Request to add provided movie object to the database.
	 * @param movie
	 * @param uriInfo
	 * @return
	 */
	Response addMovie(Movie movie, @Context UriInfo uriInfo);
	
	/**
	 * Request to delete movie object from the database that matches the given id.
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("{id}")
	Response deleteMovieById(@PathParam("id") int id, @Context UriInfo uriInfo);
	
	/**
	 * Request to update a movie object in the database with a provided one if id matches.
	 * @param movie
	 * @param uriInfo
	 * @return
	 */
	Response updateMovieById(Movie movie, @Context UriInfo uriInfo);
	
	/**
	 * Request to return a movie from the database that matches the given title.
	 * @param title
	 * @param uriInfo
	 * @return
	 */
	@Path("{title}")
	Response getMovieByTitle(@PathParam("title") String title, @Context UriInfo uriInfo);
}
