package utils;

import models.Property;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct sql statement for properties table
 */
public class ConstructPropertySQLStmt{

    /**
     * get an insert statement
     * @param property
     * @return a SQL  INSERT statement which inserts a property into db table
     */
    public static String getInsertStmt(Property property) {
        return "INSERT INTO properties " +
                        "(property_type, " +
                        "num_bed, " +
                        "num_bath, " +
                        "num_carpark, " +
                        "date_available, " +
                        "date_inspection, " +
                        "description, " +
                        "fk_address_id, " +
                        "rent_or_buy, " +
                        "price, " +
                        "fk_agent_id)\n" +
                "VALUES ('" +
                        property.getType() + "', " +
                        property.getNum_bed() + ", " +
                        property.getNum_bath() + ", " +
                        property.getNum_carpark() + ", '" +
                        property.getDate_available() + "', '" +
                        property.getDate_inspection() + "', '" +
                        property.getDescription() + "', " +
                        property.getAddress_id() + ", '" +
                        property.getRent_or_buy() + "', " +
                        property.getPrice() + ", " +
                        property.getAgent_id() + "); ";
    }

    /**
     * get an update statement
     * @param property
     * @return a SQL UPDATE statement which updates the information of a property in db table
     */
    public static String getUpdateStmt(Property property) {
        return "UPDATE properties\n" +
                "SET property_type = '" + property.getType() + "', " +
                        "num_bed = " + property.getNum_bed() + ", " +
                        "num_bath = " + property.getNum_bath() + ", " +
                        "num_carpark = " + property.getNum_carpark() + ", " +
                        "date_available = '" + property.getDate_available() + "', " +
                        "date_inspection = '" + property.getDate_inspection() + "', " +
                        "description = '" + property.getDescription() + "', " +
                        "fk_address_id = " + property.getAddress_id()  + ", " +
                        "rent_or_buy = '" + property.getRent_or_buy() + "', " +
                        "price = " + property.getPrice() + ", " +
                        "fk_agent_id = " + property.getAgent_id() + "\n" +
                "WHERE property_id = " + property.getId() + ";" ;
    }

    /**
     * get a delete statement
     * @param p_id
     * @return a SQL DELETE statement which deletes the information of a property in db table
     */
    public static String getDeleteStmt(int p_id) {
        return "DELETE FROM properties WHERE property_id = " + p_id;
    }

    /**
     * get a select statement
     * @param p_id
     * @return a SQL SELECT statement which retrieves the information of a property in db table
     */
    public static String getSelectStmt(int p_id) {
        return "SELECT * FROM properties WHERE property_id = " + p_id;
    }

    public static String getSelectStmt(String property_type, int minBed, int maxBed, int minPrice, int maxPrice, int postCode) {
        return "SELECT p.*, a.* FROM properties AS p INNER JOIN address AS a \n" +
                "ON p.fk_address_id = a.address_id \n" +
                "WHERE " +
                "p.property_type = '" + property_type + "' " +
                "AND p.num_bed >= " + minBed + " AND p.num_bed <= " + maxBed + " " +
                "AND p.price >= " + minPrice + " AND p.price <= " + maxPrice + " " +
                "AND a.postal_code = " + postCode;
    }
}
