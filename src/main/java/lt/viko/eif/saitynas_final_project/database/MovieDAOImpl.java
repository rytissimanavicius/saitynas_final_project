package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Movie;
import lt.viko.eif.saitynas_final_project.objects.MovieSearch;

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
            
        } catch (SQLException exc) {
            exc.printStackTrace();
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
            exc.printStackTrace();
        }
		
		return movie;
	}
	
	@Override
	public List<Movie> getMoviesByAttributes(MovieSearch movieSearch) {
		String query = "";
		List<Movie> foundMovies = null;
		
		if (!movieSearch.getTitle().isEmpty()) {
			query = "SELECT * FROM movie WHERE title = ?";
			foundMovies = retrieveSuitableMovies(query, movieSearch.getTitle());
		}
		if (movieSearch.getYear() > 0 && foundMovies == null) {
			query = "SELECT * FROM movie WHERE year = ?";
			foundMovies = retrieveSuitableMovies(query, String.valueOf(movieSearch.getYear()));
		}
		if (!movieSearch.getRatedAs().isEmpty() && foundMovies == null) {
			query = "SELECT * FROM movie WHERE ratedAs = ?";
			foundMovies = retrieveSuitableMovies(query, movieSearch.getRatedAs());
		}
		if (movieSearch.getLengthMinutesMin() > 0 && movieSearch.getLengthMinutesMax() > movieSearch.getLengthMinutesMin() 
				&& foundMovies == null) {
			query = "SELECT * FROM movie WHERE lengthMinutes between ? and ?";
			foundMovies = retrieveSuitableMoviesBetweenLengths(query, movieSearch.getLengthMinutesMin(), movieSearch.getLengthMinutesMax());
		}
		if (!movieSearch.getLanguage().isEmpty() && foundMovies == null) {
			query = "SELECT * FROM movie WHERE languages LIKE ?";
			foundMovies = retrieveSuitableMovies(query, "%" + movieSearch.getLanguage() + "%");
		}
		if (!movieSearch.getCountry().isEmpty() && foundMovies == null) {
			query = "SELECT * FROM movie WHERE country = ?";
			foundMovies = retrieveSuitableMovies(query, movieSearch.getCountry());
		}
		if (!movieSearch.getType().isEmpty() && foundMovies == null) {
			query = "SELECT * FROM movie WHERE type = ?";
			foundMovies = retrieveSuitableMovies(query, movieSearch.getType());
		}
		if (!movieSearch.getProducedBy().isEmpty() && foundMovies == null) {
			query = "SELECT * FROM movie WHERE producedBy = ?";
			foundMovies = retrieveSuitableMovies(query, movieSearch.getProducedBy());
		}
		
		int matches = 0, maxMatches = 0;
		List<Integer> movieAttributeMatches = new ArrayList<Integer>();
		
		if (foundMovies != null) {
			for (Movie temp : foundMovies) {
				matches = 0;
				
				if (temp.getTitle().equals(movieSearch.getTitle()))
					matches++;
				if (temp.getYear() == movieSearch.getYear())
					matches++;
				if (temp.getRatedAs().equals(movieSearch.getRatedAs()))
					matches++;
				if (temp.getLengthMinutes() >= movieSearch.getLengthMinutesMin() && temp.getLengthMinutes() <= movieSearch.getLengthMinutesMax())
					matches++;
				if (temp.getLanguages().contains(movieSearch.getLanguage()))
					matches++;
				if (temp.getCountry().equals(movieSearch.getCountry()))
					matches++;
				if (temp.getType().equals(movieSearch.getType()))
					matches++;
				if (temp.getProducedBy().equals(movieSearch.getProducedBy()))
					matches++;
				
				if (matches > maxMatches)
					maxMatches = matches;
				
				movieAttributeMatches.add(matches);
			}
		}
		
		List<Integer> movieIds = new ArrayList<Integer>();
		
		for (int i = 0; i < movieAttributeMatches.size(); i++) 
			if (movieAttributeMatches.get(i) == maxMatches && !movieIds.contains(foundMovies.get(i).getId())) 
				movieIds.add(foundMovies.get(i).getId());
		
		List<Movie> retrievedMovies = new ArrayList<Movie>();
		
		for (Integer id : movieIds) 
			retrievedMovies.add(getMovieById(id));
		
		return retrievedMovies;
	}
	
	public List<Movie> retrieveSuitableMovies(String query, String option) {
		Movie movie = null;
		List<Movie> foundMovies = new ArrayList<Movie>();
		
		try {
			PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, option);
            
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
            	movie = new Movie();
                movie.setId(resultSet.getInt(1));
                movie.setTitle(resultSet.getString(2));
                movie.setYear(resultSet.getInt(3));
                movie.setRatedAs(resultSet.getString(4));
                movie.setLengthMinutes(resultSet.getInt(5));
                movie.setLanguages(resultSet.getString(6));
                movie.setCountry(resultSet.getString(7));
                movie.setType(resultSet.getString(8));
                movie.setProducedBy(resultSet.getString(9));
                movie.setGenreId(resultSet.getInt(10));
                foundMovies.add(movie);
                movie = null;
            }
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return foundMovies;
	}
	
	public List<Movie> retrieveSuitableMoviesBetweenLengths(String query, int min, int max) {
		Movie movie = null;
		List<Movie> foundMovies = new ArrayList<Movie>();
		
		try {
			PreparedStatement prepStmt = connection.prepareStatement(query);
			prepStmt.setInt(1, min);
			prepStmt.setInt(2, max);
            
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
            	movie = new Movie();
                movie.setId(resultSet.getInt(1));
                movie.setTitle(resultSet.getString(2));
                movie.setYear(resultSet.getInt(3));
                movie.setRatedAs(resultSet.getString(4));
                movie.setLengthMinutes(resultSet.getInt(5));
                movie.setLanguages(resultSet.getString(6));
                movie.setCountry(resultSet.getString(7));
                movie.setType(resultSet.getString(8));
                movie.setProducedBy(resultSet.getString(9));
                movie.setGenreId(resultSet.getInt(10));
                foundMovies.add(movie);
                movie = null;
            }
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return foundMovies;
	}
}
