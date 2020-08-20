package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lt.viko.eif.saitynas_final_project.objects.Movie;

public class MovieDAOImpl implements MovieDAO{
	private Connection connection;
	
	public MovieDAOImpl() {
        SqlConnection sqlConnection = new SqlConnection();
        connection = sqlConnection.getConnection();
    }
	
	@Override
    public int addMovie(Movie movie) {
        int result = 0;
        
        try {
            String query = "INSERT INTO movie (title, year, ratedAs, lengthMinutes, languages, "
            		+ "country, type, producedBy, genreId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1, movie.getTitle());
            prepStmt.setInt(2, movie.getYear());
            prepStmt.setString(3, movie.getRatedAs());
            prepStmt.setInt(4, movie.getLengthMinutes());
            prepStmt.setString(5, movie.getLanguages());
            prepStmt.setString(6, movie.getCountry());
            prepStmt.setString(7, movie.getType());
            prepStmt.setString(8, movie.getProducedBy());
            prepStmt.setInt(9, movie.getGenreId());
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
	public int deleteMovieById(int id) {
		int result = 0;
		
        try {
            String query = "DELETE FROM movie WHERE id = ?";

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
	public int updateMovieById(Movie movie) {
		int result = 0;
		
		try {
            String query = "UPDATE movie SET title = ?, year = ?, ratedAs = ?, lengthMinutes = ?, " +
                    "languages = ?, country = ?, type = ?, producedBy = ?, genreId = ? WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, movie.getTitle());
            prepStmt.setInt(2, movie.getYear());
            prepStmt.setString(3, movie.getRatedAs());
            prepStmt.setInt(4, movie.getLengthMinutes());
            prepStmt.setString(5, movie.getLanguages());
            prepStmt.setString(6, movie.getCountry());
            prepStmt.setString(7, movie.getType());
            prepStmt.setString(8, movie.getProducedBy());
            prepStmt.setInt(9, movie.getGenreId());
            prepStmt.setInt(10, movie.getId());

            result += prepStmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
		
		return result;
	}
	
	@Override
	public Movie getMovieById(int id) {
		Movie movie = new Movie();
		
		try {
            String query = "SELECT * FROM movie WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1, id);
            
            ResultSet result = prepStmt.executeQuery();
            
            while (result.next()) {
                movie.setId(result.getInt(1));
                movie.setTitle(result.getString(2));
                movie.setYear(result.getInt(3));
                movie.setRatedAs(result.getString(4));
                movie.setLengthMinutes(result.getInt(5));
                movie.setLanguages(result.getString(6));
                movie.setCountry(result.getString(7));
                movie.setType(result.getString(8));
                movie.setProducedBy(result.getString(9));
                movie.setGenreId(result.getInt(10));
            }
            
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
		
		return movie;
	}
}
