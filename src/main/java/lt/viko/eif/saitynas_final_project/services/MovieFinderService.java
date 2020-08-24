package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.MovieSearch;
import lt.viko.eif.saitynas_final_project.objects.Rating;
import lt.viko.eif.saitynas_final_project.objects.Staff;

public interface MovieFinderService {
	Response getMoviesByStaff(Staff staff, @Context UriInfo uriInfo);
	Response getMoviesByAttributes(MovieSearch movieSearch, @Context UriInfo uriInfo);
	Response getMoviesByRatings(Rating rating, @Context UriInfo uriInfo);
}
