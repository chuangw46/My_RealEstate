package utils;

import domainModels.Address;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct sql statement for address table
 */
public class ConstructAddressSQLStmt {

    /**
     * construct select statement which selects row by address id
     * @param id
     * @return a select sql statement
     */
    public static String getSelectByIDStmt(int id){
        return "SELECT * FROM address WHERE address_id = " + id;
    }

    /**
     * construct select statement which selects rows by postcode
     * @param postcode
     * @return a select sql statement
     */
    public static String getSelectByPostCodeStmt(int postcode){
        return "SELECT * FROM address WHERE postal_code = " + postcode;
    }


    /**
     * get INSERT INTO statement
     * @param address
     * @return an insert sql statement
     */
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

    /**
     * get UPDATE statement
     * @param address
     * @return an update sql statement
     */
    public static String getUpdateStmt(Address address) {
        return "UPDATE address\n" +
                "SET street = '" + address.getStreet() + "', " +
                        "city = '" + address.getCity() + "', " +
                        "state = '" + address.getState() + "', " +
                        "postal_code = " + address.getPostal_code() + ", " +
                        "country = '" + address.getCountry() + "'\n" +
                "WHERE address_id = " + address.getId() + ";" ;
    }

    /**
     * get DELETE statement
     * @param a_id
     * @return a delete sql statement
     */
    public static String getDeleteStmt(int a_id) {
        return "DELETE FROM address WHERE address_id = " + a_id;
    }
}
