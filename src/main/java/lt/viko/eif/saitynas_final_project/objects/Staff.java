package lt.viko.eif.saitynas_final_project.objects;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

/**
 * Class for objects representing staff members.
 * @author Rytis Simanavicius
 *
 */
public class Staff {
	private int id;
	private String name;
	private String surname;
	private String role;
	private String origin;
	private int movieId;
	private List<Link> links = new ArrayList<>();
	
	/**
	 * Main constructor, sets all attributes of an object.
	 * @param id
	 * @param name
	 * @param surname
	 * @param role
	 * @param origin
	 * @param movieId
	 */
	public Staff(int id, String name, String surname, String role, String origin, int movieId) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.origin = origin;
		this.movieId = movieId;
	}
	
	/**
	 * Default constructor.
	 */
	public Staff() {
		
	}

	/**
	 * Returns staff member id.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets staff member id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns staff member name.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets staff member name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns staff member surname.
	 * @return
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets staff member surname.
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Returns staff member role.
	 * @return
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets staff member role.
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Returns staff member origin.
	 * @return
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets staff member origin.
	 * @param origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * Returns staff member movie id.
	 * @return
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * Sets staff member movie id.
	 * @param movieId
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	/**
	 * Returns a list of links.
	 * @return
	 */
	public List<Link> getLinks() {
		return links;
	}

	/**
	 * Set list as a new list of links.
	 * @param links
	 */
	public void setLinks(List<Link> links) {
		this.links = links;
	}

	/**
	 * Add new link to a list of links.
	 * @param url
	 * @param rel
	 */
	public void addLink(String url, String rel) {
		Link link = Link.fromUri(url).rel(rel).build();
        this.links.add(link);
	}
}
