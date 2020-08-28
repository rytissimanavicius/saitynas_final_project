package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Genre;

/**
 * RESTful web service interface which allows to perform CRUD operations with genre objects.
 * @author Erikas Bykovskis
 *
 */
public interface GenreService {
	
	/**
	 * Request to add provided genre object to the database.
	 * @param genre
	 * @param uriInfo
	 * @return
	 */
	Response addGenre(Genre genre, @Context UriInfo uriInfo);
	
	/**
	 * Request to delete genre object from the database that matches the given id.
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("{id}")
	Response deleteGenreById(@PathParam("id") int id, @Context UriInfo uriInfo);
	
	/**
	 * Request to update a genre object in the database with a provided one if id matches.
	 * @param genre
	 * @param uriInfo
	 * @return
	 */
	Response updateGenreById(Genre genre, @Context UriInfo uriInfo);
	
	/**
	 * Request to return a movie from the database that matches the given id.
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("{id}")
	Response getGenreById(@PathParam("id") int id, @Context UriInfo uriInfo);
}
