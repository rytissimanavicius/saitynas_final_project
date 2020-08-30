package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;
import lt.viko.eif.saitynas_final_project.objects.Movie;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MovieTest {
	private static Movie movie;
	@BeforeClass
	public static void setUp() {
        movie = new Movie();
	}
	
	@AfterClass
	public static void tearDown() {
        movie = null;
        }


	@Test
	public void testMovie() {
		 movie.setType("Test MOVIE");
	        assertEquals("Test MOVIE", movie.getType());
	}

	@Test
	public void testGetId() {
		 movie.setId(7);
	        assertEquals(7, movie.getId());
	}

	@Test
	public void testSetId() {
		 movie.setId(7);
	        assertEquals(7, movie.getId());
	}

	@Test
	public void testGetTitle() {
		 movie.setTitle("lalala");
	        assertEquals("lalala", movie.getTitle());
	}

	@Test
	public void testSetTitle() {
		movie.setTitle("lalala");
        assertEquals("lalala", movie.getTitle());
	}

	@Test
	public void testGetYear() {
		movie.setYear(1999);
        assertEquals(1999, movie.getYear());
	}

	@Test
	public void testSetYear() {
		movie.setYear(1999);
        assertEquals(1999, movie.getYear());
	}

	@Test
	public void testGetRatedAs() {
		movie.setRatedAs("Top");
        assertEquals("Top", movie.getRatedAs());
	}

	@Test
	public void testSetRatedAs() {
		movie.setRatedAs("Top");
        assertEquals("Top", movie.getRatedAs());
	}

	@Test
	public void testGetLengthMinutes() {
		movie.getLengthMinutes();
        assertEquals(90, movie.getLengthMinutes());
	}

	@Test
	public void testSetLengthMinutes() {
		movie.setLengthMinutes(90);
        assertEquals(90, movie.getLengthMinutes());
	}

	@Test
	public void testGetLanguages() {
		movie.setLanguages("LT");
        assertEquals("LT", movie.getLanguages());
	}

	@Test
	public void testSetLanguages() {
		movie.setLanguages("LT");
        assertEquals("LT", movie.getLanguages());
	}

	@Test
	public void testGetCountry() {
		movie.setCountry("LTU");
        assertEquals("LTU", movie.getCountry());
	}

	@Test
	public void testSetCountry() {
		movie.setCountry("LTU");
        assertEquals("LTU", movie.getCountry());
	}

	@Test
	public void testGetType() {
		movie.setType("comed");
        assertEquals("comed", movie.getType());
	}

	@Test
	public void testSetType() {
		movie.setType("comed");
        assertEquals("comed", movie.getType());
	}

	@Test
	public void testGetProducedBy() {
		movie.setProducedBy("Tomas");
        assertEquals("Tomas", movie.getProducedBy());
	}

	@Test
	public void testSetProducedBy() {
		movie.setProducedBy("Tomas");
        assertEquals("Tomas", movie.getProducedBy());
	}

	@Test
	public void testGetGenreId() {
		movie.setGenreId(2);
        assertEquals(2, movie.getGenreId());
	}

	@Test
	public void testSetGenreId() {
		movie.setGenreId(2);
        assertEquals(2, movie.getGenreId());
	}

	@Test
	public void testGetLinks() {
		movie.setLinks(null);
		assertEquals(null ,movie.getLinks());
		
	}

	@Test
	public void testSetLinks() {
		movie.setLinks(null);
		assertEquals(null, movie.getLinks());
	}

	@Test
	public void testAddLink() {
		movie.addLink("https://example.com","https://example.com");
		assertEquals("\"https://example.com\"", movie.getLinks());
	}

}
