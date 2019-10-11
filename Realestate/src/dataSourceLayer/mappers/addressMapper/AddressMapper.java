package dataSourceLayer.mappers.addressMapper;

import dataSourceLayer.mappers.LockingMapper;
import dataSourceLayer.dbConfig.DBConnection;
import dataSourceLayer.mappers.DataMapper;
import models.Address;
import utils.ConstructAddressSQLStmt;
import utils.ConstructObjectFromDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * address data mapper implementation
 */
public class AddressMapper implements DataMapper {
    //---------------------------- singleton pattern setup ---------------------------------------
    private static DataMapper instance;
    private static AddressMapper addressMapper;

    private AddressMapper() {
        //
    }

    public static DataMapper getLockingMapperInstance() {
        if (instance == null) {
            instance = new LockingMapper(getSelfInstance());
        }
        return instance;
    }

    public static AddressMapper getSelfInstance() {
        if (addressMapper == null) {
            addressMapper = new AddressMapper();
        }
        return addressMapper;
    }

    //------------------------- create, update, delete(Call by UoW) ------------------------------

    @Override
    public void create(Object o) throws SQLException {
        Address address = (Address) o;
        int address_id;
        String insertStatement = ConstructAddressSQLStmt.getInsertStmt(address);
        PreparedStatement stmt = DBConnection.prepare(insertStatement);
        ResultSet rs = stmt.executeQuery();
        rs.next();

        address_id = rs.getInt(1);
        address.setId(address_id);
        AddressIdentityMapUtil.addToPKMap(address);
        AddressIdentityMapUtil.addToPostCodeMap(address);
        // close connections
        rs.close();
        stmt.close();
        DBConnection.close();
    }

    @Override
    public void update(Object o) throws SQLException {
        Address address = (Address) o;
        String updateStatement = ConstructAddressSQLStmt.getUpdateStmt(address);
        PreparedStatement stmt = DBConnection.prepare(updateStatement);
        stmt.executeUpdate();
        // close connections
        stmt.close();
        DBConnection.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        Address address = (Address) o;
        int a_id = address.getId();
        String deleteStatement = ConstructAddressSQLStmt.getDeleteStmt(a_id);
        System.out.println(deleteStatement);
        PreparedStatement stmt = DBConnection.prepare(deleteStatement);
        stmt.executeUpdate();
        // close connections
        stmt.close();
        DBConnection.close();
    }

    //------------------- read operations (Called by service layer directly) -------------------

    public Address getAddressByID(int id) {
        Address result = AddressIdentityMapUtil.getAddressByID(id);

        try {
            if (result == null) {
                // get the object from database
                String selectStatement = ConstructAddressSQLStmt.getSelectByIDStmt(id);
                PreparedStatement stmt = DBConnection.prepare(selectStatement);

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    result = ConstructObjectFromDB.constructAddressByRS(rs);
                    // add the object to IdentityMap
                    AddressIdentityMapUtil.addToPKMap(result);
                }
                // close connections
                rs.close();
                stmt.close();
                DBConnection.close();

            }
        } catch (SQLException e) {
            System.out.println("SQLException thrown");
        }
        return result;
    }

    public List<Address> getAllAddressByPostCode(int postcode) {
        List<Address> result = AddressIdentityMapUtil.getAddressByPostCode(postcode);
        try {
            if (result == null) {
                // get all objects from database
                String selectStatement = ConstructAddressSQLStmt.getSelectByPostCodeStmt(postcode);
                PreparedStatement stmt = DBConnection.prepare(selectStatement);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Address temp = ConstructObjectFromDB.constructAddressByRS(rs);
                    // add each object to IdentityMap
                    AddressIdentityMapUtil.addToPostCodeMap(temp);
                }
                result = AddressIdentityMapUtil.getAddressByPostCode(postcode);
                // close connections
                rs.close();
                stmt.close();
                DBConnection.close();
            }

        } catch (SQLException e) {
            System.out.println("SQLException thrown");
        }
        return result;
    }

    public int createAndGetID(Object o) throws SQLException {
        Address address = (Address) o;
        int address_id;
        String insertStatement = ConstructAddressSQLStmt.getInsertStmt(address);
        PreparedStatement stmt = DBConnection.prepare(insertStatement);
        ResultSet rs = stmt.executeQuery();
        rs.next();

        //TODO: Add to identity map
        address_id = rs.getInt(1);
        address.setId(address_id);
        AddressIdentityMapUtil.addToPKMap(address);
        AddressIdentityMapUtil.addToPostCodeMap(address);

        // close connections
        rs.close();
        stmt.close();
        DBConnection.close();

        return address_id;
    }


}
