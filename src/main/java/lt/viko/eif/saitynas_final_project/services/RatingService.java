package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Rating;

public interface RatingService {
	Response addRating(Rating rating, @Context UriInfo uriInfo);
}
