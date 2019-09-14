package dataSourceLayer.mappers.propertyMapper;

import dbConfig.DBConnection;
import models.Property;
import utils.ConstructObjectFromDB;
import utils.ConstructPropertySQLStmt;

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
public class PropertyMapper implements PropertyMapperInterface {

    /**
     * Feature A - only agents have the permission to create a property information
     * the permission check is done on the domain logic layer
     * @param property
     */
    @Override
    public void createProperty(Property property) {
        try {
            String insertStatetment = ConstructPropertySQLStmt.getInsertStmt(property);
            PreparedStatement stmt = DBConnection.prepare(insertStatetment);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Feature A - return a list of properties that the agent posted before
     * the permission check is done on the domain logic layer
     * @param agentID
     * @return a list of properties that the agent posted before
     */
    @Override
    public List<Property> searchByAgentID(int agentID) {
        List<Property> result = PropertyIdentityMapUtil.getPropertyByAgentID(agentID);
        try {
            if (result == null) {
                result = new ArrayList<>();
                // get all objects from database
                String selectStatement = "SELECT * FROM properties WHERE fk_agent_id = " + agentID;
                PreparedStatement stmt = DBConnection.prepare(selectStatement);
                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    Property p = ConstructObjectFromDB.constructPropertyByRS(resultSet);
                    result.add(p);
                    PropertyIdentityMapUtil.addToPropertyAgentMap(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Feature A - only agents have the permission to update a property information
     * the permission check is done on the domain logic layer
     * @param property
     */
    @Override
    public void updateProperty(Property property) {
        try {
            String updateStatement = ConstructPropertySQLStmt.getUpdateStmt(property);
            System.out.println(updateStatement);
            PreparedStatement stmt = DBConnection.prepare(updateStatement);
            int i = stmt.executeUpdate();
            System.out.println(i + " row is changed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Feature A - only agents have the permission to delete a property
     * the permission check is done on the domain logic layer
     * @param property
     */
    @Override
    public void deleteProperty(Property property) {
        try {
            String deleteStatement = ConstructPropertySQLStmt.getDeleteStmt(property);
            System.out.println(deleteStatement);
            PreparedStatement stmt = DBConnection.prepare(deleteStatement);
            int i = stmt.executeUpdate();
            System.out.println(i + " row is changed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: Feature B
    @Override
    public List<Property> searchByPostCode(int postCode) {
        return null;
    }

    // TODO: Feature B
    @Override
    public List<Property> searchByPropertyType(String type) {
        return null;
    }

    // TODO: Feature B
    @Override
    public List<Property> searchByRoomSize(int minBed, int maxBed) {
        return null;
    }

    // TODO: Feature B
    @Override
    public List<Property> searchByPrice(int minPrice, int maxPrice) {
        return null;
    }
}
