package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;



import lt.viko.eif.saitynas_final_project.database.GenreDAO;
import lt.viko.eif.saitynas_final_project.database.GenreDAOImpl;
import lt.viko.eif.saitynas_final_project.objects.Genre;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenreDAOImplTest {
	private static GenreDAO genreDAO;
    List<Genre> foundGenre = new ArrayList<>();
    static Genre testGenre = new Genre();
    
	@BeforeClass
	 public static void setUp() {
        genreDAO = new GenreDAOImpl();
        testGenre.setName("Comedy");
	}

	@AfterClass
	public static void tearDown() {
       genreDAO = null;
	}
	@Test
	public void testAddGenre() {
		Genre addedGenre = new Genre();

        genreDAO.addGenre(testGenre);
        addedGenre = genreDAO.getGenreById(1);
        assertEquals(testGenre.getName(), addedGenre.getName());
        genreDAO.deleteGenreById(addedGenre.getId());
	}

	@Test
	public void testDeleteGenreById() {
		Genre addedGenre = new Genre();

        genreDAO.addGenre(testGenre);
        addedGenre = genreDAO.getGenreById(1);
        int id = addedGenre.getId();
        assertEquals(true, genreDAO.deleteGenreById(id));
	}

	@Test
	public void testUpdateGenreById() {
		int id = genreDAO.addGenre(testGenre);
        testGenre.setId(id);
        testGenre.setName("ChangedTest");
        assertEquals(false, genreDAO.updateGenreById(testGenre));
        genreDAO.deleteGenreById(id);
	}

	@Test
	public void testGetGenreById() {
		int id = genreDAO.addGenre(testGenre);
        testGenre.setId(id);
        testGenre.setName("ChangedTest");
        assertEquals(false, genreDAO.getGenreById(1));
        genreDAO.deleteGenreById(id);
	}


	}


