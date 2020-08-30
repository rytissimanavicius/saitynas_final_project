package lt.viko.eif.saitynas_final_project.testas;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import lt.viko.eif.saitynas_final_project.database.RatingDAO;

import lt.viko.eif.saitynas_final_project.objects.Rating;

public class RatingDAOImplTest {
	private static RatingDAO ratingDAO;
	public int addRating(Rating rating) {
		return 0;
		}
		static Rating testRating = new Rating();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testRating .setInternetMovieDatabase(123);
		testRating .setRottenTomatoes(123);
		testRating .setMetacritic(123);
        testRating .setMetascore(123);
        testRating .setImdb(123);
        testRating .setImdbVotes(123);
        testRating .setMovieId(123);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ratingDAO = null;
        testRating = null;

	}
	@Test
	public void testAddRating() {
		Rating addedRating = new Rating();

		ratingDAO.addRating(testRating);
        addedRating = ratingDAO.getRatingById(1);
        ratingDAO.deleteRatingById(addedRating.getId());
	}

	@Test
	public void testDeleteRatingById() {
		Rating addedRating = new Rating();

		ratingDAO.addRating (testRating);
        addedRating = ratingDAO.getRatingById(1);
        int id = addedRating.getId();
        assertEquals(true, ratingDAO.deleteRatingById(id));
	}

	@Test
	public void testUpdateRatingById() {
		int id = ratingDAO.addRating(testRating);
        testRating.setId(id);
        assertEquals(false, ratingDAO.updateRatingById(testRating));
        ratingDAO.deleteRatingById(id);
	}

	@Test
	public void testGetRatingById() {
		int id = ratingDAO.addRating(testRating);
        testRating = ratingDAO.getRatingById(1);
        assertEquals(testRating,1);
        ratingDAO.deleteRatingById(id);
	}

	@Test
	public void testGetMoviesByRatings() {
		int id = ratingDAO.addRating(testRating);
        testRating = ratingDAO.getRatingById(1);
        assertEquals(testRating,1);
        ratingDAO.deleteRatingById(id);
	}

	}

