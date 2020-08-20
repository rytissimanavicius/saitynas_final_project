package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lt.viko.eif.saitynas_final_project.objects.Genre;

public class GenreDAOImpl implements GenreDAO{
private Connection connection;
	
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
	
	
}
