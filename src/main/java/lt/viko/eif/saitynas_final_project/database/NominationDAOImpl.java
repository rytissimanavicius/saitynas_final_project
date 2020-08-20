package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lt.viko.eif.saitynas_final_project.objects.Nomination;

public class NominationDAOImpl implements NominationDAO{
	private Connection connection;
	
	public NominationDAOImpl() {
        SqlConnection sqlConnection = new SqlConnection();
        connection = sqlConnection.getConnection();
    }
	
	@Override
	public int addNomination(Nomination nomination) {
		int result = 0;
        
        try {
            String query = "INSERT INTO nomination (name, year, won, movie_id) "
            		+ "VALUES (?, ?, ?, ?)";

            PreparedStatement prepStmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1, nomination.getName());
            prepStmt.setString(2, nomination.getYear());
            prepStmt.setBoolean(3, nomination.isWon());
            prepStmt.setInt(4, nomination.getMovieId());
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
	public int deleteNominationById(int id) {
		int result = 0;
		
        try {
            String query = "DELETE FROM nomination WHERE id = ?";

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
	public int updateNominationById(Nomination nomination) {
		int result = 0;
		
		try {
            String query = "UPDATE nomination SET name = ?, year = ?, won = ?, movie_id = ? WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, nomination.getName());

            result += prepStmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
		
		return result;
	}

	@Override
	public Nomination getNominationById(int id) {
		Nomination nomination = new Nomination();
		
		try {
            String query = "SELECT * FROM nomination WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1, id);
            
            ResultSet result = prepStmt.executeQuery();
            
            while (result.next()) {
                nomination.setId(result.getInt(1));
                nomination.setName(result.getString(2));
                nomination.setYear(result.getString(3));
                nomination.setWon(result.getBoolean(4));
                nomination.setMovieId(result.getInt(5));
            }
            
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
		
		return nomination;
	}

}
