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
import javax.ws.rs.core.MediaType;

import lt.viko.eif.saitynas_final_project.database.NominationDAO;
import lt.viko.eif.saitynas_final_project.database.NominationDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Nomination;

@Path("genre")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class NominationServiceImpl implements NominationService{
	private NominationDAO nominationDAO = new NominationDAOImpl();

	@POST
	@Override
	public Response addNomination(Nomination nomination, @Context UriInfo uriInfo) {
		if (nominationDAO.addNomination(nomination) != 0) {
			//
			return Response.ok("Added successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@DELETE
	@Override
	@Path("{id}")
	public Response deleteNominationById(@PathParam("id") int id) {
		if (nominationDAO.deleteNominationById(id) != 0) {
			//
			return Response.ok("Deleted successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@PUT
	@Override
	public Response updateNominationById(Nomination nomination, @Context UriInfo uriInfo) {
		if (nominationDAO.updateNominationById(nomination) != 0) {
			//
			return Response.ok("Updated successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@GET
	@Override
	@Path("{id}")
	public Response getNominationById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Nomination nomination = nominationDAO.getNominationById(id);
		
		if (nomination != null) {
			//
			return Response.ok(nomination).build();
		}
		return Response.serverError().build();
	}
}
