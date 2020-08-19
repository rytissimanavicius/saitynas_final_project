package lt.viko.eif.saitynas_final_project.objects;

public class Nomination {
	private int id;
	private String name;
	private String year;
	private boolean won;
	private int movieId;
	
	public Nomination(int id, String name, String year, boolean won, int movieId) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.won = won;
		this.movieId = movieId;
	}
	
	public Nomination() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
}
