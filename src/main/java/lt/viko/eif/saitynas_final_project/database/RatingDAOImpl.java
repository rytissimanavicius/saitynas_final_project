package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.Rating;
import lt.viko.eif.saitynas_final_project.objects.Staff;

public class RatingDAOImpl implements RatingDAO {
	private Connection connection;
	
	public RatingDAOImpl() {
        SqlConnection sqlConnection = new SqlConnection();
        connection = sqlConnection.getConnection();
    }
	
	@Override
    public int addRating(Rating rating) {
        int result = 0;
        
        try {
            String query = "INSERT INTO rating (internetMovieDatabase, rottenTomatoes, metacritic, metascore, imdb, imdbVotes, movieId) "
            		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement prepStmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            prepStmt.setDouble(1, rating.getInternetMovieDatabase());
            prepStmt.setDouble(2, rating.getRottenTomatoes());
            prepStmt.setDouble(3, rating.getMetacritic());
            prepStmt.setDouble(4, rating.getMetascore());
            prepStmt.setDouble(5, rating.getImdb());
            prepStmt.setInt(6, rating.getImdbVotes());
            prepStmt.setInt(7, rating.getMovieId());
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
	public int deleteRatingById(int id) {
		int result = 0;
		
        try {
            String query = "DELETE FROM rating WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1, id);
            
            result += prepStmt.executeUpdate();
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        
        return result;
	}
	
	@Override
	public int updateRatingById(Rating rating) {
		int result = 0;
		
		try {
            String query = "UPDATE rating SET internetMovieDatabase = ?, rottenTomatoes = ?, metacritic = ?, metascore = ?, " +
                    "imdb = ?, imdbVotes = ?, movieID = ? WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setDouble(1, rating.getInternetMovieDatabase());
            prepStmt.setDouble(2, rating.getRottenTomatoes());
            prepStmt.setDouble(3, rating.getMetacritic());
            prepStmt.setDouble(4, rating.getMetascore());
            prepStmt.setDouble(5, rating.getImdb());
            prepStmt.setInt(6, rating.getImdbVotes());
            prepStmt.setInt(7, rating.getMovieId());
            prepStmt.setInt(8, rating.getId());

            result += prepStmt.executeUpdate();
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return result;
	}
	
	@Override
	public Rating getRatingById(int id) {
		Rating rating = new Rating();
		
		try {
            String query = "SELECT * FROM rating WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1, id);
            
            ResultSet result = prepStmt.executeQuery();
            
            while (result.next()) {
                rating.setId(result.getInt(1));
                rating.setInternetMovieDatabase(result.getDouble(2));
                rating.setRottenTomatoes(result.getDouble(3));
                rating.setMetacritic(result.getDouble(4));
                rating.setMetascore(result.getDouble(5));
                rating.setImdb(result.getDouble(6));
                rating.setImdbVotes(result.getInt(7));
                rating.setMovieId(result.getInt(8));
            }
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return rating;
	}
}
