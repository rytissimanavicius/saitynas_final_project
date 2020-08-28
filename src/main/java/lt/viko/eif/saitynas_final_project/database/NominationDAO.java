package lt.viko.eif.saitynas_final_project.database;

import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.Nomination;

/**
 * Interface that contains CRUD operations with nomination object.
 * @author Erikas Bykovskis
 *
 */
public interface NominationDAO {
	
	/**
	 * Adds a new nomination object to the database.
	 * @param nomination
	 * @return
	 */
	public int addNomination(Nomination nomination);
	
	/**
	 * Deletes nomination object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public int deleteNominationById(int id);
	
	/**
	 * Updates nomination object with a new nomination object in the database that matches the id.
	 * @param nomination
	 * @return
	 */
	public int updateNominationById(Nomination nomination);
	
	/**
	 * Returns a nomination object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public Nomination getNominationById(int id);
	
	/**
	 * Returns nomination objects from the database that have most matches with nomination search object.
	 * @param nomination
	 * @return
	 */
	public List<Movie> getMoviesByNominations(Nomination nomination);
}
