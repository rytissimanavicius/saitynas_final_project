package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;


import lt.viko.eif.saitynas_final_project.objects.MovieSearch;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MovieSearchTest {
	private static MovieSearch movieSearch;
	
	@BeforeClass
	public static void setUp() {
        movieSearch = new MovieSearch();
	}
	
	@AfterClass
	public static void tearDown() {
        movieSearch = null;
        }

	@Test
	public final void testMovieSearch() {
		movieSearch.setTitle("TestMovie");
        assertEquals("TestMovie", movieSearch.getTitle());
	}

	@Test
	public final void testGetId() {
		 movieSearch.setId(7);
	        assertEquals(7, movieSearch.getId());
	}

	@Test
	public final void testSetId() {
		 movieSearch.setId(7);
	        assertEquals(7, movieSearch.getId());
	}
	@Test
	public final void testGetTitle() {
		movieSearch.setTitle("TestName");
        assertEquals("TestName", movieSearch.getTitle());
	}

	@Test
	public final void testSetTitle() {
		movieSearch.setTitle("TestName");
        assertEquals("TestName", movieSearch.getTitle());
	}

	@Test
	public final void testGetYear() {
		movieSearch.setYear(1999);
        assertEquals(1999, movieSearch.getYear());
	}

	@Test
	public final void testSetYear() {
		movieSearch.setYear(1999);
        assertEquals(1999, movieSearch.getYear());
	}

	@Test
	public final void testGetRatedAs() {
		movieSearch.setRatedAs("top");
        assertEquals("top", movieSearch.getRatedAs());
	}

	@Test
	public final void testSetRatedAs() {
		movieSearch.setRatedAs("top");
		assertEquals("top", movieSearch.getRatedAs());
		}

	@Test
	public final void testGetLengthMinutesMin() {
		 movieSearch.setLengthMinutesMin(10);
	        assertEquals(10, movieSearch.getLengthMinutesMin());
	}

	@Test
	public final void testSetLengthMinutesMin() {
		movieSearch.setLengthMinutesMin(10);
        assertEquals(10, movieSearch.getLengthMinutesMin());
	}

	@Test
	public final void testGetLengthMinutesMax() {
		movieSearch.setLengthMinutesMax(200);
        assertEquals(200, movieSearch.getLengthMinutesMax());
	}

	@Test
	public final void testSetLengthMinutesMax() {
		movieSearch.setLengthMinutesMax(200);
        assertEquals(200, movieSearch.getLengthMinutesMax());
	}

	@Test
	public final void testGetLanguage() {
		movieSearch.setLanguage("LT");
        assertEquals("LT", movieSearch.getLanguage());
	}

	@Test
	public final void testSetLanguage() {
		movieSearch.setLanguage("LT");
        assertEquals("LT", movieSearch.getLanguage());
	}

	@Test
	public final void testGetCountry() {
		movieSearch.setCountry("LT");
        assertEquals("LT", movieSearch.getCountry());
	}

	@Test
	public final void testSetCountry() {
		movieSearch.setCountry("LT");
        assertEquals("LT", movieSearch.getCountry());
	}

	@Test
	public final void testGetType() {
		movieSearch.setType("TestName");
        assertEquals("TestName", movieSearch.getType());
	}

	@Test
	public final void testSetType() {
		movieSearch.setType("TestName");
        assertEquals("TestName", movieSearch.getType());
	}

	@Test
	public final void testGetProducedBy() {
		movieSearch.setProducedBy("TestName");
        assertEquals("TestName", movieSearch.getProducedBy());
	}

	@Test
	public final void testSetProducedBy() {
		 movieSearch.setProducedBy("TestName");
	        assertEquals("TestName", movieSearch.getProducedBy());
	}

	@Test
	public final void testGetGenreId() {
		 movieSearch.setGenreId(7);
	        assertEquals(7, movieSearch.getGenreId());
	}

	@Test
	public final void testSetGenreId() {
		 movieSearch.setGenreId(7);
	        assertEquals(7, movieSearch.getGenreId());
	}

}
