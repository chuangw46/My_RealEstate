package dbConfig;

import java.net.URI;
import java.net.URISyntaxException;
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
    private static String DB_URL;

    // Database credentials
    private static String DB_USER;
    private static String DB_PASSWORD;

    static Connection dbConnection = null;

    public static void parse_DATABASE_URL() {
        try {
            URI db_uri = new URI(System.getenv("DATABASE_URL"));
            if (db_uri.getUserInfo() != null) {
                DB_USER = db_uri.getUserInfo().split(":")[0];
                DB_PASSWORD = db_uri.getUserInfo().split(":")[1];
            }
            DB_URL = "jdbc:postgresql://" + db_uri.getHost() + db_uri.getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    
    public static PreparedStatement prepare(String stm) throws SQLException{
        parse_DATABASE_URL();
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
            dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

//            dbConnection.setAutoCommit(false);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Connection problem");
        return null;
    }
}
