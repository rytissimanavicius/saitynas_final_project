package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lt.viko.eif.saitynas_final_project.objects.Staff;

public class StaffDAOImpl implements StaffDAO {
	private Connection connection;
	
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
            System.out.println(exc.getMessage());
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
            System.out.println(exc.getMessage());
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
            System.out.println(ex.getMessage());
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
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
		
		return staff;
	}
	
	@Override
	public int getStaffId(String name) {
		int result = 0;
		
		try {
            String query = "SELECT id FROM staff WHERE name = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, name);
            
            ResultSet resultSet = prepStmt.executeQuery();
            
            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
		
		return result;
	}
}