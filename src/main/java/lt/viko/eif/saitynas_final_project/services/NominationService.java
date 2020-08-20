package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Nomination;

public interface NominationService {
	Response addNomination(Nomination nomination, @Context UriInfo uriInfo);
	
	@Path("{id}")
	Response deleteNominationById(@PathParam("id") int id);
	
	Response updateNominationById(Nomination nomination, @Context UriInfo uriInfo);
	
	@Path("{id}")
	Response getNominationById(@PathParam("id") int id, @Context UriInfo uriInfo);

}
