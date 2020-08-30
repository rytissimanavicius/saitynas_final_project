package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;
import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.database.MovieDAO;
import lt.viko.eif.saitynas_final_project.database.MovieDAOImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MovieDAOImplTest {
	
	private static MovieDAO movieDAO;
	public int addMovie(Movie movie) {
		return 0;
	}
    static Movie testMovie = new Movie();
	@BeforeClass
	public static void setUp() {
		movieDAO = new MovieDAOImpl();
	testMovie.setType("WAR");
	testMovie.setYear(1999);
	testMovie.setRatedAs("Best");
	testMovie.setLengthMinutes(144);
	testMovie.setLanguages("English");
	testMovie.setCountry("USA");
	testMovie.setType("Comedy");
	testMovie.setProducedBy("Tomas");
	testMovie.setGenreId(1);
	}
	@AfterClass
	public static void tearDown() {
        movieDAO = null;
        testMovie = null;
	}
	@Test
	public void testAddMovie() {
		int id = movieDAO.addMovie(testMovie);
        assertEquals(testMovie.getTitle(), movieDAO.getMovieById(id).getTitle());
        movieDAO.deleteMovieById(id);
	}

	@Test
	public void testDeleteMovieById() {
		int id = movieDAO.addMovie(testMovie);
        assertEquals(true, movieDAO.deleteMovieById(id));
	}

	@Test
	public void testUpdateMovieById() {
		int id = movieDAO.addMovie(testMovie);
        testMovie.setId(id);
        testMovie.setTitle("ChangedTest");
        assertEquals(false, movieDAO.updateMovieById(testMovie));
       movieDAO.deleteMovieById(id);
	}

	@Test
	public void testGetMovieByTitle() {
		 int id = movieDAO.addMovie(testMovie);
	        testMovie = movieDAO.getMovieByTitle("TestMovie");
	        assertEquals(testMovie,1);
	        movieDAO.deleteMovieById(id);
	}

	@Test
	public void testGetMoviesByAttributes() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMovieById() {
		int id = movieDAO.addMovie(testMovie);
        assertEquals("TestMovie", movieDAO.getMovieById(id).getTitle());
        movieDAO.deleteMovieById(id);
	}

}
