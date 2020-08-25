package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Movie;

public interface MovieService {
	Response addMovie(Movie movie, @Context UriInfo uriInfo);
	
	@Path("{id}")
	Response deleteMovieById(@PathParam("id") int id, @Context UriInfo uriInfo);
	
	Response updateMovieById(Movie movie, @Context UriInfo uriInfo);
	
	@Path("{title}")
	Response getMovieByTitle(@PathParam("title") String title, @Context UriInfo uriInfo);
}
