package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Staff;

public interface StaffService {
	Response addStaff(Staff staff, @Context UriInfo uriInfo);
	
	@Path("{id}")
	Response deleteStaffById(@PathParam("id") int id);
	
	Response updateStaffById(Staff staff, @Context UriInfo uriInfo);
	
	@Path("{id}")
	Response getStaffById(@PathParam("id") int id, @Context UriInfo uriInfo);
}
