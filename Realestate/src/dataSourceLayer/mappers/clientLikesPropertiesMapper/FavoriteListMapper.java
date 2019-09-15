package dataSourceLayer.mappers.clientLikesPropertiesMapper;

import dbConfig.DBConnection;
import utils.ConstructFavoriteListSQLStmt;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * Favorite List data mapper implementation
 */

public class FavoriteListMapper implements FavoriteListMapperI{
    @Override
    public boolean deleteRowByPropertyID(int p_id) {
        try {
            String deleteStatement = ConstructFavoriteListSQLStmt.getDeleteStmt(p_id);
            PreparedStatement stmtForAST = DBConnection.prepare(deleteStatement);
            stmtForAST.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
