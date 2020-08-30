package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;


import lt.viko.eif.saitynas_final_project.objects.Nomination;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class NominationTest {
	private static Nomination nomination;
	@BeforeClass
	public static void setUp() {
		nomination = new Nomination();
	}
	
	@AfterClass
	 public static void tearDown() {
		nomination = null;
	}

	@Test
	public void testGetId() {
		 nomination.setId(7);
	        assertEquals(7, nomination.getId());
	}

	@Test
	public void testSetId() {
		nomination.setId(7);
        assertEquals(7, nomination.getId());
	}

	@Test
	public void testGetName() {
		nomination.setName("AWARD");
        assertEquals("AWARD", nomination.getName());
        }

	@Test
	public void testSetName() {
		nomination.setName("AWARD");
        assertEquals("AWARD", nomination.getName());
	}

	@Test
	public void testGetYear() {
		nomination.setYear("1987");
        assertEquals("1987", nomination.getYear());
	}

	@Test
	public void testSetYear() {
		nomination.setYear("1987");
        assertEquals("1987", nomination.getYear());
	}

	@Test
	public void testIsWon() {
		nomination.setWon(true);
        assertEquals(true , nomination.isWon());
	}

	@Test
	public void testSetWon() {
		nomination.setWon(true);
        assertEquals(true, nomination.isWon());
	}

	@Test
	public void testGetMovieId() {
		 nomination.setId(7);
	        assertEquals(7, nomination.getId());
	}

	@Test
	public void testSetMovieId() {
		 nomination.setId(7);
	        assertEquals(7, nomination.getId());
	}

	@Test
	public void testGetLinks() {
		nomination.setLinks(null);
		assertEquals(null ,nomination.getLinks());
	}

	@Test
	public void testSetLinks() {
		nomination.setLinks(null);
		assertEquals(null, nomination.getLinks());
	}

	@Test
	public void testAddLink() {
		nomination.addLink("https://example.com","https://example.com");
		assertEquals("\"https://example.com\"", nomination.getLinks());
	}

}
