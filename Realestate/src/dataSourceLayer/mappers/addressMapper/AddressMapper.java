package dataSourceLayer.mappers.addressMapper;

import dbConfig.DBConnection;
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
public class AddressMapper implements AddressMapperInterface {

    @Override
    public int createAddress(Address address) {
        try {
            String insertStatetment = ConstructAddressSQLStmt.getInsertStmt(address);
            PreparedStatement stmt = DBConnection.prepare(insertStatetment);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Address getAddressByID(int id) {
        Address result = AddressIdentityMapUtil.getAddressByID(id);

        try {
            if (result == null) {
                // get the object from database
                String selectStatement = "SELECT * FROM address WHERE address_id = " + id;
                PreparedStatement stmt = DBConnection.prepare(selectStatement);

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    result = ConstructObjectFromDB.constructAddressByRS(rs);
                    // add the object to IdentityMap
                    AddressIdentityMapUtil.addToPKMap(result);
                }

            }
        } catch (SQLException e) {
            System.out.println("SQLException thrown");
        }
        return result;
    }

    @Override
    public List<Address> getAllAddressByPostCode(int postcode) {
        List<Address> result = AddressIdentityMapUtil.getAddressByPostCode(postcode);
        try {
            if (result == null) {
                // get all objects from database
                String selectStatement = "SELECT * FROM address WHERE postal_code = " + postcode;
                PreparedStatement stmt = DBConnection.prepare(selectStatement);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Address temp = ConstructObjectFromDB.constructAddressByRS(rs);
                    // add each object to IdentityMap
                    AddressIdentityMapUtil.addToPostCodeMap(temp);
                }
                result = AddressIdentityMapUtil.getAddressByPostCode(postcode);
            }

        } catch (SQLException e) {
            System.out.println("SQLException thrown");
        }
        return result;
    }

    @Override
    public boolean updateAddress(Address address) {
        try {
            String updateStatement = ConstructAddressSQLStmt.getUpdateStmt(address);
            PreparedStatement stmt = DBConnection.prepare(updateStatement);
            stmt.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public void deleteAddress(Address address) {

    }


}
