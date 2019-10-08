package dataSourceLayer.mappers.addressMapper;

import dataSourceLayer.dbConfig.DBConnection;
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
public class AddressMapper implements AddressMapperI {

    @Override
    public int createAddress(Address address) {
        try {
            String insertStatetment = ConstructAddressSQLStmt.getInsertStmt(address);
            PreparedStatement stmt = DBConnection.prepare(insertStatetment);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            //TODO: Add to identity map
            AddressIdentityMapUtil.addToPKMap(address);
            AddressIdentityMapUtil.addToPostCodeMap(address);
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
                String selectStatement = ConstructAddressSQLStmt.getSelectByIDStmt(id);
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
                String selectStatement = ConstructAddressSQLStmt.getSelectByPostCodeStmt(postcode);
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
    public boolean deleteAddressByID(int a_id) {
        try {
            String deleteStatement = ConstructAddressSQLStmt.getDeleteStmt(a_id);
            System.out.println(deleteStatement);
            PreparedStatement stmt = DBConnection.prepare(deleteStatement);
            stmt.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;

    }


}
