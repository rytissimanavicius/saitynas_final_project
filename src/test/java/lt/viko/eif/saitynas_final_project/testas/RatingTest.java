package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;
import lt.viko.eif.saitynas_final_project.objects.Rating;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RatingTest {
	private static Rating rating;
	@BeforeClass
	public static void setUp() {
       rating = new Rating();
	}

	@AfterClass
	public static void tearDown() {
        rating = null;
        }

	@Test
	public void testGetId() {
		rating.setId(7);
        assertEquals(7, rating.getId());
	}

	@Test
	public void testSetId() {
		rating.setId(7);
        assertEquals(7, rating.getId());
	}

	@Test
	public void testGetInternetMovieDatabase() {
		rating.setInternetMovieDatabase(7);
        assertEquals(7,7, rating.getInternetMovieDatabase());
	}

	@Test
	public void testSetInternetMovieDatabase() {
		rating.setInternetMovieDatabase(7);
        assertEquals(7,7, rating.getInternetMovieDatabase());
	}

	@Test
	public void testGetRottenTomatoes() {
		rating.setRottenTomatoes(7);
        assertEquals(7,7, rating.getRottenTomatoes());	}

	@Test
	public void testSetRottenTomatoes() {
		rating.setRottenTomatoes(7);
        assertEquals(7,7, rating.getRottenTomatoes());
	}

	@Test
	public void testGetMetacritic() {
		rating.setMetacritic(7);
        assertEquals(7,7, rating.getMetacritic());
	}

	@Test
	public void testSetMetacritic() {
		rating.setMetacritic(7);
        assertEquals(7,7, rating.getMetacritic());
	}

	@Test
	public void testGetMetascore() {
		rating.setMetascore(7);
        assertEquals(7,7, rating.getMetascore());
	}

	@Test
	public void testSetMetascore() {
		rating.setMetascore(7);
        assertEquals(7,7, rating.getMetascore());
	}

	@Test
	public void testGetImdb() {
		rating.setImdb(7);
        assertEquals(7,7, rating.getImdb());
	}

	@Test
	public void testSetImdb() {
	rating.setImdb(7);
       assertEquals(7,7, rating.getImdb());
	}

	@Test
	public void testGetImdbVotes() {
		rating.setImdbVotes(7);
        assertEquals(7, rating.getImdbVotes());
	}

	@Test
	public void testSetImdbVotes() {
		rating.setImdbVotes(7);
        assertEquals(7, rating.getImdbVotes());
	}

	@Test
	public void testGetMovieId() {
		rating.setMovieId(7);
        assertEquals(7, rating.getMovieId());
	}

	@Test
	public void testSetMovieId() {
		rating.setMovieId(7);
        assertEquals(7, rating.getMovieId());
	}

	@Test
	public void testGetLinks() {
		rating.setLinks(null);
		assertEquals(null ,rating.getLinks());
	}

	@Test
	public void testSetLinks() {
		rating.setLinks(null);
		assertEquals(null, rating.getLinks());
	}

	@Test
	public void testAddLink() {
		rating.addLink("https://example.com","https://example.com");
		assertEquals("\"https://example.com\"", rating.getLinks());
	}

}
