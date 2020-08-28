package lt.viko.eif.saitynas_final_project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Database object.
 * @author Rytis Simanavicius
 *
 */
public class SqlConnection {
	private Connection connection;
    private String url = "jdbc:mysql://localhost/saitynas_final_project?user=root&password=";

    public SqlConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException exc) {
            exc.printStackTrace();
        }
    }

    /**
     * Method used to establish connection to the database.
     * @return
     */
    public Connection getConnection() {
        return connection;
    }
}
