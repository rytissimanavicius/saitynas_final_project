package lt.viko.eif.saitynas_final_project.objects;

/**
 * Class for objects representing movie genres.
 * @author Rytis Simanavicius
 *
 */
public class Genre {
	private int id;
	private String name;
	
	/**
	 * Main constructor, sets all attributes of an object.
	 * @param id
	 * @param name
	 */
	public Genre(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * Default constructor.
	 */
	public Genre() {
		
	}

	/**
	 * Returns genre id.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets genre id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns genre name.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets genre name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
