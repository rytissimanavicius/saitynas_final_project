package lt.viko.eif.saitynas_final_project.objects;

public class MovieSearch {
	private int id;
	private String title;
	private int year;
	private String ratedAs;
	private int lengthMinutesMin;
	private int lengthMinutesMax;
	private String languages;
	private String country;
	private String type;
	private String producedBy;
	private int genreId;
	
	/**
	 * 
	 * @param id
	 * @param title
	 * @param year
	 * @param ratedAs
	 * @param lengthMinutesMin
	 * @param lengthMinutesMax
	 * @param languages
	 * @param country
	 * @param type
	 * @param producedBy
	 * @param genreId
	 */
	public MovieSearch(int id, String title, int year, String ratedAs, int lengthMinutesMin, int lengthMinutesMax,
			String languages, String country, String type, String producedBy, int genreId) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.ratedAs = ratedAs;
		this.lengthMinutesMin = lengthMinutesMin;
		this.lengthMinutesMax = lengthMinutesMax;
		this.languages = languages;
		this.country = country;
		this.type = type;
		this.producedBy = producedBy;
		this.genreId = genreId;
	}
	
	/**
	 * 
	 */
	public MovieSearch() {
		
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
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * 
	 * @return
	 */
	public String getRatedAs() {
		return ratedAs;
	}

	/**
	 * 
	 * @param ratedAs
	 */
	public void setRatedAs(String ratedAs) {
		this.ratedAs = ratedAs;
	}

	/**
	 * 
	 * @return
	 */
	public int getLengthMinutesMin() {
		return lengthMinutesMin;
	}

	/**
	 * 
	 * @param lengthMinutesMin
	 */
	public void setLengthMinutesMin(int lengthMinutesMin) {
		this.lengthMinutesMin = lengthMinutesMin;
	}

	/**
	 * 
	 * @return
	 */
	public int getLengthMinutesMax() {
		return lengthMinutesMax;
	}

	/**
	 * 
	 * @param lengthMinutesMax
	 */
	public void setLengthMinutesMax(int lengthMinutesMax) {
		this.lengthMinutesMax = lengthMinutesMax;
	}

	/**
	 * 
	 * @return
	 */
	public String getLanguages() {
		return languages;
	}

	/**
	 * 
	 * @param languages
	 */
	public void setLanguages(String languages) {
		this.languages = languages;
	}

	/**
	 * 
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return
	 */
	public String getProducedBy() {
		return producedBy;
	}

	/**
	 * 
	 * @param producedBy
	 */
	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}

	/**
	 * 
	 * @return
	 */
	public int getGenreId() {
		return genreId;
	}

	/**
	 * 
	 * @param genreId
	 */
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
}
