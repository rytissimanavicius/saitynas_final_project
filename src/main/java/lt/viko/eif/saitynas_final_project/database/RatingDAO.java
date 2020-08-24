package lt.viko.eif.saitynas_final_project.database;

import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.Rating;

public interface RatingDAO {
	public int addRating(Rating rating);
	public int deleteRatingById(int id);
	public int updateRatingById(Rating rating);
	public Rating getRatingById(int id);
	public List<Movie> getMoviesByRatings(Rating rating);
}
