package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.RatingRequestOMDB;

/**
 * RESTful web service interface which allows to perform CRUD operations with rating objects.
 * @author Rytis Simanavicius
 *
 */
public interface RatingService {
	/**
	 * Request to add a rating to the database of a provided movie.
	 * @param requestTemplate
	 * @param uriInfo
	 * @return
	 */
	Response addRating(RatingRequestOMDB requestTemplate, @Context UriInfo uriInfo);
	
	/**
	 * Request to delete rating object from the database that matches the given id.
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("{id}")
	Response deleteRatingById(@PathParam("id") int id, @Context UriInfo uriInfo);
	
	/**
	 * Request to update a rating in the database of a provided movie.
	 * @param requestTemplate
	 * @param uriInfo
	 * @return
	 */
	Response updateRatingByName(RatingRequestOMDB requestTemplate, @Context UriInfo uriInfo);
	
	/**
	 * Request to return a rating from the database that matches the given id.
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("{id}")
	Response getRatingById(@PathParam("id") int id, @Context UriInfo uriInfo);
}
