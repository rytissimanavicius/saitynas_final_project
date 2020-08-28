package lt.viko.eif.saitynas_final_project.database;

import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.Staff;

/**
 * Interface that contains CRUD operations with staff object.
 * @author Rytis Simanavicius
 *
 */
public interface StaffDAO {
	/**
	 * Adds a new staff object to the database.
	 * @param staff
	 * @return
	 */
	public int addStaff(Staff staff);

	/**
	 * Deletes staff object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public int deleteStaffById(int id);

	/**
	 * Updates staff object with a new staff object in the database that matches the id.
	 * @param staff
	 * @return
	 */
	public int updateStaffById(Staff staff);
	
	/**
	 * Returns a staff object from the database that matches the id.
	 * @param id
	 * @return
	 */
	public Staff getStaffById(int id);
	
	/**
	 * Returns staff objects from the database that have most matches with staff search object.
	 * @param staff
	 * @return
	 */
	public List<Movie> getMoviesByStaff(Staff staff);
}
