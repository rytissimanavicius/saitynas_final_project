package lt.viko.eif.saitynas_final_project.objects;

public class Movie {
	private int id;
	private String title;
	private int year;
	private String ratedAs;
	private int lengthMinutes;
	private String languages;
	private String country;
	private String type;
	private String producedBy;
	private int genreId;
	
	public Movie(int id, String title, int year, String ratedAs, int lengthMinutes, String languages, String country,
			String type, String producedBy, int genreId) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.ratedAs = ratedAs;
		this.lengthMinutes = lengthMinutes;
		this.languages = languages;
		this.country = country;
		this.type = type;
		this.producedBy = producedBy;
		this.genreId = genreId;
	}
	
	public Movie() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getRatedAs() {
		return ratedAs;
	}

	public void setRatedAs(String ratedAs) {
		this.ratedAs = ratedAs;
	}

	public int getLengthMinutes() {
		return lengthMinutes;
	}

	public void setLengthMinutes(int lengthMinutes) {
		this.lengthMinutes = lengthMinutes;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProducedBy() {
		return producedBy;
	}

	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
}
