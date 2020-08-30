package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;


import lt.viko.eif.saitynas_final_project.database.StaffDAO;
 import lt.viko.eif.saitynas_final_project.database.StaffDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Staff;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class StaffDAOImplTest {
	private static StaffDAO staffDAO;
	public int addStaff(Staff staff) {
		return 0;
	}
    static Staff testStaff = new Staff();
	@BeforeClass
	public static void setUp() {
		staffDAO = new StaffDAOImpl();
		testStaff.setName("Jonas");
		testStaff.setSurname("Petras");
		testStaff.setRole("Actor");
		testStaff.setOrigin("USA");
		testStaff.setMovieId(5);
	}

	@AfterClass
		public static void tearDown() {
	        staffDAO = null;
	        testStaff = null;
	}


	@Test
	public void testAddStaff() {
		int id = staffDAO.addStaff(testStaff);
        assertEquals(testStaff.getName(), staffDAO.getStaffById(id).getName());
        staffDAO.deleteStaffById(id);
	}

	@Test
	public void testDeleteStaffById() {
		int id = staffDAO.addStaff(testStaff);
        assertEquals(true, staffDAO.deleteStaffById(id));
	}

	@Test
	public void testUpdateStaffById() {
		int id = staffDAO.addStaff(testStaff);
        testStaff.setId(id);
        testStaff.setName("ChangedTest");
        assertEquals(false, staffDAO.updateStaffById(testStaff));
        staffDAO.deleteStaffById(id);
	}

	@Test
	public void testGetStaffById() {
		int id = staffDAO.addStaff(testStaff);
        assertEquals("TestStaff", staffDAO.getStaffById(id).getName());
        staffDAO.deleteStaffById(id);
	}

	@Test
	public void testGetMoviesByStaff() {
		staffDAO.addStaff(testStaff);
        testStaff = (Staff) staffDAO.getMoviesByStaff(testStaff);
        assertEquals(testStaff,1);

	}

}
