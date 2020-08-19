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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.database.StaffDAO;
import lt.viko.eif.saitynas_final_project.database.StaffDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Staff;

import javax.ws.rs.core.MediaType;

@Path("staff")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StaffServiceImpl implements StaffService{
	private StaffDAO staffDAO = new StaffDAOImpl();
	
	@POST
	@Override
	public Response addStaff(Staff staff, @Context UriInfo uriInfo) {
		if (staffDAO.addStaff(staff) != 0) {
			//
			return Response.ok("Added successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@DELETE
	@Override
	@Path("{id}")
	public Response deleteStaffById(@PathParam("id") int id) {
		if (staffDAO.deleteStaffById(id) != 0) {
			//
			return Response.ok("Deleted successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@PUT
	@Override
	public Response updateStaffById(Staff staff, @Context UriInfo uriInfo) {
		if (staffDAO.updateStaffById(staff) != 0) {
			//
			return Response.ok("Updated successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@GET
	@Override
	@Path("{id}")
	public Response getStaffById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Staff staff = staffDAO.getStaffById(id);
		
		if (staff != null) {
			//
			return Response.ok(staff).build();
		}
		return Response.serverError().build();
	}
}