package lt.viko.eif.saitynas_final_project.objects;

/**
 * 
 * @author rytuc
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
	 * 
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
	 * 
	 */
	public RatingSearch() {
		
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public double getInternetMovieDatabaseMin() {
		return internetMovieDatabaseMin;
	}

	/**
	 * 
	 * @param internetMovieDatabaseMin
	 */
	public void setInternetMovieDatabaseMin(double internetMovieDatabaseMin) {
		this.internetMovieDatabaseMin = internetMovieDatabaseMin;
	}

	/**
	 * 
	 * @return
	 */
	public double getInternetMovieDatabaseMax() {
		return internetMovieDatabaseMax;
	}

	/**
	 * 
	 * @param internetMovieDatabaseMax
	 */
	public void setInternetMovieDatabaseMax(double internetMovieDatabaseMax) {
		this.internetMovieDatabaseMax = internetMovieDatabaseMax;
	}

	/**
	 * 
	 * @return
	 */
	public double getRottenTomatoesMin() {
		return rottenTomatoesMin;
	}

	/**
	 * 
	 * @param rottenTomatoesMin
	 */
	public void setRottenTomatoesMin(double rottenTomatoesMin) {
		this.rottenTomatoesMin = rottenTomatoesMin;
	}

	/**
	 * 
	 * @return
	 */
	public double getRottenTomatoesMax() {
		return rottenTomatoesMax;
	}

	/**
	 * 
	 * @param rottenTomatoesMax
	 */
	public void setRottenTomatoesMax(double rottenTomatoesMax) {
		this.rottenTomatoesMax = rottenTomatoesMax;
	}

	/**
	 * 
	 * @return
	 */
	public double getMetacriticMin() {
		return metacriticMin;
	}

	/**
	 * 
	 * @param metacriticMin
	 */
	public void setMetacriticMin(double metacriticMin) {
		this.metacriticMin = metacriticMin;
	}

	/**
	 * 
	 * @return
	 */
	public double getMetacriticMax() {
		return metacriticMax;
	}

	/**
	 * 
	 * @param metacriticMax
	 */
	public void setMetacriticMax(double metacriticMax) {
		this.metacriticMax = metacriticMax;
	}

	/**
	 * 
	 * @return
	 */
	public double getMetascoreMin() {
		return metascoreMin;
	}

	/**
	 * 
	 * @param metascoreMin
	 */
	public void setMetascoreMin(double metascoreMin) {
		this.metascoreMin = metascoreMin;
	}

	/**
	 * 
	 * @return
	 */
	public double getMetascoreMax() {
		return metascoreMax;
	}

	/**
	 * 
	 * @param metascoreMax
	 */
	public void setMetascoreMax(double metascoreMax) {
		this.metascoreMax = metascoreMax;
	}

	/**
	 * 
	 * @return
	 */
	public double getImdbMin() {
		return imdbMin;
	}

	/**
	 * 
	 * @param imdbMin
	 */
	public void setImdbMin(double imdbMin) {
		this.imdbMin = imdbMin;
	}

	/**
	 * 
	 * @return
	 */
	public double getImdbMax() {
		return imdbMax;
	}

	/**
	 * 
	 * @param imdbMax
	 */
	public void setImdbMax(double imdbMax) {
		this.imdbMax = imdbMax;
	}

	/**
	 * 
	 * @return
	 */
	public int getImdbVotesMin() {
		return imdbVotesMin;
	}

	/**
	 * 
	 * @param imdbVotesMin
	 */
	public void setImdbVotesMin(int imdbVotesMin) {
		this.imdbVotesMin = imdbVotesMin;
	}

	/**
	 * 
	 * @return
	 */
	public int getImdbVotesMax() {
		return imdbVotesMax;
	}

	/**
	 * 
	 * @param imdbVotesMax
	 */
	public void setImdbVotesMax(int imdbVotesMax) {
		this.imdbVotesMax = imdbVotesMax;
	}

	/**
	 * 
	 * @return
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * 
	 * @param movieId
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}
