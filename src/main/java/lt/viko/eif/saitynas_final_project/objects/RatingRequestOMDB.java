package lt.viko.eif.saitynas_final_project.objects;

/**
 * Class for objects used to retrieve ratings from OMDB API (uses name attribute) and update rating of a movie in the database (uses id attribute).
 * @author Rytis Simanavicius
 *
 */
public class RatingRequestOMDB {
	private String name;
	private int movieId;
	
	/**
	 * Main constructor, sets all attributes of an object.
	 * @param name
	 * @param movieId
	 */
	public RatingRequestOMDB(String name, int movieId) {
		this.name = name;
		this.movieId = movieId;
	}
	
	/**
	 * Default constructor.
	 */
	public RatingRequestOMDB() {
		
	}

	/**
	 * Returns the name of a movie which rating is being retrieved.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of a movie which rating is being retrieved.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns id of a movie which rating is being updated in the database.
	 * @return
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * Sets id of a movie which rating is being updated in the database.
	 * @param movieId
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}
