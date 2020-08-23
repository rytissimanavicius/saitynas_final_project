package lt.viko.eif.saitynas_final_project.objects;

public class MovieSearch {
	private int id;
	private String title;
	private int year;
	private String ratedAs;
	private int lengthMinutesMin;
	private int lengthMinutesMax;
	private String language;
	private String country;
	private String type;
	private String producedBy;
	private int genreId;
	
	public MovieSearch(int id, String title, int year, String ratedAs, int lengthMinutesMin, int lengthMinutesMax,
			String language, String country, String type, String producedBy, int genreId) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.ratedAs = ratedAs;
		this.lengthMinutesMin = lengthMinutesMin;
		this.lengthMinutesMax = lengthMinutesMax;
		this.language = language;
		this.country = country;
		this.type = type;
		this.producedBy = producedBy;
		this.genreId = genreId;
	}
	
	public MovieSearch() {
		
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

	public int getLengthMinutesMin() {
		return lengthMinutesMin;
	}

	public void setLengthMinutesMin(int lengthMinutesMin) {
		this.lengthMinutesMin = lengthMinutesMin;
	}

	public int getLengthMinutesMax() {
		return lengthMinutesMax;
	}

	public void setLengthMinutesMax(int lengthMinutesMax) {
		this.lengthMinutesMax = lengthMinutesMax;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
