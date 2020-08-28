package lt.viko.eif.saitynas_final_project.services;

import java.net.URI;
import java.net.URLDecoder;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.database.StaffDAO;
import lt.viko.eif.saitynas_final_project.database.StaffDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Staff;

import javax.ws.rs.core.MediaType;

/**
 * RESTful web service implementation which allows to perform CRUD operations with staff objects.
 * @author Rytis Simanavicius
 *
 */
@Path("staff")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StaffServiceImpl implements StaffService{
	private StaffDAO staffDAO = new StaffDAOImpl();
	
	@POST
	@Override
	public Response addStaff(Staff staff, @Context UriInfo uriInfo) {
		if (staffDAO.addStaff(staff) != 0) {
			staff.addLink(getUriForSelf(uriInfo, staff.getId()), "self");
			return Response.ok(staff).build();
		}
		return Response.serverError().build();
	}
	
	@DELETE
	@Override
	@Path("{id}")
	public Response deleteStaffById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		if (staffDAO.deleteStaffById(id) != 0)
			return Response.ok("Deleted successfully!").build();
		
		return Response.serverError().build();
	}
	
	@PUT
	@Override
	public Response updateStaffById(Staff staff, @Context UriInfo uriInfo) {
		if (staffDAO.updateStaffById(staff) != 0) {
			staff.addLink(getUriForSelf(uriInfo, staff.getId()), "self");
			return Response.ok(staff).build();
		}
		return Response.serverError().build();
	}
	
	@GET
	@Override
	@Path("{id}")
	public Response getStaffById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Staff staff = staffDAO.getStaffById(id);
		
		if (staff != null) {
			staff.addLink(getUriForSelf(uriInfo, staff.getId()), "self");
			
			CacheControl cacheControl = new CacheControl();
	        cacheControl.setMaxAge(60);

	        return Response.ok(staff).cacheControl(cacheControl).build();
		}
		return Response.serverError().build();
	}
	
	/**
	 * Returns URI of an object.
	 * @param uriInfo
	 * @param id
	 * @return
	 */
	private String getUriForSelf(UriInfo uriInfo, int id) {
        URI uri = null;
        String idString = String.valueOf(id);
        
        try {
            uri = uriInfo.getBaseUriBuilder().path(this.getClass()).path(this.getClass(), "getStaffById")
                    .resolveTemplate("id", URLDecoder.decode(idString, "UTF-8")).build();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return uri.toString();
    }
}