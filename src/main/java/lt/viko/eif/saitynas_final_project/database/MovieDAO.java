package lt.viko.eif.saitynas_final_project.database;

import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.MovieSearch;

public interface MovieDAO {
	public int addMovie(Movie movie);
	public int deleteMovieById(int id);
	public int updateMovieById(Movie movie);
	public Movie getMovieById(int id);
	public List<Movie> getMoviesByAttributes(MovieSearch movieSearch);
}
