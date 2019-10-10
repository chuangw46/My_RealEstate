package dataSourceLayer.dbConfig;

import java.sql.*;


public class DBConnection {

    // connect to remote db
    private static final String DB_CONNECTION = "jdbc:postgresql://ec2-50-19-127-115.compute-1.amazonaws.com:5432/df5uakcna1c3eu";
    private static final String DB_USER = "lwwlyjnepkwqkh";
    private static final String DB_PASSWORD = "0a11fef283e2e84c96c18b3b9b245ce61b30a26f8dca06a5b039f383f0ab8325";

    // connect to local db
//    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/Realestate";
//    private static final String DB_USER = "postgres";
//    private static final String DB_PASSWORD = "postgres";

    static Connection dbConnection = null;

    public static PreparedStatement prepare(String stm) throws SQLException {

        try {
            Connection dbConnection = getDBConnection();
            PreparedStatement preparedStatement = dbConnection.prepareStatement(stm);

            return preparedStatement;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static Connection getDBConnection() {

        try {
            DriverManager.registerDriver(new org.postgresql.Driver());

            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            return dbConnection;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Connection Problem");
        return null;
    }

    public static Connection getConnection() {
        return dbConnection;
    }
}