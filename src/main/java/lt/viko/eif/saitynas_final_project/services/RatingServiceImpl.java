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

import lt.viko.eif.saitynas_final_project.database.RatingDAO;
import lt.viko.eif.saitynas_final_project.database.RatingDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Rating;

@Path("rating")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RatingServiceImpl implements RatingService{
	private RatingDAO ratingDAO = new RatingDAOImpl();
	
	@POST
	@Override
	public Response addRating(Rating rating, @Context UriInfo uriInfo) {
		if (ratingDAO.addRating(rating) != 0) {
			//
			return Response.ok("Added successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@DELETE
	@Override
	@Path("{id}")
	public Response deleteRatingById(@PathParam("id") int id) {
		if (ratingDAO.deleteRatingById(id) != 0) {
			//
			return Response.ok("Deleted successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@PUT
	@Override
	public Response updateRatingById(Rating rating, @Context UriInfo uriInfo) {
		if (ratingDAO.updateRatingById(rating) != 0) {
			//
			return Response.ok("Updated successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@GET
	@Override
	@Path("{id}")
	public Response getRatingById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Rating rating = ratingDAO.getRatingById(id);
		
		if (rating != null) {
			//
			return Response.ok(rating).build();
		}
		return Response.serverError().build();
	}
}
