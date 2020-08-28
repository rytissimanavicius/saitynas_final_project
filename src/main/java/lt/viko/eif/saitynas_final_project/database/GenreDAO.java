package lt.viko.eif.saitynas_final_project.database;

import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Genre;
import lt.viko.eif.saitynas_final_project.objects.Movie;

/**
 * Interface that contains CRUD operations with genre object.
 * @author Erikas Bykovskis
 *
 */
public interface GenreDAO {
	
	/**
	 * Adds a new genre object to the database.
	 * @param genre
	 * @return
	 */
	public int addGenre(Genre genre);
	
	/**
	 * Deletes genre object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public int deleteGenreById(int id);
	
	/**
	 * Updates genre object with a new genre object in the database that matches the id.
	 * @param genre
	 * @return
	 */
	public int updateGenreById(Genre genre);
	
	/**
	 * Returns a genre object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public Genre getGenreById(int id);
	
	/**
	 * Returns genre objects from the database that have most matches with genre search object.
	 * @param genre
	 * @return
	 */
	public List<Movie> getMoviesByGenres(Genre genre);
}