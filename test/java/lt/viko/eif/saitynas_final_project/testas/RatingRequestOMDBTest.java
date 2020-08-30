package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;

import lt.viko.eif.saitynas_final_project.objects.RatingRequestOMDB;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RatingRequestOMDBTest {
	private static RatingRequestOMDB ratingRequestOMDB;
	@BeforeClass
	public static void setUp() {
		ratingRequestOMDB = new RatingRequestOMDB();}

	@AfterClass
	 public static void tearDown() {
		ratingRequestOMDB = null;
        }
	@Test
	public void testGetId() {
		ratingRequestOMDB.setId(7);
		        assertEquals(7, ratingRequestOMDB.getId());
	}

	@Test
	public void testSetId() {
	ratingRequestOMDB.setId(7);
    assertEquals(7, ratingRequestOMDB.getId());
	}

	@Test
	public void testGetName() {
		ratingRequestOMDB.setName("TestName");
        assertEquals("TestName", ratingRequestOMDB.getName());
	}

	@Test
	public void testSetName() {
		ratingRequestOMDB.setName("TestName");
        assertEquals("TestName", ratingRequestOMDB.getName());
	}

	@Test
	public void testGetMovieId() {
		ratingRequestOMDB.setMovieId(7);
	    assertEquals(7, ratingRequestOMDB.getMovieId());
	}
	@Test
	public void testSetMovieId() {
		ratingRequestOMDB.setMovieId(7);
	    assertEquals(7, ratingRequestOMDB.getMovieId());	}

}
