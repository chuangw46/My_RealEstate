package dataAccess.mappers.propertyMapper;

import model.Property;

import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * Property data mapper interface
 */
public interface PropertyMapperI {
    /**
     * Feature A - only agents have the permission to create a property information
     * the permission check is done on the domain logic layer
     * @param property
     */
    public boolean createProperty(Property property); // create

    /**
     * Feature A - return a list of properties that the agent posted before
     * the permission check is done on the domain logic layer
     * @param agentID
     * @return a list of properties that the agent posted before
     */
    public List<Property> searchByAgentID(int agentID);

    /**
     * Feature A - only agents have the permission to update a property information
     * the permission check is done on the domain logic layer
     * @param property
     */
    public boolean updateProperty(Property property);


    /**
     * Feature A - only agents have the permission to delete a property
     * the permission check is done on the domain logic layer
     * @param agent_id
     * @param p_id
     * @return
     */
    public boolean deleteProperty(int agent_id, int p_id);


    /**
     * retrieve properties by adding those filters
     * @param property_type
     * @param minBed
     * @param maxBed
     * @param minPrice
     * @param maxPrice
     * @param postCode
     * @return a list of properties that satisfy those criteria
     */
    public List<Property> searchByAllFilters(String property_type, int minBed, int maxBed,
                                             int minPrice, int maxPrice, int postCode);

    public Property searchByPropertyID(int property_id);
}
