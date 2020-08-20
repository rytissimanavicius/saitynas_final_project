package lt.viko.eif.saitynas_final_project.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

public interface MovieFinderService {
	@Path("{name}")
	Response findMovieByGenre(@PathParam("name") String name, @Context UriInfo uriInfo);
}
