package lt.viko.eif.saitynas_final_project.objects;

public class Rating {
	private int id;
	private double internetMovieDatabase;
	private double rottenTomatoes;
	private double metacritic;
	private double metascore;
	private double imdb;
	private int imdbVotes;
	private int movieId;
	
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
	
	public Rating() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getInternetMovieDatabase() {
		return internetMovieDatabase;
	}

	public void setInternetMovieDatabase(double internetMovieDatabase) {
		this.internetMovieDatabase = internetMovieDatabase;
	}

	public double getRottenTomatoes() {
		return rottenTomatoes;
	}

	public void setRottenTomatoes(double rottenTomatoes) {
		this.rottenTomatoes = rottenTomatoes;
	}

	public double getMetacritic() {
		return metacritic;
	}

	public void setMetacritic(double metacritic) {
		this.metacritic = metacritic;
	}

	public double getMetascore() {
		return metascore;
	}

	public void setMetascore(double metascore) {
		this.metascore = metascore;
	}

	public double getImdb() {
		return imdb;
	}

	public void setImdb(double imdb) {
		this.imdb = imdb;
	}

	public int getImdbVotes() {
		return imdbVotes;
	}

	public void setImdbVotes(int imdbVotes) {
		this.imdbVotes = imdbVotes;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}
