package lt.viko.eif.saitynas_final_project.objects;

/**
 * Class for objects used to retrieve ratings from OMDB API (uses name attribute) and update rating of a movie in the database (uses id attribute).
 * @author Rytis Simanavicius
 *
 */
public class RatingRequestOMDB {
	private int id;
	private String name;
	private int movieId;
	
	/**
	 * Main constructor, sets all attributes of an object.
	 * @param id
	 * @param name
	 * @param movieId
	 */
	public RatingRequestOMDB(int id, String name, int movieId) {
		this.id = id;
		this.name = name;
		this.movieId = movieId;
	}
	
	/**
	 * Default constructor.
	 */
	public RatingRequestOMDB() {
		
	}
	
	/**
	 * Returns id of a rating.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets id of a rating.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
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
