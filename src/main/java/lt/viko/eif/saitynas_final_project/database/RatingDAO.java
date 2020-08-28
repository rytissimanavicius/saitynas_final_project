package lt.viko.eif.saitynas_final_project.database;

import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.Rating;
import lt.viko.eif.saitynas_final_project.objects.RatingSearch;

/**
 * Interface that contains CRUD operations with rating object.
 * @author Rytis Simanavicius
 *
 */
public interface RatingDAO {
	/**
	 * Adds a new rating object to the database.
	 * @param rating
	 * @return
	 */
	public int addRating(Rating rating);
	
	/**
	 * Deletes rating object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public int deleteRatingById(int id);
	
	/**
	 * Updates rating object with a new rating object in the database that matches the id.
	 * @param rating
	 * @return
	 */
	public int updateRatingById(Rating rating);
	
	/**
	 * Returns a rating object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public Rating getRatingById(int id);
	
	/**
	 * Returns rating objects from the database that have most matches with rating search object.
	 * @param ratingSearch
	 * @return
	 */
	public List<Movie> getMoviesByRatings(RatingSearch ratingSearch);
}
