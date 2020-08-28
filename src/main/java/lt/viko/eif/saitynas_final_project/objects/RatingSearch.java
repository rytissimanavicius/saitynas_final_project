package lt.viko.eif.saitynas_final_project.objects;

/**
 * Class for objects optimized for rating search.
 * @author Rytis Simanavicius
 *
 */
public class RatingSearch {
	private int id;
	private double internetMovieDatabaseMin;
	private double internetMovieDatabaseMax;
	private double rottenTomatoesMin;
	private double rottenTomatoesMax;
	private double metacriticMin;
	private double metacriticMax;
	private double metascoreMin;
	private double metascoreMax;
	private double imdbMin;
	private double imdbMax;
	private int imdbVotesMin;
	private int imdbVotesMax;
	private int movieId;
	
	/**
	 * Main constructor, sets all attributes of an object.
	 * @param id
	 * @param internetMovieDatabaseMin
	 * @param internetMovieDatabaseMax
	 * @param rottenTomatoesMin
	 * @param rottenTomatoesMax
	 * @param metacriticMin
	 * @param metacriticMax
	 * @param metascoreMin
	 * @param metascoreMax
	 * @param imdbMin
	 * @param imdbMax
	 * @param imdbVotesMin
	 * @param imdbVotesMax
	 * @param movieId
	 */
	public RatingSearch(int id, double internetMovieDatabaseMin, double internetMovieDatabaseMax,
			double rottenTomatoesMin, double rottenTomatoesMax, double metacriticMin, double metacriticMax,
			double metascoreMin, double metascoreMax, double imdbMin, double imdbMax, int imdbVotesMin,
			int imdbVotesMax, int movieId) {
		this.id = id;
		this.internetMovieDatabaseMin = internetMovieDatabaseMin;
		this.internetMovieDatabaseMax = internetMovieDatabaseMax;
		this.rottenTomatoesMin = rottenTomatoesMin;
		this.rottenTomatoesMax = rottenTomatoesMax;
		this.metacriticMin = metacriticMin;
		this.metacriticMax = metacriticMax;
		this.metascoreMin = metascoreMin;
		this.metascoreMax = metascoreMax;
		this.imdbMin = imdbMin;
		this.imdbMax = imdbMax;
		this.imdbVotesMin = imdbVotesMin;
		this.imdbVotesMax = imdbVotesMax;
		this.movieId = movieId;
	}
	
	/**
	 * Default constructor.
	 */
	public RatingSearch() {
		
	}

	/**
	 * Returns searched rating id.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets searched rating id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns searched internet movie database minimum rating.
	 * @return
	 */
	public double getInternetMovieDatabaseMin() {
		return internetMovieDatabaseMin;
	}

	/**
	 * Sets searched internet movie database minimum rating.
	 * @param internetMovieDatabaseMin
	 */
	public void setInternetMovieDatabaseMin(double internetMovieDatabaseMin) {
		this.internetMovieDatabaseMin = internetMovieDatabaseMin;
	}

	/**
	 * Returns searched internet movie database maximum rating.
	 * @return
	 */
	public double getInternetMovieDatabaseMax() {
		return internetMovieDatabaseMax;
	}

	/**
	 * Sets searched internet movie database maximum rating.
	 * @param internetMovieDatabaseMax
	 */
	public void setInternetMovieDatabaseMax(double internetMovieDatabaseMax) {
		this.internetMovieDatabaseMax = internetMovieDatabaseMax;
	}

	/**
	 * Returns searched rotten tomatoes minimum rating.
	 * @return
	 */
	public double getRottenTomatoesMin() {
		return rottenTomatoesMin;
	}

	/**
	 * Sets searched rotten tomatoes minimum rating.
	 * @param rottenTomatoesMin
	 */
	public void setRottenTomatoesMin(double rottenTomatoesMin) {
		this.rottenTomatoesMin = rottenTomatoesMin;
	}

	/**
	 * Returns searched rotten tomatoes maximum rating.
	 * @return
	 */
	public double getRottenTomatoesMax() {
		return rottenTomatoesMax;
	}

	/**
	 * Sets searched rotten tomatoes maximum rating.
	 * @param rottenTomatoesMax
	 */
	public void setRottenTomatoesMax(double rottenTomatoesMax) {
		this.rottenTomatoesMax = rottenTomatoesMax;
	}

	/**
	 * Returns searched metacritic minimum rating.
	 * @return
	 */
	public double getMetacriticMin() {
		return metacriticMin;
	}

	/**
	 * Sets searched metacritic minimum rating.
	 * @param metacriticMin
	 */
	public void setMetacriticMin(double metacriticMin) {
		this.metacriticMin = metacriticMin;
	}

	/**
	 * Returns searched metacritic maximum rating.
	 * @return
	 */
	public double getMetacriticMax() {
		return metacriticMax;
	}

	/**
	 * Sets searched metacritic maximum rating.
	 * @param metacriticMax
	 */
	public void setMetacriticMax(double metacriticMax) {
		this.metacriticMax = metacriticMax;
	}

	/**
	 * Returns searched metascore minimum rating.
	 * @return
	 */
	public double getMetascoreMin() {
		return metascoreMin;
	}

	/**
	 * Sets searched metascore minimum rating.
	 * @param metascoreMin
	 */
	public void setMetascoreMin(double metascoreMin) {
		this.metascoreMin = metascoreMin;
	}

	/**
	 * Returns searched metascore maximum rating.
	 * @return
	 */
	public double getMetascoreMax() {
		return metascoreMax;
	}

	/**
	 * Sets searched metascore maximum rating.
	 * @param metascoreMax
	 */
	public void setMetascoreMax(double metascoreMax) {
		this.metascoreMax = metascoreMax;
	}

	/**
	 * Returns searched imdb minimum rating.
	 * @return
	 */
	public double getImdbMin() {
		return imdbMin;
	}

	/**
	 * Sets searched imdb minimum rating.
	 * @param imdbMin
	 */
	public void setImdbMin(double imdbMin) {
		this.imdbMin = imdbMin;
	}

	/**
	 * Returns searched imdb maximum rating.
	 * @return
	 */
	public double getImdbMax() {
		return imdbMax;
	}

	/**
	 * Sets searched imdb maximum rating.
	 * @param imdbMax
	 */
	public void setImdbMax(double imdbMax) {
		this.imdbMax = imdbMax;
	}

	/**
	 * Returns searched imdb votes minimum value.
	 * @return
	 */
	public int getImdbVotesMin() {
		return imdbVotesMin;
	}

	/**
	 * Sets searched imdb votes minimum value.
	 * @param imdbVotesMin
	 */
	public void setImdbVotesMin(int imdbVotesMin) {
		this.imdbVotesMin = imdbVotesMin;
	}

	/**
	 * Returns searched imdb votes maximum value
	 * @return
	 */
	public int getImdbVotesMax() {
		return imdbVotesMax;
	}

	/**
	 * Sets searched imdb votes maximum value
	 * @param imdbVotesMax
	 */
	public void setImdbVotesMax(int imdbVotesMax) {
		this.imdbVotesMax = imdbVotesMax;
	}

	/**
	 * Returns movie id who these ratings belong to.
	 * @return
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * Sets movie id who these ratings belong to.
	 * @param movieId
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}
