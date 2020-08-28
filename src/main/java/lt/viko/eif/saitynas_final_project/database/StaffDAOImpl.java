package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.Staff;

/**
 * Implementation of CRUD operations with staff object.
 * @author Rytis Simanavicius
 *
 */
public class StaffDAOImpl implements StaffDAO {
	private Connection connection;
	private MovieDAO movieDAO = new MovieDAOImpl();
	
	/**
	 * Object constructor that connects it to the database.
	 */
	public StaffDAOImpl() {
        SqlConnection sqlConnection = new SqlConnection();
        connection = sqlConnection.getConnection();
    }
	
	@Override
    public int addStaff(Staff staff) {
        int result = 0;
        
        try {
            String query = "INSERT INTO staff (name, surname, role, origin, movieId) "
            		+ "VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement prepStmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1, staff.getName());
            prepStmt.setString(2, staff.getSurname());
            prepStmt.setString(3, staff.getRole());
            prepStmt.setString(4, staff.getOrigin());
            prepStmt.setInt(5, staff.getMovieId());
            prepStmt.executeUpdate();

            ResultSet generatedKeys = prepStmt.getGeneratedKeys();

            if (generatedKeys.next()) {
            	result = generatedKeys.getInt(1);
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        
        return result;
    }
	
	@Override
	public int deleteStaffById(int id) {
		int result = 0;
		
        try {
            String query = "DELETE FROM staff WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1, id);
            
            result += prepStmt.executeUpdate();
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        
        return result;
	}
	
	@Override
	public int updateStaffById(Staff staff) {
		int result = 0;
		
		try {
            String query = "UPDATE staff SET name = ?, surname = ?,"
            		+ " role = ?, origin = ?, movieId = ? WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, staff.getName());
            prepStmt.setString(2, staff.getSurname());
            prepStmt.setString(3, staff.getRole());
            prepStmt.setString(4, staff.getOrigin());
            prepStmt.setInt(5, staff.getMovieId());
            prepStmt.setInt(6, staff.getId());

            result += prepStmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
		
		return result;
	}
	
	@Override
	public Staff getStaffById(int id) {
		Staff staff = new Staff();
		
		try {
            String query = "SELECT * FROM staff WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1, id);
            
            ResultSet resultSet = prepStmt.executeQuery();
            
            while (resultSet.next()) {
                staff.setId(resultSet.getInt(1));
                staff.setName(resultSet.getString(2));
                staff.setSurname(resultSet.getString(3));
                staff.setRole(resultSet.getString(4));
                staff.setOrigin(resultSet.getString(5));
                staff.setMovieId(resultSet.getInt(6));
            }
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return staff;
	}
	
	@Override
	public List<Movie> getMoviesByStaff(Staff staff) {
		String query = "";
		List<Staff> foundStaff = null;
		
		if (!staff.getName().isEmpty()) {
			query = "SELECT * FROM staff WHERE name = ?";
			foundStaff = retrieveSuitableStaff(query, staff.getName());
		}
		if (!staff.getSurname().isEmpty() && foundStaff.isEmpty()) {
			query = "SELECT * FROM staff WHERE surname = ?";
			foundStaff = retrieveSuitableStaff(query, staff.getSurname());
		}
		if (!staff.getRole().isEmpty() && foundStaff.isEmpty()) {
			query = "SELECT * FROM staff WHERE role = ?";
			foundStaff = retrieveSuitableStaff(query, staff.getRole());
		}
		if (!staff.getOrigin().isEmpty() && foundStaff.isEmpty()) {
			query = "SELECT * FROM staff WHERE origin = ?";
			foundStaff = retrieveSuitableStaff(query, staff.getOrigin());
		}
		
		int matches = 0, maxMatches = 0;
		List<Integer> staffAttributeMatches = new ArrayList<Integer>();
		
		if (foundStaff != null) {
			for (Staff temp : foundStaff) {
				matches = 0;
				
				if (temp.getName().equals(staff.getName()))
					matches++;
				if (temp.getSurname().equals(staff.getSurname()))
					matches++;
				if (temp.getRole().equals(staff.getRole()))
					matches++;
				if (temp.getOrigin().equals(staff.getOrigin()))
					matches++;
				
				if (matches > maxMatches)
					maxMatches = matches;
				
				staffAttributeMatches.add(matches);
			}
		}
		
		List<Integer> movieIds = new ArrayList<Integer>();
		
		for (int i = 0; i < staffAttributeMatches.size(); i++) 
			if (staffAttributeMatches.get(i) == maxMatches && !movieIds.contains(foundStaff.get(i).getMovieId())) 
				movieIds.add(foundStaff.get(i).getMovieId());
		
		List<Movie> retrievedMovies = new ArrayList<Movie>();
		
		for (Integer id : movieIds) 
			retrievedMovies.add(movieDAO.getMovieById(id));
		
		return retrievedMovies;
	}
	
	/**
	 * Return a list of staff when query is to find staff that match the optional attribute.
	 * @param query
	 * @param option
	 * @return
	 */
	public List<Staff> retrieveSuitableStaff(String query, String option) {
		Staff staff = null;
		List<Staff> foundStaff = new ArrayList<Staff>();
		
		try {
			PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, option);
            
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
            	staff = new Staff();
                staff.setId(resultSet.getInt(1));
                staff.setName(resultSet.getString(2));
                staff.setSurname(resultSet.getString(3));
                staff.setRole(resultSet.getString(4));
                staff.setOrigin(resultSet.getString(5));
                staff.setMovieId(resultSet.getInt(6));
                foundStaff.add(staff);
                staff = null;
            }
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return foundStaff;
	}
}