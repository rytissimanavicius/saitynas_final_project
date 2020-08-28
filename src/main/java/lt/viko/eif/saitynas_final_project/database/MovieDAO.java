package lt.viko.eif.saitynas_final_project.database;

import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.MovieSearch;

/**
 * Interface that contains CRUD operations with movie object.
 * @author Rytis Simanavicius
 *
 */
public interface MovieDAO {
	/**
	 * Adds a new movie object to the database.
	 * @param movie
	 * @return
	 */
	public int addMovie(Movie movie);
	
	/**
	 * Deletes movie object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public int deleteMovieById(int id);
	
	/**
	 * Updates movie object with a new movie object in the database that matches the id.
	 * @param movie
	 * @return
	 */
	public int updateMovieById(Movie movie);
	
	/**
	 * Returns a movie object from the database that matches the title.
	 * @param title
	 * @return
	 */
	public Movie getMovieByTitle(String title);
	
	/**
	 * Returns movie objects from the database that have most matches with movie search object.
	 * @param movieSearch
	 * @return
	 */
	public List<Movie> getMoviesByAttributes(MovieSearch movieSearch);
	
	/**
	 * Returns movie object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public Movie getMovieById(int id);
	
	
}
