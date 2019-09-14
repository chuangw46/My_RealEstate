package lazyLoad;

import dbConfig.DBConnection;
import models.Property;
import models.User;

import java.sql.Date;
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
            int id = resultSet.getInt(1);
            String p_type = resultSet.getString(2);
            int num_bed = resultSet.getInt(3);
            int num_bath = resultSet.getInt(4);
            int num_carpark = resultSet.getInt(5);
            Date date_available = resultSet.getDate(6);
            Date date_inpection = resultSet.getDate(7);
            String description = resultSet.getString(8);
            int address_id = resultSet.getInt(9);
            String rent_or_buy = resultSet.getString(10);
            int price = resultSet.getInt(11);
            int agent_id = resultSet.getInt(12);


            result = new Property(id,p_type,num_bed,num_bath,num_carpark,date_available,
                    date_inpection,description,address_id, rent_or_buy, price, agent_id);
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
