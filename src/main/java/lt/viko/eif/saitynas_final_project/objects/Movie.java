package lt.viko.eif.saitynas_final_project.objects;

/**
 * Class for objects representing movies.
 * @author Rytis Simanavicius
 *
 */
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
	
	/**
	 * Main constructor, sets all attributes of an object.
	 * @param id
	 * @param title
	 * @param year
	 * @param ratedAs
	 * @param lengthMinutes
	 * @param languages
	 * @param country
	 * @param type
	 * @param producedBy
	 * @param genreId
	 */
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
	
	/**
	 * Default constructor.
	 */
	public Movie() {
		
	}

	/**
	 * Returns movie id.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets movie id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns movie title.
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets movie title.
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns year movie was created.
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets year movie was created.
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Returns movie audience suitability rating.
	 * @return
	 */
	public String getRatedAs() {
		return ratedAs;
	}

	/**
	 * Sets movie audience suitability rating.
	 * @param ratedAs
	 */
	public void setRatedAs(String ratedAs) {
		this.ratedAs = ratedAs;
	}

	/**
	 * Returns movie length.
	 * @return
	 */
	public int getLengthMinutes() {
		return lengthMinutes;
	}

	/**
	 * Sets move length.
	 * @param lengthMinutes
	 */
	public void setLengthMinutes(int lengthMinutes) {
		this.lengthMinutes = lengthMinutes;
	}

	/**
	 * Returns movie languages.
	 * @return
	 */
	public String getLanguages() {
		return languages;
	}

	/**
	 * Sets movie languages.
	 * @param languages
	 */
	public void setLanguages(String languages) {
		this.languages = languages;
	}

	/**
	 * Returns the country movie was made in.
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country movie was made in.
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Returns movie type.
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets movie type.
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the name of a company that made the movie.
	 * @return
	 */
	public String getProducedBy() {
		return producedBy;
	}

	/**
	 * Sets the name of a company that made the movie.
	 * @param producedBy
	 */
	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}

	/**
	 * Returns movie genre id.
	 * @return
	 */
	public int getGenreId() {
		return genreId;
	}

	/**
	 * Sets movie genre id.
	 * @param genreId
	 */
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
}
