package lt.viko.eif.saitynas_final_project.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import lt.viko.eif.saitynas_final_project.database.StaffDAO;
import lt.viko.eif.saitynas_final_project.database.StaffDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Movie;

public class MovieFinderServiceImpl implements MovieFinderService{
	private StaffDAO staffDAO = new StaffDAOImpl();
	
	@GET
	@Override
	@Path("{name}")
	public Response findMovieByGenre(@PathParam("name") String name, @Context UriInfo uriInfo) {
		return Response.ok("TEMP").build();
		//int genreId = staffDAO.getStaffId(name);
		//List<Movie> movies = new ArrayList<Movie>();
		
		/*Staff staff = staffDAO.getStaffById(id);
		
		if (staff != null) {
			//
			return Response.ok(staff).build();
		}
		return Response.serverError().build();*/
	}
}
