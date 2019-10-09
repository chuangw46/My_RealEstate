package dataSourceLayer.mappers.addressMapper;

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
public class AddressMapper extends DataMapper {
    //---------------------------- singleton pattern setup ---------------------------------------
    private static AddressMapper addressMapper;

    private AddressMapper() {
        //
    }

    public static AddressMapper getInstance() {
        if (addressMapper == null) {
            return new AddressMapper();
        }
        return addressMapper;
    }

    //------------------------- create, update, delete(Call by UoW) ------------------------------

    @Override
    public void create(Object o) {
        try {
            Address address = (Address) o;
            String insertStatement = ConstructAddressSQLStmt.getInsertStmt(address);
            PreparedStatement stmt = DBConnection.prepare(insertStatement);
            stmt.executeQuery();

            // Add to identity map
            AddressIdentityMapUtil.addToPKMap(address);
            AddressIdentityMapUtil.addToPostCodeMap(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object o){
        try {
            Address address = (Address) o;
            String updateStatement = ConstructAddressSQLStmt.getUpdateStmt(address);
            PreparedStatement stmt = DBConnection.prepare(updateStatement);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o){
        try {
            Address address = (Address) o;
            int a_id = address.getId();
            String deleteStatement = ConstructAddressSQLStmt.getDeleteStmt(a_id);
            System.out.println(deleteStatement);
            PreparedStatement stmt = DBConnection.prepare(deleteStatement);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            }

        } catch (SQLException e) {
            System.out.println("SQLException thrown");
        }
        return result;
    }


}
