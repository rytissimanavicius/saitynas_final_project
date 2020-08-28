package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Genre;
import lt.viko.eif.saitynas_final_project.objects.MovieSearch;
import lt.viko.eif.saitynas_final_project.objects.Nomination;
import lt.viko.eif.saitynas_final_project.objects.RatingSearch;
import lt.viko.eif.saitynas_final_project.objects.Staff;

/**
 * RESTful web service interface of methods that are used in finding movies.
 * @author Rytis Simanavicius
 *
 */
public interface MovieFinderService {
	/**
	 * Use staff attributes provided by the user to find the most suitable staff and retrieve their designated movies.
	 * @param staff
	 * @param uriInfo
	 * @return
	 */
	public Response getMoviesByStaff(Staff staff, @Context UriInfo uriInfo);
	
	/**
	 * Use nomination attributes provided by the user to find the most suitable nomination and retrieve their designated movies.
	 * @param staff
	 * @param uriInfo
	 * @return
	 */
	public Response getMoviesByNominations(Nomination nomination, @Context UriInfo uriInfo);
	
	/**
	 * Use genre attributes provided by the user to find the most suitable genre and retrieve their designated movies.
	 * @param staff
	 * @param uriInfo
	 * @return
	 */
	public Response getMoviesByGenres(Genre genre, @Context UriInfo uriInfo);
	
	/**
	 * Use movie attributes provided by the user to find the most suitable movies and retrieve them.
	 * @param movieSearch
	 * @param uriInfo
	 * @return
	 */
	public Response getMoviesByAttributes(MovieSearch movieSearch, @Context UriInfo uriInfo);
	
	/**
	 * Use rating attributes provided by the user to find the most suitable ratings and retrieve their designated movies.
	 * @param ratingSearch
	 * @param uriInfo
	 * @return
	 */
	public Response getMoviesByRatings(RatingSearch ratingSearch, @Context UriInfo uriInfo);
	
	/**
	 * Use title provided by the user to retrieve movies that match it.
	 * @param title
	 * @param uriInfo
	 * @return
	 */
	public Response getMovieByTitle(@PathParam(value = "title") String title, @Context UriInfo uriInfo);
}
