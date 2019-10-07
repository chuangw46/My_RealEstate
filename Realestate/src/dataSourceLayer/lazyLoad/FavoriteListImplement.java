package dataSourceLayer.lazyLoad;

import dbConfig.DBConnection;
import domainModels.Property;
import domainModels.User;
import utils.ConstructObjectFromDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * lazy load utility for client property favorite list
 */
public class FavoriteListImplement implements FavoriteList{
    private User client;
    private List<Property> favorites;

    public FavoriteListImplement(User client) {
        this.client = client;
        favorites = new ArrayList<>();
    }

    @Override
    public List<Property> getFavoriteList() {
        try {
            String selectStatement =
                    "SELECT * FROM client_likes_properties WHERE client_client_id = " + this.client.getId();
            PreparedStatement stmt = DBConnection.prepare(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Property temp = getAProperty(rs);
                // add each object to IdentityMap
                favorites.add(temp);
            }
        } catch (SQLException e) {
            System.out.println("SQLException ");
        }
        return favorites;
    }

    private Property getAProperty(ResultSet rs) throws SQLException {
        int p_id = rs.getInt(2);
        Property result = new Property();
        String selectStatement =
                "SELECT * FROM properties WHERE property_id = " + p_id;
        PreparedStatement stmt = DBConnection.prepare(selectStatement);
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()){
            result = ConstructObjectFromDB.constructPropertyByRS(resultSet);
        }
        return result;

    }


    @Override
    public void add(Property property) {

    }

    @Override
    public void remove(Property property) {

    }
}
