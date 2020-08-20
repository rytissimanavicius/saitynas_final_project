package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.objects.Genre;

public interface GenreService {
	Response addGenre(Genre genre, @Context UriInfo uriInfo);
	
	@Path("{id}")
	Response deleteGenreById(@PathParam("id") int id);
	
	Response updateGenreById(Genre genre, @Context UriInfo uriInfo);
	
	@Path("{id}")
	Response getGenreById(@PathParam("id") int id, @Context UriInfo uriInfo);
}
