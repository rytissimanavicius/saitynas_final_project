package lt.viko.eif.saitynas_final_project.objects;

/**
 * Class for objects representing movie ratings.
 * @author Rytis Simanavicius
 *
 */
public class Rating {
	private int id;
	private double internetMovieDatabase;
	private double rottenTomatoes;
	private double metacritic;
	private double metascore;
	private double imdb;
	private int imdbVotes;
	private int movieId;
	
	/**
	 * Main constructor, sets all attributes of an object.
	 * @param id
	 * @param internetMovieDatabase
	 * @param rottenTomatoes
	 * @param metacritic
	 * @param metascore
	 * @param imdb
	 * @param imdbVotes
	 * @param movieId
	 */
	public Rating(int id, double internetMovieDatabase, double rottenTomatoes, double metacritic, double metascore,
			double imdb, int imdbVotes, int movieId) {
		this.id = id;
		this.internetMovieDatabase = internetMovieDatabase;
		this.rottenTomatoes = rottenTomatoes;
		this.metacritic = metacritic;
		this.metascore = metascore;
		this.imdb = imdb;
		this.imdbVotes = imdbVotes;
		this.movieId = movieId;
	}
	
	/**
	 * Default constructor.
	 */
	public Rating() {
		
	}

	/**
	 * Returns rating id.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets rating id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns internet movie database given rating.
	 * @return
	 */
	public double getInternetMovieDatabase() {
		return internetMovieDatabase;
	}

	/**
	 * Sets internet movie database given rating.
	 * @param internetMovieDatabase
	 */
	public void setInternetMovieDatabase(double internetMovieDatabase) {
		this.internetMovieDatabase = internetMovieDatabase;
	}

	/**
	 * Returns rotten tomatoes given rating.
	 * @return
	 */
	public double getRottenTomatoes() {
		return rottenTomatoes;
	}

	/**
	 * Sets rotten tomatoes given rating.
	 * @param rottenTomatoes
	 */
	public void setRottenTomatoes(double rottenTomatoes) {
		this.rottenTomatoes = rottenTomatoes;
	}

	/**
	 * Returns metacritic given rating.
	 * @return
	 */
	public double getMetacritic() {
		return metacritic;
	}

	/**
	 * Sets metacritic given rating.
	 * @param metacritic
	 */
	public void setMetacritic(double metacritic) {
		this.metacritic = metacritic;
	}

	/**
	 * Returns metascore given rating.
	 * @return
	 */
	public double getMetascore() {
		return metascore;
	}

	/**
	 * Sets metascore given rating.
	 * @param metascore
	 */
	public void setMetascore(double metascore) {
		this.metascore = metascore;
	}

	/**
	 * Returns imdb given rating.
	 * @return
	 */
	public double getImdb() {
		return imdb;
	}

	/**
	 * Sets imdb given rating.
	 * @param imdb
	 */
	public void setImdb(double imdb) {
		this.imdb = imdb;
	}

	/**
	 * Returns imdb vote count.
	 * @return
	 */
	public int getImdbVotes() {
		return imdbVotes;
	}

	/**
	 * Sets imdb vote count.
	 * @param imdbVotes
	 */
	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	/**
	 * Returns rating movie id.
	 * @return
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * Sets rating movie id.
	 * @param movieId
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}
