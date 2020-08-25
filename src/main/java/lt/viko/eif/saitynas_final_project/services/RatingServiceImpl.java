package lt.viko.eif.saitynas_final_project.services;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.jcabi.aspects.Cacheable;

import javax.ws.rs.core.MediaType;

import lt.viko.eif.saitynas_final_project.database.RatingDAO;
import lt.viko.eif.saitynas_final_project.database.RatingDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Rating;
import lt.viko.eif.saitynas_final_project.objects.RatingRequestOMDB;

@Path("rating")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RatingServiceImpl implements RatingService{
	private RatingDAO ratingDAO = new RatingDAOImpl();
	
	@POST
	@Override
	public Response addRating(RatingRequestOMDB requestTemplate, @Context UriInfo uriInfo) {
		Rating rating = createRating(requestTemplate);
		
		if (ratingDAO.addRating(rating) != 0) {
			rating.addLink(getUriForSelf(uriInfo, rating.getId()), "self");
			return Response.ok(rating).build();
		}
		return Response.serverError().build();
	}
	
	@DELETE
	@Override
	@Path("{id}")
	public Response deleteRatingById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		if (ratingDAO.deleteRatingById(id) != 0)
			return Response.ok("Deleted successfully!").build();
		
		return Response.serverError().build();
	}
	
	@PUT
	@Override
	public Response updateRatingByName(RatingRequestOMDB requestTemplate, @Context UriInfo uriInfo) {
		Rating rating = createRating(requestTemplate);
		rating.setId(requestTemplate.getId());
		
		if (ratingDAO.updateRatingById(rating) != 0) {
			rating.addLink(getUriForSelf(uriInfo, rating.getId()), "self");
			return Response.ok(rating).build();
		}
		return Response.serverError().build();
	}
	
	@GET
	@Cacheable(lifetime = 60, unit = TimeUnit.SECONDS)
	@Override
	@Path("{id}")
	public Response getRatingById(@PathParam("id") int id, @Context UriInfo uriInfo) {
		Rating rating = ratingDAO.getRatingById(id);
		
		if (rating != null) {
			rating.addLink(getUriForSelf(uriInfo, rating.getId()), "self");
			
			CacheControl cacheControl = new CacheControl();
	        cacheControl.setMaxAge(60);

	        return Response.ok(rating).cacheControl(cacheControl).build();
		}
		return Response.serverError().build();
	}
	
	public Rating createRating(RatingRequestOMDB requestTemplate) {
		Rating rating = new Rating();
		requestTemplate.setName(requestTemplate.getName().replace(' ', '+'));
		
		try {
	        URL omdb = new URL("http://www.omdbapi.com/?t=" + requestTemplate.getName() + "&apikey=d9f2b01e");
	        InputStream inputStream = omdb.openStream();
	        
	        JSONObject obj = new JSONObject(new JSONTokener(inputStream));
	        
	        rating.setImdb(Double.parseDouble(obj.getString("imdbRating")));
	        String imdbVotesModified = (obj.getString("imdbVotes")).replace(",", "");
	        rating.setImdbVotes(Integer.parseInt(imdbVotesModified));
	        
	        JSONArray ratings = obj.getJSONArray("Ratings");
	        for (int i = 0; i < ratings.length(); i++)
            {
                JSONObject tempObj = ratings.getJSONObject(i);
                String temp = null;
                
                if (tempObj.optString("Source").equals("Internet Movie Database")) {
                	temp = (tempObj.optString("Value")).replace("/10", "");
                	rating.setInternetMovieDatabase(Double.parseDouble(temp));
                }
                else if (tempObj.optString("Source").equals("Rotten Tomatoes")) {
                	temp = (tempObj.optString("Value")).replace("%", "");
                	rating.setRottenTomatoes(Double.parseDouble(temp));
                }
                else if (tempObj.optString("Source").equals("Metacritic")) {
                	temp = (tempObj.optString("Value")).replace("/100", "");
                	rating.setMetacritic(Double.parseDouble(temp));
                }
                else if (tempObj.optString("Source").equals("Metascore")) {
                	temp = (tempObj.optString("Value")).replace("/100", "");
                	rating.setMetascore(Double.parseDouble(temp));
                }
            }
	        
	        rating.setMovieId(requestTemplate.getMovieId());
	        
	    } catch (Exception exc){
	        System.out.println(exc);
	    }
		
		return rating;
	}
	
	private String getUriForSelf(UriInfo uriInfo, int id) {
        URI uri = null;
        String idString = String.valueOf(id);
        
        try {
            uri = uriInfo.getBaseUriBuilder().path(this.getClass()).path(this.getClass(), "getRatingById")
                    .resolveTemplate("id", URLDecoder.decode(idString, "UTF-8")).build();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return uri.toString();
    }
}
