package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.RatingRequestOMDB;

public interface RatingService {
	Response addRating(RatingRequestOMDB requestTemplate, @Context UriInfo uriInfo);
	
	@Path("{id}")
	Response deleteRatingById(@PathParam("id") int id, @Context UriInfo uriInfo);
	
	Response updateRatingByName(RatingRequestOMDB requestTemplate, @Context UriInfo uriInfo);
	
	@Path("{id}")
	Response getRatingById(@PathParam("id") int id, @Context UriInfo uriInfo);
}
