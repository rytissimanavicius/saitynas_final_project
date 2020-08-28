package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Staff;

/**
 * RESTful web service interface which allows to perform CRUD operations with staff objects.
 * @author Rytis Simanavicius
 *
 */
public interface StaffService {
	/**
	 * Request to add provided staff object to the database.
	 * @param staff
	 * @param uriInfo
	 * @return
	 */
	Response addStaff(Staff staff, @Context UriInfo uriInfo);
	
	/**
	 * Request to delete staff object from the database that matches the given id.
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("{id}")
	Response deleteStaffById(@PathParam("id") int id, @Context UriInfo uriInfo);
	
	/**
	 * Request to update a staff object in the database with a provided one if id matches.
	 * @param staff
	 * @param uriInfo
	 * @return
	 */
	Response updateStaffById(Staff staff, @Context UriInfo uriInfo);
	
	/**
	 * Request to return a movie from the database that matches the given id.
	 * @param id
	 * @param uriInfo
	 * @return
	 */
	@Path("{id}")
	Response getStaffById(@PathParam("id") int id, @Context UriInfo uriInfo);
}
