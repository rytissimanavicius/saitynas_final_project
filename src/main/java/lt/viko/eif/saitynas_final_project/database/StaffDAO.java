package lt.viko.eif.saitynas_final_project.database;

import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.Staff;

public interface StaffDAO {
	public int addStaff(Staff staff);
	public int deleteStaffById(int id);
	public int updateStaffById(Staff staff);
	public Staff getStaffById(int id);
	//public int getStaffId(String name);
	public List<Movie> getMoviesByStaff(Staff staff);
}
