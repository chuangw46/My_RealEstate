package utils;

import models.Address;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class ConstructAddressSQLStmt {

    public static String getInsertStmt(Address address) {
        return "INSERT INTO address " +
                        "(street, " +
                        "city, " +
                        "state, " +
                        "postal_code, " +
                        "country)\n" +
                "VALUES ('" +
                        address.getStreet() + "', '" +
                        address.getCity() + "', '" +
                        address.getState() + "', " +
                        address.getPostal_code() + ", '" +
                        address.getCountry() + "')\n" +
                "RETURNING address_id;";
    }

    public static String getUpdateStmt(Address address) {
        return "UPDATE address\n" +
                "SET street = '" + address.getStreet() + "', " +
                        "city = '" + address.getCity() + "', " +
                        "state = '" + address.getState() + "', " +
                        "postal_code = " + address.getPostal_code() + "', " +
                        "country = '" + address.getCountry() + "\n" +
                "WHERE address_id = " + address.getId() + ";" ;
    }
}
