package lt.viko.eif.saitynas_final_project.services;

import java.net.URI;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.jcabi.aspects.Cacheable;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.database.MovieDAO;
import lt.viko.eif.saitynas_final_project.database.MovieDAOImpl;

/**
 * RESTful web service implementation which allows to perform CRUD operations with movie objects.
 * @author Rytis Simanavicius
 *
 */
@Path("movie")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieServiceImpl implements MovieService{
	private MovieDAO movieDAO = new MovieDAOImpl();
	
	@POST
	@Override
	public Response addMovie(Movie movie, @Context UriInfo uriInfo) {
		if (movieDAO.addMovie(movie) != 0) {
			movie.addLink(getUriForSelf(uriInfo, movie.getTitle()), "self");
			return Response.ok(movie).build();
		}
		return Response.serverError().build();
	}
	
	@DELETE
	@Override
	@Path("{id}")
	public Response deleteMovieById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		if (movieDAO.deleteMovieById(id) != 0) 
			return Response.ok("Deleted successfully!").build();
		
		return Response.serverError().build();
	}
	
	@PUT
	@Override
	public Response updateMovieById(Movie movie, @Context UriInfo uriInfo) {
		if (movieDAO.updateMovieById(movie) != 0) {
			movie.addLink(getUriForSelf(uriInfo, movie.getTitle()), "self");
			return Response.ok(movie).build();
		}
		return Response.serverError().build();
	}
	
	@GET
	@Cacheable(lifetime = 60, unit = TimeUnit.SECONDS)
	@Override
	@Path("{title}")
	public Response getMovieByTitle(@PathParam(value = "title") String title, @Context UriInfo uriInfo) {
		Movie movie = movieDAO.getMovieByTitle(title);
		
		if (movie != null) {
			movie.addLink(getUriForSelf(uriInfo, movie.getTitle()), "self");
			
			CacheControl cacheControl = new CacheControl();
	        cacheControl.setMaxAge(60);

	        return Response.ok(movie).cacheControl(cacheControl).build();
		}
		return Response.serverError().build();
	}
	
	/**
	 * Returns URI of an object.
	 * @param uriInfo
	 * @param title
	 * @return
	 */
	private String getUriForSelf(UriInfo uriInfo, String title) {
        URI uri = null;
        
        try {
            uri = uriInfo.getBaseUriBuilder().path(this.getClass()).path(this.getClass(), "getMovieByTitle")
                    .resolveTemplate("title", URLDecoder.decode(title, "UTF-8")).build();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return uri.toString();
    }
}
