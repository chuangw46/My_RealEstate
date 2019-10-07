package dataAccess.mappers.favoriteList;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

import model.Property;

import java.util.List;

/**
 * Favorite List data mapper interface
 */
public interface FavoriteListMapperI {
    /**
     * get a list of properties objects based on client id
     * @param client_id
     * @return A list of properties that the client likes
     */
    public List<Property> getFavoriteProperties(int client_id);

    /**
     * If a property was deleted by its agent, then delete all rows from AST containing the property
     * In other words, make the property unavailable for those who favorite it
     * @param property_id
     * @return true if delete is done, false if exception is thrown
     */
    public boolean deleteRowsByPropertyID(int property_id);

    /**
     * If a client likes a property, then add a row to this table
     * @param client_id
     * @param property_id
     * @return true if delete is done, false if exception is thrown
     */
    public boolean likeAProperty(int client_id, int property_id);

    /**
     * If a client unlikes a property, the delete a single row from AST
     * @param client_id
     * @param property_id
     * @return true if delete is done, false if exception is thrown
     */
    public boolean unlikeProperty(int client_id, int property_id);
}
