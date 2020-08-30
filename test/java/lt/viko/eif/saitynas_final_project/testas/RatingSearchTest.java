package lt.viko.eif.saitynas_final_project.testas;
import lt.viko.eif.saitynas_final_project.objects.RatingSearch;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RatingSearchTest {
	private static RatingSearch ratingSearch;

	@BeforeClass
	public static void setUp() {
		ratingSearch = new RatingSearch();
	}

	@AfterClass
	public static void tearDown() {
		ratingSearch = null;
        }

	@Test
	public void testGetId() {
		ratingSearch.setId(7);
	     assertEquals(7, ratingSearch.getId());
	}

	@Test
	public void testSetId() {
		ratingSearch.setId(7);
	     assertEquals(7, ratingSearch.getId());
	}

	@Test
	public void testGetInternetMovieDatabaseMin() {
		ratingSearch.setInternetMovieDatabaseMin(7);
	     assertEquals(7,7, ratingSearch.getInternetMovieDatabaseMin());
	}

	@Test
	public void testSetInternetMovieDatabaseMin() {
		ratingSearch.setInternetMovieDatabaseMin(7);
	     assertEquals(7,7, ratingSearch.getInternetMovieDatabaseMin());
	}

	@Test
	public void testGetInternetMovieDatabaseMax() {
		ratingSearch.setInternetMovieDatabaseMax(700);
	     assertEquals(700,700, ratingSearch.getInternetMovieDatabaseMax());
	}

	@Test
	public void testSetInternetMovieDatabaseMax() {
		ratingSearch.setInternetMovieDatabaseMax(700);
	     assertEquals(700,700, ratingSearch.getInternetMovieDatabaseMax());
	}

	@Test
	public void testGetRottenTomatoesMin() {
		ratingSearch.setRottenTomatoesMin(7);
	     assertEquals(7,7, ratingSearch.getRottenTomatoesMin());
	}

	@Test
	public void testSetRottenTomatoesMin() {
		ratingSearch.setRottenTomatoesMin(7);
	     assertEquals(7,7, ratingSearch.getRottenTomatoesMin());
	}

	@Test
	public void testGetRottenTomatoesMax() {
		ratingSearch.setRottenTomatoesMax(700);
	     assertEquals(700,700, ratingSearch.getRottenTomatoesMax());
	}

	@Test
	public void testSetRottenTomatoesMax() {
		ratingSearch.setRottenTomatoesMax(700);
	     assertEquals(700,700, ratingSearch.getRottenTomatoesMax());
	}

	@Test
	public void testGetMetacriticMin() {
		ratingSearch.setMetacriticMin(7);
	     assertEquals(7,7, ratingSearch.getMetacriticMin());
	}

	@Test
	public void testSetMetacriticMin() {
		ratingSearch.setMetacriticMin(7);
	     assertEquals(7,7, ratingSearch.getMetacriticMin());
	}

	@Test
	public void testGetMetacriticMax() {
		ratingSearch.setMetacriticMax(700);
	     assertEquals(700,700, ratingSearch.getMetacriticMax());
	}

	@Test
	public void testSetMetacriticMax() {
		ratingSearch.setMetacriticMax(700);
	     assertEquals(700,700, ratingSearch.getMetacriticMax());
	}

	@Test
	public void testGetMetascoreMin() {
		ratingSearch.setMetascoreMin(7);
	     assertEquals(7,7, ratingSearch.getMetascoreMin());
	}

	@Test
	public void testSetMetascoreMin() {
	ratingSearch.setMetascoreMin(7);
    assertEquals(7,7, ratingSearch.getMetascoreMin());
	}

	@Test
	public void testGetMetascoreMax() {
		ratingSearch.setMetascoreMax(700);
	     assertEquals(700,700, ratingSearch.getMetascoreMax());
	}

	@Test
	public void testSetMetascoreMax() {
		ratingSearch.setMetascoreMax(700);
	     assertEquals(700,700, ratingSearch.getMetascoreMax());
	}

	@Test
	public void testGetImdbMin() {
		ratingSearch.setImdbMin(7);
	     assertEquals(7,7, ratingSearch.getImdbMin());
	}

	@Test
	public void testSetImdbMin() {
		ratingSearch.setImdbMin(7);
	     assertEquals(7,7, ratingSearch.getImdbMin());
	}

	@Test
	public void testGetImdbMax() {
		ratingSearch.setImdbMax(700);
	     assertEquals(700,700, ratingSearch.getImdbMax());
	}

	@Test
	public void testSetImdbMax() {
		ratingSearch.setImdbMax(700);
	     assertEquals(700,700, ratingSearch.getImdbMax());
	}

	@Test
	public void testGetImdbVotesMin() {
		ratingSearch.setImdbVotesMin(0);
	     assertEquals(0, ratingSearch.getImdbVotesMin());
	}

	@Test
	public void testSetImdbVotesMin() {
		ratingSearch.setImdbVotesMin(0);
	     assertEquals(0, ratingSearch.getImdbVotesMin());
	}

	@Test
	public void testGetImdbVotesMax() {
		ratingSearch.setImdbVotesMax(700);
	     assertEquals(700, ratingSearch.getImdbVotesMax());
	}

	@Test
	public void testSetImdbVotesMax() {
		ratingSearch.setImdbVotesMax(700);
	     assertEquals(700, ratingSearch.getImdbVotesMax());
	}

	@Test
	public void testGetMovieId() {
		ratingSearch.setMovieId(700);
	     assertEquals(700, ratingSearch.getMovieId());
	}

	@Test
	public void testSetMovieId() {
		ratingSearch.setMovieId(700);
	     assertEquals(700, ratingSearch.getMovieId());
	}

}
