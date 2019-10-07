package utils;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct sql statement for FavoriteList table
 */
public class ConstructFavoriteListSQLStmt {
    // get a delete statement by PID(property id)
    public static String getDeleteStmtByPID(int p_id) {
        return "DELETE FROM client_likes_properties WHERE property_property_id = " + p_id;
    }

    public static String getSelectStmt(int client_id) {
        return "SELECT * FROM client_likes_properties WHERE client_client_id = " + client_id;
    }

    // get a delete statement by both PID(property id) and CID(client id) - For unlike a property
    public static String getDeleteStmtByPIDCID(int client_id, int property_id) {
        return "DELETE FROM client_likes_properties \n" +
                "WHERE property_property_id = " + property_id + " " +
                "AND client_client_id = " + client_id;
    }

    public static String getInsertStmt(int client_id, int property_id) {
        return "INSERT INTO client_likes_properties " +
                        "(client_client_id, property_property_id)\n" +
                "VALUES (" +
                        client_id + ", " +
                        property_id + ")\n";
    }
}
