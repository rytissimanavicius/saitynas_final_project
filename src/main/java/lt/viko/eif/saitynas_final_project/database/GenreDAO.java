package lt.viko.eif.saitynas_final_project.database;

import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Genre;
import lt.viko.eif.saitynas_final_project.objects.Movie;

public interface GenreDAO {
	public int addGenre(Genre genre);
	public int deleteGenreById(int id);
	public int updateGenreById(Genre genre);
	public Genre getGenreById(int id);
	public List<Movie> getMoviesByGenres(Genre genre);
}