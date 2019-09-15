package dataSourceLayer.mappers.propertyMapper;

import dataSourceLayer.mappers.addressMapper.AddressMapper;
import dataSourceLayer.mappers.addressMapper.AddressMapperI;
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
public class PropertyMapper implements PropertyMapperI {

    /**
     * Feature A - only agents have the permission to create a property information
     * the permission check is done on the domain logic layer
     * @param property
     */
    @Override
    public boolean createProperty(Property property) {
        try {
            String insertStatetment = ConstructPropertySQLStmt.getInsertStmt(property);
            PreparedStatement stmt = DBConnection.prepare(insertStatetment);
            stmt.executeUpdate();
            PropertyIdentityMapUtil.addToPropertyIDMap(property);
            PropertyIdentityMapUtil.addToPropertyAgentMap(property);
        } catch (SQLException e) {
            return false;
        }
        return true;
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
    public boolean updateProperty(Property property) {
        try {
            String updatePropertyStatement = ConstructPropertySQLStmt.getUpdateStmt(property);
            AddressMapperI am = new AddressMapper();
            // update the address first
            if (am.updateAddress(property.retrieveTheAddressObj())){
                // update property
                PreparedStatement stmt = DBConnection.prepare(updatePropertyStatement);
                stmt.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    /**
     * Feature A - only agents have the permission to delete a property
     * the permission check is done on the domain logic layer
     * @param property_id
     */
    @Override
    public boolean deleteProperty(int agent_id, int property_id) {
        try {
            // delete from property table - PT stands for property table
            String deleteFromPropertyTable = ConstructPropertySQLStmt.getDeleteStmt(property_id);
            PreparedStatement stmtForPT = DBConnection.prepare(deleteFromPropertyTable);
            stmtForPT.executeUpdate();
            PropertyIdentityMapUtil.deleteFromPropertyIDMap(property_id);
            PropertyIdentityMapUtil.deleteFromPropertyAgentMap(agent_id, property_id);

        } catch (SQLException e) {
            return false;
        }
        return true;
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

    @Override
    public Property searchByPropertyID(int property_id) {
        Property result = PropertyIdentityMapUtil.getPropertyByPID(property_id);
        try {
            if (result == null) {
                // get the object from database
                String selectStatement = ConstructPropertySQLStmt.getSelectStmt(property_id);
                PreparedStatement stmt = DBConnection.prepare(selectStatement);

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    result = ConstructObjectFromDB.constructPropertyByRS(rs);
                    // add the object to IdentityMap
                    PropertyIdentityMapUtil.addToPropertyIDMap(result);
                }
            }
        } catch (SQLException e) {
            return null;
        }
        return result;
    }
}
