package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;
import lt.viko.eif.saitynas_final_project.objects.Genre;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenreTest {
	private static Genre genre;

	@BeforeClass
	static public void setUp() {
        genre = new Genre();
	}

	@AfterClass
	static public void tearDown() {
        genre = null;
        }


	@Test
	public void testGetId() {
		 genre.setId(7);
	        assertEquals(7, genre.getId());
	}

	@Test
	public void testSetId() {
		 genre.setId(7);
	        assertEquals(7, genre.getId());
	}

	@Test
	public void testGetName() {
		genre.setName("TestName");
        assertEquals("TestName", genre.getName());
	}

	@Test
	public void testSetName() {
		genre.setName("TestName");
        assertEquals("TestName", genre.getName());
	}

	@Test
	public void testGetLinks() {
		genre.setLinks(null);
		assertEquals(null ,genre.getLinks());
	}

	@Test
	public void testSetLinks() {
		genre.setLinks(null);
		assertEquals(null, genre.getLinks());
	}

	@Test
	public void testAddLink() {
		genre.addLink("https://example.com",null);
		assertEquals("https://example.com" , null, genre.getLinks());
	}

}
