package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.MovieSearch;
import lt.viko.eif.saitynas_final_project.objects.RatingSearch;
import lt.viko.eif.saitynas_final_project.objects.Staff;

public interface MovieFinderService {
	public Response getMoviesByStaff(Staff staff, @Context UriInfo uriInfo);
	public Response getMoviesByAttributes(MovieSearch movieSearch, @Context UriInfo uriInfo);
	public Response getMoviesByRatings(RatingSearch ratingSearch, @Context UriInfo uriInfo);
	public Response getMovieByTitle(@PathParam(value = "title") String title, @Context UriInfo uriInfo);
}
