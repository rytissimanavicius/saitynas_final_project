package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lt.viko.eif.saitynas_final_project.objects.Rating;

public class RatingDAOImpl implements RatingDAO {
	private Connection connection;
	
	public RatingDAOImpl() {
        SqlConnection sqlConnection = new SqlConnection();
        connection = sqlConnection.getConnection();
    }
	
	@Override
    public int addRating(Rating rating) {
        int movieId = 0;
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
            	movieId = generatedKeys.getInt(1);
            }
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }

        return movieId;
    }
}
