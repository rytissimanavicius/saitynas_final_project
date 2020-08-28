package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.Nomination;

/**
 * Implementation of CRUD operations with nominaiton object.
 * @author Erikas Bykovskis
 *
 */
public class NominationDAOImpl implements NominationDAO{
	private Connection connection;
	private MovieDAO movieDAO = new MovieDAOImpl();
	
	/**
	 * Object constructor that connects it to the database.
	 */
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

	@Override
	public List<Movie> getMoviesByNominations(Nomination nomination) {
		String query = "";
		List<Nomination> foundNomination = null;
		
		if (!nomination.getName().isEmpty()) {
			query = "SELECT * FROM nomination WHERE name = ?";
			foundNomination = retrieveSuitableNomination(query, nomination.getName());
		}
		if (!nomination.getYear().isEmpty() && foundNomination == null) {
			query = "SELECT * FROM nomination WHERE year = ?";
			foundNomination = retrieveSuitableNomination(query, nomination.getYear());
		}
		if (nomination.isWon() != null && foundNomination == null) {
			query = "SELECT * FROM nomination WHERE won = ?";
			foundNomination = retrieveSuitableNomination(query, String.valueOf(nomination.isWon()));
		}
		
		int matches = 0, maxMatches = 0;
		List<Integer> nominationAttributeMatches = new ArrayList<Integer>();
		
		if (foundNomination != null) {
			for (Nomination temp : foundNomination) {
				matches = 0;
				
				if (temp.getName().equals(nomination.getName()))
					matches++;
				if (temp.getYear().equals(nomination.getYear()))
					matches++;
				if (temp.isWon() == (nomination.isWon()))
					matches++;
				
				if (matches > maxMatches)
					maxMatches = matches;
				
				nominationAttributeMatches.add(matches);
			}
		}
		
		List<Integer> movieIds = new ArrayList<Integer>();
		
		for (int i = 0; i < nominationAttributeMatches.size(); i++) 
			if (nominationAttributeMatches.get(i) == maxMatches && !movieIds.contains(foundNomination.get(i).getMovieId())) 
				movieIds.add(foundNomination.get(i).getMovieId());
		
		List<Movie> retrievedMovies = new ArrayList<Movie>();
		
		for (Integer id : movieIds) 
			retrievedMovies.add(movieDAO.getMovieById(id));
		
		return retrievedMovies;
	}

	/**
	 * Return a list of nomination when query is to find nomination that match the optional attribute.
	 * @param query
	 * @param option
	 * @return
	 */
	public List<Nomination> retrieveSuitableNomination(String query, String option) {
		Nomination nomination = null;
		List<Nomination> foundNomination = new ArrayList<Nomination>();
		
		try {
			PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, option);
            
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
            	nomination = new Nomination();
                nomination.setId(resultSet.getInt(1));
                nomination.setName(resultSet.getString(2));
                nomination.setYear(resultSet.getString(3));
                nomination.setWon(resultSet.getBoolean(4));
                nomination.setMovieId(resultSet.getInt(5));
                foundNomination.add(nomination);
                nomination = null;
            }
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return foundNomination;
	}
}
