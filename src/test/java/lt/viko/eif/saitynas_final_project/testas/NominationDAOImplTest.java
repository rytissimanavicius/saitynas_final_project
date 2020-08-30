package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import lt.viko.eif.saitynas_final_project.database.NominationDAO;
import lt.viko.eif.saitynas_final_project.database.NominationDAOImpl;

import lt.viko.eif.saitynas_final_project.objects.Nomination;

public class NominationDAOImplTest {
	private static NominationDAO nominationDAO;
	public int addNomination(Nomination nomination) {
		return 0;
		}
		static Nomination testNomination = new Nomination();
	@BeforeClass
	 public static void setUp() {
		nominationDAO = new NominationDAOImpl();
		testNomination.setName("Oscar");
		testNomination.setYear("1987");
		testNomination.setWon (null);
		testNomination.setMovieId(5);

	}
	@AfterClass
	 public static void tearDown() {
        nominationDAO = null;
        testNomination = null;
	}

	@Test
	public void testAddNomination() {
		int id = nominationDAO.addNomination(testNomination);
        assertEquals(testNomination.getName(), nominationDAO.getNominationById(id).getName());
        nominationDAO.deleteNominationById(id);
	}

	@Test
	public void testDeleteNominationById() {
		int id = nominationDAO.addNomination(testNomination);
        assertEquals(true, nominationDAO.deleteNominationById(id));
	}

	@Test
	public void testUpdateNominationById() {
		int id = nominationDAO.addNomination(testNomination);
        testNomination.setId(id);
        testNomination.setName("ChangedTest");
        assertEquals(false, nominationDAO.updateNominationById(testNomination));
        nominationDAO.deleteNominationById(id);
	}

	@Test
	public void testGetNominationById() {
		int id = nominationDAO.addNomination(testNomination);
        testNomination = nominationDAO.getNominationById(1);
        assertEquals(testNomination,1);
        nominationDAO.deleteNominationById(id);
	}


	
	}

	

