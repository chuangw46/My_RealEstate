package utils;

import models.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct an object for corresponding tables in db
 */

public class ConstructObjectFromDB {
    /**
     * retrieve data from db and create an address object
     * @param rs
     * @return an address object constructed by using data retrieved from db
     * @throws SQLException
     */
    public static Address constructAddressByRS(ResultSet rs) throws SQLException {
        int a_id = rs.getInt(1);
        String a_street = rs.getString(2);
        String a_city = rs.getString(3);
        String a_state = rs.getString(4);
        int a_postal_code = rs.getInt(5);
        String a_country = rs.getString(6);
        return new Address(a_id, a_street, a_city, a_state, a_postal_code, a_country);
    }

    /**
     * retrieve data from db and create a property object
     * @param rs
     * @return a property object constructed by using data retrieved from db
     * @throws SQLException
     */
    public static Property constructPropertyByRS(ResultSet rs) throws SQLException {
        Property result;
        int id = rs.getInt(1);
        String p_type = rs.getString(2);
        int num_bed = rs.getInt(3);
        int num_bath = rs.getInt(4);
        int num_carpark = rs.getInt(5);
        Date date_available = rs.getDate(6);
        Date date_inpection = rs.getDate(7);
        String description = rs.getString(8);
        int address_id = rs.getInt(9);
        String rent_or_buy = rs.getString(10);
        int price = rs.getInt(11);
        int agent_id = rs.getInt(12);

        result = new Property(id,p_type,num_bed,num_bath,num_carpark,date_available,
                date_inpection,description,address_id, rent_or_buy, price, agent_id);
        return result;
    }

    /**
     * retrieve data from db and create an agent object
     * @param rs
     * @return an agent object constructed by using data retrieved from db
     * @throws SQLException
     */
    public static User constructAgentByRS(ResultSet rs) throws SQLException {
        int u_id = rs.getInt(1);
        String u_email = rs.getString(2);
        String u_pw = rs.getString(3);
        String u_phone = rs.getString(4);
        String u_company_name = rs.getString(5);
        String u_company_address = rs.getString(6);
        String u_company_website = rs.getString(7);
        String u_bio = rs.getString(8);
        String u_name = rs.getString(9);

        return new Agent(u_id,u_email,u_pw,u_name,u_phone,u_bio, u_company_name,
                u_company_address, u_company_website);
    }

    /**
     * retrieve data from db and create a client object
     * @param rs
     * @return a client object constructed by using data retrieved from db
     * @throws SQLException
     */
    public static User constructClientByRS(ResultSet rs) throws SQLException {
        int u_id = rs.getInt(1);
        String u_email = rs.getString(2);
        String u_pw = rs.getString(3);
        String u_name = rs.getString(4);
        return new Client(u_id, u_email, u_pw, u_name);
    }
}
