package lt.viko.eif.saitynas_final_project.database;

import lt.viko.eif.saitynas_final_project.objects.Movie;

public interface MovieDAO {
	public int addMovie(Movie movie);
	public int deleteMovieById(int id);
	public int updateMovieById(Movie movie);
	public Movie getMovieById(int id);
}
