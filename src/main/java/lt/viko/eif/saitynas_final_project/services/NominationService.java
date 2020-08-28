package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Nomination;

/**
 * RESTful web service interface which allows to perform CRUD operations with nomination objects.
 * @author Erikas Bykovskis
 *
 */
public interface NominationService {
	
	/**
	 * Request to add provided nomination object to the database.
	 * @param nomination
	 * @param uriInfo
	 * @return
	 */
	Response addNomination(Nomination nomination, @Context UriInfo uriInfo);
	
	/**
	 * Request to delete nomination object from the database that matches the given id.
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("{id}")
	Response deleteNominationById(@PathParam("id") int id);
	
	/**
	 * Request to update a nomination object in the database with a provided one if id matches.
	 * @param nomination
	 * @param uriInfo
	 * @return
	 */
	Response updateNominationById(Nomination nomination, @Context UriInfo uriInfo);
	
	/**
	 * Request to return a movie from the database that matches the given id.
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("{id}")
	Response getNominationById(@PathParam("id") int id, @Context UriInfo uriInfo);

}
