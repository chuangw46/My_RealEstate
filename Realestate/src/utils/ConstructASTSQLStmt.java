package utils;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class ConstructASTSQLStmt {
    public static String getDeleteStmt(int p_id) {
        return "DELETE FROM client_likes_properties WHERE property_id = " + p_id;
    }
}
