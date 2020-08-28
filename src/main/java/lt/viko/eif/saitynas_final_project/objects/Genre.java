package lt.viko.eif.saitynas_final_project.objects;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

/**
 * Class for objects representing movie genres.
 * @author Erikas Bykovskis
 *
 */
public class Genre {
	private int id;
	private String name;
	private List<Link> links = new ArrayList<>();
	
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
	
	/**
	 * Returns a list of links
	 * @return
	 */
	public List<Link> getLinks()
	{
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
