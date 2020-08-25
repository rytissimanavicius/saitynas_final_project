package lt.viko.eif.saitynas_final_project.objects;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

/**
 * Class for objects representing movie nominations.
 * @author Rytis Simanavicius
 *
 */
public class Nomination {
	private int id;
	private String name;
	private String year;
	private Boolean won;
	private int movieId;
	private List<Link> links = new ArrayList<>();
	
	/**
	 * Main constructor, sets all attributes of an object.
	 * @param id
	 * @param name
	 * @param year
	 * @param won
	 * @param movieId
	 */
	public Nomination(int id, String name, String year, Boolean won, int movieId) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.won = won;
		this.movieId = movieId;
	}
	
	/**
	 * Default constructor.
	 */
	public Nomination() {
		
	}

	/**
	 * Returns nomination id.
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets nomination id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns nomination name.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets nomination name.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the year movie got nominated.
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Sets the year movie got nominated.
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * Returns true if movie won the nomination and false if didn't.
	 * @return
	 */
	public Boolean isWon() {
		return won;
	}

	/**
	 * Sets true if movie won the nomination and false if didn't
	 * @param won
	 */
	public void setWon(Boolean won) {
		this.won = won;
	}

	/**
	 * Returns nomination movie id.
	 * @return
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * Sets nomination movie id.
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
