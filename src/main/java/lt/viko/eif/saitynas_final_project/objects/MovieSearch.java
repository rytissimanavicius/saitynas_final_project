package lt.viko.eif.saitynas_final_project.objects;

/**
 * Class for objects optimized for movie search.
 * @author Rytis Simanavicius
 *
 */
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
	
	/**
	 * Main constructor, sets all attributes of an object.
	 * @param id
	 * @param title
	 * @param year
	 * @param ratedAs
	 * @param lengthMinutesMin
	 * @param lengthMinutesMax
	 * @param language
	 * @param country
	 * @param type
	 * @param producedBy
	 * @param genreId
	 */
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
	
	/**
	 * Default constructor.
	 */
	public MovieSearch() {
		
	}

	/**
	 * Returns searched movie id.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets searched movie id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns searched movie title.
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets searched movie title.
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns year searched movie was created.
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets year searched movie was created.
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Returns searched movie audience suitability rating.
	 * @return
	 */
	public String getRatedAs() {
		return ratedAs;
	}

	/**
	 * Sets searched movie audience suitability rating.
	 * @param ratedAs
	 */
	public void setRatedAs(String ratedAs) {
		this.ratedAs = ratedAs;
	}

	/**
	 * Returns movie minimum length set for search.
	 * @return
	 */
	public int getLengthMinutesMin() {
		return lengthMinutesMin;
	}

	/**
	 * Sets movie minimum length set for search.
	 * @param lengthMinutesMin
	 */
	public void setLengthMinutesMin(int lengthMinutesMin) {
		this.lengthMinutesMin = lengthMinutesMin;
	}

	/**
	 * Returns movie maximum length set for search.
	 * @return
	 */
	public int getLengthMinutesMax() {
		return lengthMinutesMax;
	}

	/**
	 * Sets movie minimum length set for search.
	 * @param lengthMinutesMax
	 */
	public void setLengthMinutesMax(int lengthMinutesMax) {
		this.lengthMinutesMax = lengthMinutesMax;
	}

	/**
	 * Returns searched movie language.
	 * @return
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets searched movie language.
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Returns searched movie country.
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets searched movie country.
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Returns searched movie type.
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets searched movie type.
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Returns the name of a company that made the searched movie.
	 * @return
	 */
	public String getProducedBy() {
		return producedBy;
	}

	/**
	 * Sets the name of a company that made the searched movie.
	 * @param producedBy
	 */
	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}

	/**
	 * Returns searched movie genre id.
	 * @return
	 */
	public int getGenreId() {
		return genreId;
	}

	/**
	 * Sets searched movie genre id.
	 * @param genreId
	 */
	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}
}
