package dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class DBConnection {
    // JDBC driver name and database URL
    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/Realestate";

    // Database credentials
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";
    
    static Connection dbConnection = null;
    
    public static PreparedStatement prepare(String stm) throws SQLException{
        PreparedStatement preparedStatement = null;
        try {
            Connection dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(stm);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return preparedStatement;
    }

    private static Connection getDBConnection() {
        try {
            // register JDBC driver
            DriverManager.registerDriver(new org.postgresql.Driver());

            // open a connection
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            dbConnection.setAutoCommit(false);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Connection problem");
        return null;
    }
}
