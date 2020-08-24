package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lt.viko.eif.saitynas_final_project.objects.Genre;
import lt.viko.eif.saitynas_final_project.objects.Movie;

public class GenreDAOImpl implements GenreDAO{
private Connection connection;
private MovieDAO movieDAO = new MovieDAOImpl();
	
	public GenreDAOImpl() {
        SqlConnection sqlConnection = new SqlConnection();
        connection = sqlConnection.getConnection();
    }

	@Override
	public int addGenre(Genre genre) {
		int result = 0;
        
        try {
            String query = "INSERT INTO genre (name) "
            		+ "VALUES (?)";

            PreparedStatement prepStmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            prepStmt.setString(1, genre.getName());
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
	public int deleteGenreById(int id) {
		int result = 0;
		
        try {
            String query = "DELETE FROM genre WHERE id = ?";

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
	public int updateGenreById(Genre genre) {
		int result = 0;
		
		try {
            String query = "UPDATE genre SET name = ? WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, genre.getName());

            result += prepStmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
		
		return result;
	}

	@Override
	public Genre getGenreById(int id) {
		Genre genre = new Genre();
		
		try {
            String query = "SELECT * FROM genre WHERE id = ?";

            PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setInt(1, id);
            
            ResultSet result = prepStmt.executeQuery();
            
            while (result.next()) {
                genre.setId(result.getInt(1));
                genre.setName(result.getString(2));
            }
            
        } catch (SQLException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
		
		return genre;
	}
	
	@Override
	public List<Movie> getMoviesByGenres(Genre genre) {
		String query = "";
		List<Genre> foundGenre = null;
		
		if (!genre.getName().isEmpty()) {
			//query = "SELECT * FROM genre WHERE name = ?";
			query = "SELECT * FROM movie WHERE genreId = (SELECT id FROM genre WHERE name = ?)";
			foundGenre = retrieveSuitableGenre(query, genre.getName());
		}
		
		int matches = 0, maxMatches = 0;
		List<Integer> genreAttributeMatches = new ArrayList<Integer>();
		
		if (foundGenre != null) {
			for (Genre temp : foundGenre) {
				matches = 0;
				
				if (temp.getName().equals(genre.getName()))
					matches++;
				
				if (matches > maxMatches)
					maxMatches = matches;
				
				genreAttributeMatches.add(matches);
			}
		}
		
		List<Integer> movieIds = new ArrayList<Integer>();
		
		for (int i = 0; i < genreAttributeMatches.size(); i++) 
			if (genreAttributeMatches.get(i) == maxMatches && !movieIds.contains(foundGenre.get(i).getId())) 
				movieIds.add(foundGenre.get(i).getId());
		
		List<Movie> retrievedMovies = new ArrayList<Movie>();
		
		for (Integer id : movieIds) 
			retrievedMovies.add(movieDAO.getMovieById(id));
		
		return retrievedMovies;
	}

	public List<Genre> retrieveSuitableGenre(String query, String option) {
		Genre genre = null;
		List<Genre> foundGenre = new ArrayList<Genre>();
		
		try {
			PreparedStatement prepStmt = connection.prepareStatement(query);
            prepStmt.setString(1, option);
            
            ResultSet resultSet = prepStmt.executeQuery();
            while (resultSet.next()) {
            	genre = new Genre();
                genre.setId(resultSet.getInt(1));
                genre.setName(resultSet.getString(2));
                foundGenre.add(genre);
                genre = null;
            }
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
		
		return foundGenre;
	}
}
