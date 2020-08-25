package lt.viko.eif.saitynas_final_project.services;

import java.net.URI;
import java.net.URLDecoder;

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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.database.GenreDAO;
import lt.viko.eif.saitynas_final_project.database.GenreDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Genre;

import javax.ws.rs.core.MediaType;

@Path("genre")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GenreServiceImpl implements GenreService{
	private GenreDAO genreDAO = new GenreDAOImpl();
	
	@POST
	@Override
	public Response addGenre(Genre genre, @Context UriInfo uriInfo) {
		if (genreDAO.addGenre(genre) != 0) {
			genre.addLink(getUriForSelf(uriInfo, genre.getId()), "self");
			return Response.ok("Added successfully!").build();
		}
		return Response.serverError().build();
	}
	@DELETE
	@Override
	@Path("{id}")
	public Response deleteGenreById(@PathParam("id") int id) {
		if (genreDAO.deleteGenreById(id) != 0) {
			//
			return Response.ok("Deleted successfully!").build();
		}
		return Response.serverError().build();
	}
	
	@PUT
	@Override
	public Response updateGenreById(Genre genre, @Context UriInfo uriInfo) {
		if (genreDAO.updateGenreById(genre) != 0) {
			genre.addLink(getUriForSelf(uriInfo, genre.getId()), "self");
			return Response.ok("Updated successfully!").build();
		}
		return Response.serverError().build();
	}

	@GET
	@Override
	@Path("{id}")
	public Response getGenreById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Genre genre = genreDAO.getGenreById(id);
		
		if (genre != null) {
			genre.addLink(getUriForSelf(uriInfo, genre.getId()), "self");
			
			CacheControl cacheControl = new CacheControl();
			cacheControl.setMaxAge(60);
			return Response.ok(genre).build();
		}
		return Response.serverError().build();
	}
	
	private String getUriForSelf(UriInfo uriInfo, int id) {
        URI uri = null;
        String idString = String.valueOf(id);
        
        try {
            uri = uriInfo.getBaseUriBuilder().path(this.getClass()).path(this.getClass(), "getGenreById")
                    .resolveTemplate("id", URLDecoder.decode(idString, "UTF-8")).build();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return uri.toString();
    }
}
