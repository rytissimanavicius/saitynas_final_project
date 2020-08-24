package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.Rating;
import lt.viko.eif.saitynas_final_project.objects.RatingSearch;

public class RatingDAOImpl implements RatingDAO {
	private Connection connection;
	private MovieDAO movieDAO = new MovieDAOImpl();
	
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
	
	@Override
	public List<Movie> getMoviesByRatings(RatingSearch ratingSearch) {
		String query = "";
		List<Rating> foundRatings = null;
		
		if (ratingSearch.getInternetMovieDatabaseMin() > 0 && 
				ratingSearch.getInternetMovieDatabaseMax() > ratingSearch.getInternetMovieDatabaseMin() &&
				ratingSearch.getInternetMovieDatabaseMax() <= 10) {
			query = "SELECT * FROM rating WHERE internetMovieDatabase between ? and ?";
			foundRatings = retrieveSuitableMoviesBetweenRatings(query, ratingSearch.getInternetMovieDatabaseMin(), ratingSearch.getInternetMovieDatabaseMax());
		}
		if (ratingSearch.getRottenTomatoesMin() > 0 && 
				ratingSearch.getRottenTomatoesMax() > ratingSearch.getRottenTomatoesMin() &&
				ratingSearch.getRottenTomatoesMax() <= 100 && foundRatings.isEmpty()) {
			query = "SELECT * FROM rating WHERE rottenTomatoes between ? and ?";
			foundRatings = retrieveSuitableMoviesBetweenRatings(query, ratingSearch.getRottenTomatoesMin(), ratingSearch.getRottenTomatoesMax());
		}
		if (ratingSearch.getMetacriticMin() > 0 && 
				ratingSearch.getMetacriticMax() > ratingSearch.getMetacriticMin() &&
				ratingSearch.getMetacriticMax() <= 100 && foundRatings.isEmpty()) {
			query = "SELECT * FROM rating WHERE metacritic between ? and ?";
			foundRatings = retrieveSuitableMoviesBetweenRatings(query, ratingSearch.getMetacriticMin(), ratingSearch.getMetacriticMax());
		}
		if (ratingSearch.getMetascoreMin() > 0 && 
				ratingSearch.getMetascoreMax() > ratingSearch.getMetascoreMin() &&
				ratingSearch.getMetascoreMax() <= 100 && foundRatings.isEmpty()) {
			query = "SELECT * FROM rating WHERE metascore between ? and ?";
			foundRatings = retrieveSuitableMoviesBetweenRatings(query, ratingSearch.getMetascoreMin(), ratingSearch.getMetascoreMax());
		}
		if (ratingSearch.getImdbMin() > 0 && 
				ratingSearch.getImdbMax() > ratingSearch.getImdbMin() &&
				ratingSearch.getImdbMax() <= 10 && foundRatings.isEmpty()) {
			query = "SELECT * FROM rating WHERE imdb between ? and ?";
			foundRatings = retrieveSuitableMoviesBetweenRatings(query, ratingSearch.getImdbMin(), ratingSearch.getImdbMax());
		}
		if (ratingSearch.getImdbVotesMin() > 0 && 
				ratingSearch.getImdbMax() > ratingSearch.getImdbMin() && foundRatings.isEmpty()) {
			query = "SELECT * FROM rating WHERE imdbVotes between ? and ?";
			foundRatings = retrieveSuitableMoviesBetweenVoteCount(query, ratingSearch.getImdbVotesMin(), ratingSearch.getImdbVotesMax());
		}
		
		int matches = 0, maxMatches = 0;
		List<Integer> ratingAttributeMatches = new ArrayList<Integer>();
		
		if (foundRatings != null) {
			for (Rating temp : foundRatings) {
				matches = 0;
				
				if (temp.getInternetMovieDatabase() >= ratingSearch.getInternetMovieDatabaseMin() &&
						temp.getInternetMovieDatabase() <= ratingSearch.getInternetMovieDatabaseMax())
					matches++;
				if (temp.getRottenTomatoes() >= ratingSearch.getRottenTomatoesMin() &&
						temp.getRottenTomatoes() <= ratingSearch.getRottenTomatoesMax())
					matches++;
				if (temp.getMetacritic() >= ratingSearch.getMetacriticMin() &&
						temp.getMetacritic() <= ratingSearch.getMetacriticMax())
					matches++;
				if (temp.getMetascore() >= ratingSearch.getMetascoreMin() &&
						temp.getMetascore() <= ratingSearch.getMetascoreMax())
					matches++;
				if (temp.getImdb() >= ratingSearch.getImdbMin() &&
						temp.getImdb() <= ratingSearch.getImdbMax())
					matches++;
				if (temp.getImdbVotes() >= ratingSearch.getImdbVotesMin() &&
						temp.getImdbVotes() <= ratingSearch.getImdbVotesMax())
					matches++;
				
				if (matches > maxMatches)
					maxMatches = matches;
				
				ratingAttributeMatches.add(matches);
			}
		}
		
		List<Integer> movieIds = new ArrayList<Integer>();
		
		for (int i = 0; i < ratingAttributeMatches.size(); i++) 
			if (ratingAttributeMatches.get(i) == maxMatches && !movieIds.contains(foundRatings.get(i).getId())) 
				movieIds.add(foundRatings.get(i).getMovieId());
		
		List<Movie> retrievedMovies = new ArrayList<Movie>();
		
		for (Integer id : movieIds) 
			retrievedMovies.add(movieDAO.getMovieById(id));
		
		return retrievedMovies;
	}
	
	public List<Rating> retrieveSuitableMoviesBetweenRatings(String query, double min, double max) {
		Rating rating = null;
		List<Rating> foundRatings = new ArrayList<Rating>();
		
		try {
			PreparedStatement prepStmt = connection.prepareStatement(query);
			prepStmt.setDouble(1, min);
			prepStmt.setDouble(2, max);
            
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
            	rating = new Rating();
                rating.setId(resultSet.getInt(1));
                rating.setInternetMovieDatabase(resultSet.getDouble(2));
                rating.setRottenTomatoes(resultSet.getDouble(3));
                rating.setMetacritic(resultSet.getDouble(4));
                rating.setMetascore(resultSet.getDouble(5));
                rating.setImdb(resultSet.getDouble(6));
                rating.setImdbVotes(resultSet.getInt(7));
                rating.setMovieId(resultSet.getInt(8));
                foundRatings.add(rating);
                rating = null;
            }
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return foundRatings;
	}
	
	public List<Rating> retrieveSuitableMoviesBetweenVoteCount(String query, int min, int max) {
		Rating rating = null;
		List<Rating> foundRatings = new ArrayList<Rating>();
		
		try {
			PreparedStatement prepStmt = connection.prepareStatement(query);
			prepStmt.setInt(1, min);
			prepStmt.setInt(2, max);
            
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
            	rating = new Rating();
                rating.setId(resultSet.getInt(1));
                rating.setInternetMovieDatabase(resultSet.getDouble(2));
                rating.setRottenTomatoes(resultSet.getDouble(3));
                rating.setMetacritic(resultSet.getDouble(4));
                rating.setMetascore(resultSet.getDouble(5));
                rating.setImdb(resultSet.getDouble(6));
                rating.setImdbVotes(resultSet.getInt(7));
                rating.setMovieId(resultSet.getInt(8));
                foundRatings.add(rating);
                rating = null;
            }
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return foundRatings;
	}
}
