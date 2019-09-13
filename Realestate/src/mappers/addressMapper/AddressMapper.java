package mappers.addressMapper;

import dbConfig.DBConnection;
import models.Address;

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
    public void createAddress(Address address) {

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
                    result = getAddressHelper(rs);
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
                    Address temp = getAddressHelper(rs);
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
    public void updateAddress(Address address) {

    }

    @Override
    public void deleteAddress(Address address) {

    }

    private Address getAddressHelper(ResultSet rs) throws SQLException {
        int a_id = rs.getInt(1);
        String a_street = rs.getString(2);
        String a_city = rs.getString(3);
        String a_state = rs.getString(4);
        int a_postal_code = rs.getInt(5);
        String a_country = rs.getString(6);
        return new Address(a_id, a_street, a_city, a_state, a_postal_code, a_country);
    }
}
