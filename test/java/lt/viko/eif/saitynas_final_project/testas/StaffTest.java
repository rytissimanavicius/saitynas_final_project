package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;

import lt.viko.eif.saitynas_final_project.objects.Staff;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StaffTest {
	private static Staff staff;
	@BeforeClass
	public static void setUp() {
        staff = new Staff();
	}

	@AfterClass
	public static void tearDown() {
        staff = null;
        }

	@Test
	public void testGetId() {
		staff.setId(7);
        assertEquals(7, staff.getId());
	}

	@Test
	public void testSetId() {
		staff.setId(7);
        assertEquals(7, staff.getId());
	}

	@Test
	public void testGetName() {
		staff.setName("TestName");
        assertEquals("TestName", staff.getName());
	}

	@Test
	public void testSetName() {
		staff.setName("TestName");
        assertEquals("TestName", staff.getName());
	}

	@Test
	public void testGetSurname() {
		staff.setSurname("TestSurname");
        assertEquals("TestSurname", staff.getSurname());
	}

	@Test
	public void testSetSurname() {
		staff.setSurname("TestSurname");
        assertEquals("TestSurname", staff.getSurname());
	}

	@Test
	public void testGetRole() {
		staff.setRole("Actor");
        assertEquals("Actor", staff.getRole());
	}

	@Test
	public void testSetRole() {
		staff.setRole("Actor");
        assertEquals("Actor", staff.getRole());
	}

	@Test
	public void testGetOrigin() {
		staff.setOrigin("USA");
        assertEquals("USA", staff.getOrigin());
	}

	@Test
	public void testSetOrigin() {
		staff.setOrigin("USA");
        assertEquals("USA", staff.getOrigin());
	}

	@Test
	public void testGetMovieId() {
		staff.setMovieId(7);
        assertEquals(7, staff.getMovieId());
	}

	@Test
	public void testSetMovieId() {
		staff.setMovieId(7);
        assertEquals(7, staff.getMovieId());
	}

	@Test
	public void testGetLinks() {
		staff.setLinks(null);
		assertEquals(null, staff.getLinks());
	}

	@Test
	public void testSetLinks() {
		staff.setLinks(null);
		assertEquals(null, staff.getLinks());
	}
	@Test
	public void testAddLink() {
		staff.addLink(null, "https://example.com");
		assertEquals(null,"https://example.com" , staff.getLinks());
	}

}
